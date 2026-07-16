# Independent-oracle and adjudication protocol

Status: **candidate protocol; no health-technology assertion or fixture is certified**.

This protocol governs proposed health-technology comparison profiles. It does
not select a medicine, indication, jurisdiction pair, or funding outcome.
Those choices remain behind the human selection gate in the track plan.

## Evidence classes

Each assertion must identify its jurisdiction, authority, function, indication
boundary, effective date, source status, and reviewer state.

| Evidence class | Permitted use | Controlling use |
| --- | --- | --- |
| `official-primary` | Process or decision fact within the source's authority and date | Yes, subject to scope and conflict checks |
| `human-approved` | Project interpretation explicitly certified by the reviewer | Yes, subject to the recorded limits |
| `agent-proposed` | Candidate mapping, test proposal, or exception explanation | Never |
| `secondary` | Discovery and corroboration | Never |
| unavailable or blocked | Explicit evidence gap | Never |

An official source is not automatically controlling for every claim. A
regulator source can support a market-authorisation fact but cannot support a
payer listing or clinical recommendation. A public summary cannot be used to
infer confidential commercial terms or non-public deliberation.

## Deterministic resolution order

The resolver evaluates each candidate assertion set in this order:

1. Reject missing assertion references and underspecified fixture assumptions.
2. Reject jurisdiction, authority-function, medicine, indication, or effective-
   date mismatches.
3. Route blocked, unavailable, conflicting, stale, or undated evidence to
   `needs_more_source_review`.
4. Route secondary-only evidence to `needs_more_source_review`.
5. Require at least one applicable `official-primary` or `human-approved`
   assertion for any proposed controlling interpretation.
6. Preserve parallel, conditional, terminated, and not-applicable states rather
   than collapsing them into a single outcome.
7. Emit a proposed result and the complete exception set. No result is a
   certified fixture until the human certification record is present.

## Proposed dispositions

The candidate resolver may emit only:

- `confirmed_process_fact`: an authority-bounded process or public decision
  fact supported by an applicable controlling assertion;
- `expected_modeling_difference`: a documented difference between authorities
  or jurisdictions, supported by controlling assertions and not presented as
  a policy or clinical judgement;
- `fixture_adapter_issue`: a deterministic representation or transport defect
  with the source facts otherwise supported;
- `needs_more_source_review`: evidence or interpretation is incomplete,
  conflicting, stale, blocked, or outside the source's authority.

These are proposed labels only. They cannot promote a fixture or authorize a
release.

## Required exception reasons

The resolver uses these stable reasons, with additional structured detail:

- `blocked official source`
- `conflicting primary sources`
- `missing effective date`
- `fixture assumption underspecified`
- `secondary-source-only evidence`
- `authority-function mismatch`
- `jurisdiction or indication mismatch`
- `confidential evidence unavailable`

Every held assertion must have at least one proposed disposition or one of
these explicit exceptions. Human review is limited to contested controlling
assertions, interpretation limits, and exception cases.

## Independence and certification boundary

The implementing agent may generate candidate mappings and deterministic
resolution, but it may not act as the independent oracle. The independent
oracle must be either an official primary record for a bounded fact or a
separately controlled human-approved interpretation. A proposed result is
eligible for certification only when the reviewer records the source, scope,
effective-date basis, permitted interpretation, excluded interpretation, and
decision. No agent may change a candidate assertion to `human-approved`,
promote a candidate fixture, or infer an unavailable commercial or clinical
fact.
