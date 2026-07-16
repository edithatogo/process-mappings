# FOI-O Controlling-Mapping Certification Packet

Status: candidate review; no mapping is certified or promoted.

This packet is the row-level review surface for issue #40. It does not change
`PROFILE_CANDIDATES.json`, promote fixtures, or certify legal compliance. A
reviewer must record a separate decision for every mapping and source
assertion after checking the cited FOI-O artifact and any controlling primary
source.

## Review outcomes

Use exactly one outcome per row. The structured response form is
`HUMAN_CERTIFICATION_DECISIONS.template.json`.

- `approve-bounded`: accept only within the stated source scope and loss;
- `limit`: accept only with a narrower scope or explicit exception;
- `reject`: evidence does not support the mapping; or
- `defer`: evidence is blocked, conflicting, stale, or insufficient.

An `approve-bounded` outcome requires a controlling source assertion whose
`reviewerState` is `human-approved` or `official-primary`, whose status is
current, and whose effective date and jurisdiction are recorded. Secondary,
blocked, stale, or agent-proposed assertions cannot support controlling use.

## Mapping decisions

| Mapping ID | Candidate target | Required reviewer check | Decision | Reviewer/evidence reference |
| --- | --- | --- | --- | --- |
| `map.request.received` | `event/request.received` | Confirm whether the receipt trace supports an observed event; retain the limitation that a receipt variable alone is not an occurrence record. | `pending` | |
| `map.response.deadline` | `ruleInvocation/nz-oia/decision.response_deadline` | Confirm source scope and effective date; do not infer legal compliance or process completion. | `pending` | |
| `map.transfer.deadline` | `ruleInvocation/nz-oia/decision.transfer_deadline` | Confirm transfer conditions and recipient authority are not inferred beyond the staged trace. | `pending` | |
| `map.extension` | `humanTask/task.extension-reasonableness` | Confirm the human-discretion boundary and source basis for the consultation ground. | `pending` | |
| `map.deemed.refusal` | `derivedState/request.reviewable-refusal` | Confirm deadline expiry is only a reviewability signal, not an Ombudsman outcome. | `pending` | |
| `map.review` | `exception/review.required` | Confirm the warning identifies an exception without inventing reviewer identity or completion. | `pending` | |

## Source-assertion decisions

| Assertion ID | Authority class | Current candidate state | Required action | Decision |
| --- | --- | --- | --- | --- |
| `source.foio-oia-rules-design` | runtime observation | agent-proposed | Verify the pinned FOI-O design artifact and scope. | `pending` |
| `source.foio-oia-traces` | runtime observation | agent-proposed | Verify referenced trace files and preserve commit/digest. | `pending` |
| `source.oia-1982-primary-notes` | law | agent-proposed; inherited notes not authority-certified | Check the official primary source, effective date, jurisdiction, and exact section before controlling use. | `pending` |

## Exception handling

Record one or more of these reasons when the outcome is `limit` or `defer`:

- blocked official source;
- conflicting primary sources;
- missing effective date;
- fixture assumption underspecified; or
- secondary-source-only evidence.

## Certification record

Append a dated human-authored record containing reviewer identity,
mapping/assertion ID, outcome, immutable source digest, scope limit, exception
reason if any, and an explicit statement that no fixture was promoted without
separate approval. An agent may validate the structure but may not fill or
certify this record.
