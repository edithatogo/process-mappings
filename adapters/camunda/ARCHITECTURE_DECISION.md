# ADR-001: Optional Camunda 8 adapter

Status: **accepted for the candidate demonstrator; implementation remains
non-normative and isolated**.

Date: 2026-07-15

## Decision

Use Camunda Process Test (CPT) with the Camunda Java client, JUnit 5, Java 17,
and the Testcontainers runtime. Pin the stable Camunda dependency line to
`8.9.12` for the first reproducible adapter experiment. Camunda 8.10 alpha
artifacts are not used as conformance evidence.

The first demonstrator is the human-certified adverse-incident/open-disclosure
process project from Track #41. The adapter will demonstrate orchestration,
human tasks, timers, technical errors, and trace projection. It will not decide
whether an incident is reportable, whether disclosure is legally sufficient, or
whether a clinical, organisational, funding, or regulatory outcome is correct.

## Boundaries

- PIC schemas and validators remain usable without Java, Docker, Camunda, BPMN,
  DMN, or FEEL.
- BPMN owns orchestration and waiting; deterministic workers invoke PIC/rule
  services across an explicit boundary.
- Human tasks own legal, clinical, ethical, disclosure, and governance judgement.
- BPMN gateways may branch only on typed worker outputs or explicit human task
  outcomes; substantive policy rules are not duplicated in BPMN or DMN.
- Secrets, credentials, patient-level data, and confidential source material are
  excluded from committed models, variables, traces, and reports.
- Camunda audit fields are projected into normalized PIC traces with explicit
  loss records; platform fields are not silently treated as PIC semantics.

## Version and runtime lock

`VERSION_LOCK.json` records the selected dependency, Maven artifact digests,
Java baseline, test framework, and container-runtime requirement. The lock is a
reproducibility input, not a claim that this local machine can execute the
runtime today.

## Unsupported assumptions

- A BPMN token path is not proof of legal, clinical, policy, or funding
  correctness.
- A successful deployment is not migration evidence; active-instance migration
  requires explicit element mappings and a wait-state test.
- A timer test must use a controlled clock and must not wait for wall time.
- A Camunda user task is not equivalent to a human decision unless the trace
  records the human task outcome and authority boundary.
- Confidential commercial arrangements and non-public deliberation remain
  unavailable rather than inferred.

## Official basis

- [Camunda Process Test](https://docs.camunda.io/docs/apis-tools/testing/getting-started/)
- [Camunda job workers](https://docs.camunda.io/docs/apis-tools/java-client/job-worker/)
- [Camunda user tasks](https://docs.camunda.io/docs/components/modeler/bpmn/user-tasks/)
- [Camunda process-instance migration](https://docs.camunda.io/docs/components/concepts/process-instance-migration/)
- [Camunda Maven artifact metadata](https://repo1.maven.org/maven2/io/camunda/camunda-process-test-java/8.9.12/)
