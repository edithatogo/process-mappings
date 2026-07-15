# Adverse-Incident Human Review Packet

Status: ready for Dylan's review; no assertion or fixture has been certified.

This packet narrows review to the controlling-source assertions and resolver
exceptions produced by the deterministic Phase 2 resolver. It is not legal,
clinical, organisational, or compliance advice.

All decisions apply within the project-level linked-process model in
`PROCESS_PROJECT_MODEL.md`. They do not certify related processes, jurisdiction
overlays, or organisational compliance.

## Review Order

1. Confirm whether each source assertion is authoritative for the stated
   jurisdiction and process purpose.
2. Confirm effective dates and whether the source is current, blocked, or
   superseded for the proposed profile version.
3. Accept, reject, or limit the interpretation of each candidate mapping.
4. Record any local procedure or escalation owner that must remain unresolved.
5. Certify only the assertions and mappings explicitly approved, with scope and
   evidence recorded outside this agent-proposed packet.

## Exception Queue

| Mapping | Proposed disposition | Exception | Required decision |
| --- | --- | --- | --- |
| `mapping.nz.consumer-informed` | `candidate_supported` | none | Confirm the HDC source supports the limited consumer-communication assertion; do not infer disclosure adequacy. |
| `mapping.nz.review-learning` | `needs_more_source_review` | blocked official source | Supply or verify an accessible authoritative HQSC text before interpreting review or learning duties. |
| `mapping.au.open-disclosure` | `needs_more_source_review` | missing effective date | Confirm the framework's operative date and state/territory relationship. |
| `mapping.nsw.incident-review` | `needs_more_source_review` | blocked official source | Verify the current NSW directive text and applicable review/reportability boundaries. |
| `mapping.au.secondary-summary` | `needs_more_source_review` | secondary-source-only evidence | Reject as controlling evidence or replace with a verified primary source. |
| `mapping.local.escalation` | `needs_more_source_review` | fixture assumption underspecified | Name the local owner and controlling local procedure, or retain as unresolved. |

## Candidate Cases

The six generated profiles under `candidates/process-profiles/` are synthetic
only: `harm`, `near-miss`, `delayed-recognition`, `disputed-facts`,
`parallel-complaint`, and `blocked-source`. Each retains a human review task,
participation/support decision task, unresolved-question task, source
provenance, and trace hash. None is a golden fixture.

## Certification Record

Use `HUMAN_REVIEW_DECISIONS.template.json` as the structured response form. For
each reviewed item, record: reviewer, date, source URL or document digest,
jurisdiction, effective-date basis, decision (`approved`, `rejected`, or
`limited`), permitted interpretation, excluded interpretation, and follow-up
source request. Do not change `reviewerState` to `human-approved` or
`official-primary` without that record.
