# Comparative Findings and Limitations

Status: candidate study output; not legal, clinical, organisational, or
compliance advice.

## What the Sources Establish

- The NZ HDC Code provides consumer rights and provider duties, including
  effective communication, information, support persons, cultural needs, and
  complaints rights.
- The NZ HQSC policy provides a national policy framework for reporting,
  reviewing, learning, consumer/whanau participation, and improvement after
  harm or near miss.
- The Australian national framework provides a principles-based open-disclosure
  model covering actual or potential harm, communication, apology or regret,
  listening, follow-up, support, cultural safety, and learning.
- NSW adds a jurisdictional incident-management and open-disclosure layer with
  local implementation responsibilities and related policy overlays.

These statements describe the pinned sources and official source pages. They do
not claim that any organisation complies with them or that the sources are
interchangeable.

## Common Process Shape

Across the approved limited interpretations, the candidate project can represent
a recurring shape:

1. Discover and verify relevant current official sources.
2. Detect or receive an adverse event, near miss, complaint, or concern.
3. Respond immediately to prevent further harm and identify affected people.
4. Select review, reporting, communication, and escalation pathways through
   human tasks.
5. Conduct continuing open communication and support participation.
6. Review, learn, agree improvement actions, follow up, and close by agreement
   where the applicable process permits.

This is a candidate process structure, not a universal workflow or a claim that
every jurisdiction uses the same stages.

## Intentional Variation

- NZ policy and rights sources emphasise consumer/whanau participation,
  culturally responsive practice, restorative response, and system learning.
- The Australian framework provides a national communication model but directs
  services to align with state, territory, and local requirements.
- NSW supplies specific incident-management, review, reporting, and local
  implementation context. Its blocked directive text prevents encoding
  reportability thresholds or harm-score rules here.
- Local escalation ownership remains unresolved because it depends on the
  service context and local source.

Variation is represented as a jurisdiction overlay or human task, not as a bug
or divergence from a single canonical process.

## Executable Boundary

The deterministic resolver may validate source status, jurisdiction, effective
date fields, provenance, and exception reasons. It may not decide clinical
causation, severity, reportability, disclosure adequacy, apology content,
legal meaning, organisational compliance, or local ownership.

## Portability and Camunda Implications

The model is portable when the project case, linked process identifiers, source
assertions, human tasks, and jurisdiction overlay are kept separate. A future
Camunda demonstrator should use call activities or linked subprocesses for
adverse-event management, open disclosure, complaints/feedback, review/
learning, and jurisdiction overlays. Source discovery and human decisions must
remain explicit user tasks or external review gates; no gateway should infer a
normative outcome from an unverified source.

## Unresolved Limitations

- The NSW PD2020_047 and PD2023_034 controlling texts remain blocked in the
  current retrieval environment.
- The Australian framework effective date is not stated in the reviewed source.
- The local escalation owner and procedure are intentionally unspecified.
- Jurisdiction expansion beyond the initial NZ/Australia scope requires fresh
  primary-source discovery and independent review; UK and Canadian profiles are
  future work, not current coverage.
