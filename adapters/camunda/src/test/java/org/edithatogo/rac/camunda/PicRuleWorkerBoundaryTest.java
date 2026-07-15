package org.edithatogo.rac.camunda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import org.junit.jupiter.api.Test;

class PicRuleWorkerBoundaryTest {
  @Test
  void normalizesOnlyTheTransportRepresentation() {
    PicRuleWorkerBoundary.WorkerResult result = PicRuleWorkerBoundary.invoke(
        PicRuleWorkerBoundary.NORMALIZE_EVENT,
        Map.of("correlationId", "corr-1", "incidentId", "inc-1", "observedEvent", "  observed  "));

    assertEquals("observed", result.output().get("normalizedEvent"));
    assertEquals("normalized", result.output().get("normalizationStatus"));
    assertEquals("corr-1", result.output().get("correlationId"));
  }

  @Test
  void recordsOnlyHumanApprovedLearning() {
    PicRuleWorkerBoundary.WorkerResult result = PicRuleWorkerBoundary.invoke(
        PicRuleWorkerBoundary.RECORD_LEARNING,
        Map.of(
            "correlationId", "corr-1",
            "incidentId", "inc-1",
            "learningAction", "  review handoff  ",
            "humanApprovedLearning", "true"));

    assertEquals("review handoff", result.output().get("learningAction"));
    assertEquals("recorded", result.output().get("learningRecordStatus"));
  }

  @Test
  void missingInputsAndNonHumanLearningFailWithTheBpmnErrorCode() {
    IllegalArgumentException missing = assertThrows(
        IllegalArgumentException.class,
        () -> PicRuleWorkerBoundary.invoke(
            PicRuleWorkerBoundary.NORMALIZE_EVENT,
            Map.of("correlationId", "corr-1", "incidentId", "inc-1")));
    assertEquals(true, missing.getMessage().startsWith("PIC_TECHNICAL_WORKER_ERROR:"));

    IllegalArgumentException unapproved = assertThrows(
        IllegalArgumentException.class,
        () -> PicRuleWorkerBoundary.invoke(
            PicRuleWorkerBoundary.RECORD_LEARNING,
            Map.of("correlationId", "corr-1", "incidentId", "inc-1", "learningAction", "action")));
    assertEquals(true, unapproved.getMessage().startsWith("PIC_TECHNICAL_WORKER_ERROR:"));
  }

  @Test
  void unknownWorkerTypeFailsDeterministically() {
    IllegalArgumentException error = assertThrows(
        IllegalArgumentException.class,
        () -> PicRuleWorkerBoundary.invoke("unknown", Map.of()));
    assertEquals(true, error.getMessage().startsWith("PIC_TECHNICAL_WORKER_ERROR:"));
  }
}
