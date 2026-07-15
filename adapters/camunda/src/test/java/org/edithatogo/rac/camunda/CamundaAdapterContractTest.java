package org.edithatogo.rac.camunda;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class CamundaAdapterContractTest {
  private static final String BPMN = "/adverse-incident-open-disclosure.bpmn";
  private static final String BPMN_NS = "http://www.omg.org/spec/BPMN/20100524/MODEL";
  private static final String ZEEBE_NS = "http://camunda.org/schema/zeebe/1.0";
  private static final Set<String> REQUIRED_VARIABLES = Set.of(
      "correlationId", "incidentId", "observedEvent", "learningAction");

  @Test
  void demonstratorSatisfiesTheExecutableContract() throws Exception {
    assertDoesNotThrow(() -> validate(loadModel()));
  }

  @Test
  void duplicateIdsAreRejected() throws Exception {
    Document document = loadModel();
    elementById(document, "end_learning_recorded").setAttribute("id", "start_incident_received");
    assertThrows(AssertionError.class, () -> validate(document));
  }

  @Test
  void missingHumanTaskIsRejected() throws Exception {
    Document document = loadModel();
    Element humanTask = elementById(document, "human_review_disclosure");
    humanTask.getParentNode().removeChild(humanTask);
    assertThrows(AssertionError.class, () -> validate(document));
  }

  @Test
  void unboundedRetryIsRejected() throws Exception {
    Document document = loadModel();
    Element task = elementById(document, "pic_rule_normalize_event");
    Element definition = childByName(task, "taskDefinition");
    definition.setAttribute("retries", "0");
    assertThrows(AssertionError.class, () -> validate(document));
  }

  @Test
  void untypedVariableMappingIsRejected() throws Exception {
    Document document = loadModel();
    Element task = elementById(document, "pic_rule_normalize_event");
    Element input = childByName(task, "input");
    input.setAttribute("source", "");
    assertThrows(AssertionError.class, () -> validate(document));
  }

  private void validate(Document document) {
    Element process = (Element) document.getElementsByTagNameNS(BPMN_NS, "process").item(0);
    assertEquals("pic_adverse_incident_open_disclosure_v1", process.getAttribute("id"));
    assertEquals("true", process.getAttribute("isExecutable"));

    Set<String> ids = new HashSet<>();
    NodeList bpmnElements = document.getElementsByTagNameNS(BPMN_NS, "*");
    for (int index = 0; index < bpmnElements.getLength(); index++) {
      Element element = (Element) bpmnElements.item(index);
      String id = element.getAttribute("id");
      if (!id.isBlank()) {
        assertTrue(ids.add(id), "duplicate BPMN id: " + id);
      }
    }

    assertEquals(2, document.getElementsByTagNameNS(BPMN_NS, "userTask").getLength());
    assertTrue(elementById(document, "human_review_disclosure") != null);
    assertTrue(elementById(document, "human_technical_escalation") != null);
    assertEquals(1, document.getElementsByTagNameNS(BPMN_NS, "timerEventDefinition").getLength());
    Element timer = (Element) document.getElementsByTagNameNS(BPMN_NS, "timeDuration").item(0);
    assertEquals("PT24H", timer.getTextContent());

    assertRuleWorker(document, "pic_rule_normalize_event", "pic-rule-normalize-event");
    assertRuleWorker(document, "pic_rule_record_learning", "pic-record-learning");
  }

  private void assertRuleWorker(Document document, String taskId, String taskType) {
    Element task = elementById(document, taskId);
    assertTrue(task != null);
    Element definition = childByName(task, "taskDefinition");
    assertEquals(taskType, definition.getAttribute("type"));
    int retries = Integer.parseInt(definition.getAttribute("retries"));
    assertTrue(retries >= 1 && retries <= 3, "retry count must be bounded: " + retries);

    Element mapping = childByName(task, "ioMapping");
    Set<String> mappedTargets = new HashSet<>();
    NodeList inputs = mapping.getElementsByTagNameNS(ZEEBE_NS, "input");
    for (int index = 0; index < inputs.getLength(); index++) {
      Element input = (Element) inputs.item(index);
      String source = input.getAttribute("source");
      String target = input.getAttribute("target");
      assertTrue(source.startsWith("=") && source.length() > 1, "variable source must be typed: " + source);
      assertTrue(REQUIRED_VARIABLES.contains(target), "unknown variable target: " + target);
      assertTrue(mappedTargets.add(target), "duplicate variable target: " + target);
    }
    assertTrue(mappedTargets.contains("correlationId"));
    assertTrue(mappedTargets.contains("incidentId"));
    assertEquals(3, mappedTargets.size());
  }

  private Document loadModel() throws Exception {
    try (InputStream stream = getClass().getResourceAsStream(BPMN)) {
      if (stream == null) throw new AssertionError("missing BPMN resource");
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setNamespaceAware(true);
      factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
      return factory.newDocumentBuilder().parse(stream);
    }
  }

  private Element elementById(Document document, String id) {
    NodeList elements = document.getElementsByTagNameNS(BPMN_NS, "*");
    for (int index = 0; index < elements.getLength(); index++) {
      Element element = (Element) elements.item(index);
      if (id.equals(element.getAttribute("id"))) return element;
    }
    return null;
  }

  private Element childByName(Element parent, String localName) {
    NodeList children = parent.getElementsByTagNameNS(ZEEBE_NS, localName);
    if (children.getLength() == 0) throw new AssertionError("missing zeebe:" + localName);
    Node child = children.item(0);
    return (Element) child;
  }
}
