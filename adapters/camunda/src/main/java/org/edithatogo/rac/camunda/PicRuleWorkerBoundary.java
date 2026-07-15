package org.edithatogo.rac.camunda;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Deterministic boundary used by a Camunda job worker or an equivalent REST
 * adapter. It validates transport inputs and performs no policy judgement.
 */
public final class PicRuleWorkerBoundary {
  public static final String NORMALIZE_EVENT = "pic-rule-normalize-event";
  public static final String RECORD_LEARNING = "pic-record-learning";

  private PicRuleWorkerBoundary() {}

  public static WorkerResult invoke(String taskType, Map<String, String> input) {
    return switch (taskType) {
      case NORMALIZE_EVENT -> normalizeEvent(input);
      case RECORD_LEARNING -> recordLearning(input);
      default -> throw technicalError("unknown worker type: " + taskType);
    };
  }

  private static WorkerResult normalizeEvent(Map<String, String> input) {
    String correlationId = required(input, "correlationId");
    String incidentId = required(input, "incidentId");
    String observedEvent = required(input, "observedEvent");
    Map<String, String> output = new LinkedHashMap<>();
    output.put("correlationId", correlationId);
    output.put("incidentId", incidentId);
    output.put("normalizedEvent", observedEvent.trim());
    output.put("normalizationStatus", "normalized");
    return new WorkerResult(NORMALIZE_EVENT, output);
  }

  private static WorkerResult recordLearning(Map<String, String> input) {
    String correlationId = required(input, "correlationId");
    String incidentId = required(input, "incidentId");
    String learningAction = required(input, "learningAction");
    if (!"true".equalsIgnoreCase(input.get("humanApprovedLearning"))) {
      throw technicalError("human-approved learning action is required");
    }
    Map<String, String> output = new LinkedHashMap<>();
    output.put("correlationId", correlationId);
    output.put("incidentId", incidentId);
    output.put("learningAction", learningAction.trim());
    output.put("learningRecordStatus", "recorded");
    return new WorkerResult(RECORD_LEARNING, output);
  }

  private static String required(Map<String, String> input, String key) {
    String value = input.get(key);
    if (value == null || value.isBlank()) {
      throw technicalError("missing required input: " + key);
    }
    return value;
  }

  private static IllegalArgumentException technicalError(String message) {
    return new IllegalArgumentException("PIC_TECHNICAL_WORKER_ERROR: " + message);
  }

  public record WorkerResult(String taskType, Map<String, String> output) {}
}
