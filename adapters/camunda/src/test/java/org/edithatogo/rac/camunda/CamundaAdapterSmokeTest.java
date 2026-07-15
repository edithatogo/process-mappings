package org.edithatogo.rac.camunda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

class CamundaAdapterSmokeTest {
  private static final String BPMN = "/adverse-incident-open-disclosure.bpmn";
  private static final String BPMN_NS = "http://www.omg.org/spec/BPMN/20100524/MODEL";

  @Test
  void modelHasStableProcessAndBoundaryIds() throws Exception {
    Document document = loadModel();
    Element process = (Element) document.getElementsByTagNameNS(BPMN_NS, "process").item(0);
    assertEquals("pic_adverse_incident_open_disclosure_v1", process.getAttribute("id"));
    assertEquals("true", process.getAttribute("isExecutable"));

    NodeList ids = document.getElementsByTagNameNS(BPMN_NS, "*");
    Set<String> seen = new HashSet<>();
    for (int index = 0; index < ids.getLength(); index++) {
      Element element = (Element) ids.item(index);
      String id = element.getAttribute("id");
      if (!id.isBlank()) {
        assertTrue(seen.add(id), "duplicate BPMN id: " + id);
      }
    }
  }

  @Test
  void modelKeepsHumanTaskTimerAndRuleWorkerBoundaries() throws Exception {
    Document document = loadModel();
    assertNotNull(elementById(document, "human_review_disclosure"));
    assertNotNull(elementById(document, "human_technical_escalation"));
    assertNotNull(elementById(document, "timer_follow_up_due"));
    assertNotNull(elementById(document, "pic_rule_normalize_event"));
    assertNotNull(elementById(document, "pic_rule_record_learning"));
    assertEquals(1, document.getElementsByTagNameNS(BPMN_NS, "timerEventDefinition").getLength());
    assertEquals(2, document.getElementsByTagNameNS(BPMN_NS, "userTask").getLength());
  }

  private Document loadModel() throws Exception {
    try (InputStream stream = getClass().getResourceAsStream(BPMN)) {
      assertNotNull(stream);
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
      if (id.equals(element.getAttribute("id"))) {
        return element;
      }
    }
    return null;
  }
}
