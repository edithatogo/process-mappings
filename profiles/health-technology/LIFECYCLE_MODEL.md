# Health-technology lifecycle model

Status: **agent-proposed candidate model; not a clinical, regulatory, or funding decision tool**.

The common profile uses neutral lifecycle stages while retaining the authority
that owns each transition. A pathway may branch, loop, terminate, be resubmitted,
or run in parallel. The model does not imply that market authorisation precedes
HTA, or that a positive recommendation guarantees listing or access.

## Neutral stages

`submission` -> `validation` -> `evidence_request` -> `technical_review` ->
`committee_advice` -> `consultation` -> `decision` -> `negotiation` ->
`listing_or_restriction` -> `implementation` -> `monitoring`

`reconsideration`, `appeal`, `exception`, `resubmission`, and `terminated` are
side states. A pathway records which authority owns each transition and whether
the stage is observed, derived, proposed, or unavailable.

## Variation rules

- **Parallel:** regulatory review, HTA preparation, and evidence generation may
  overlap when the source supports it; the profile records separate process IDs.
- **Conditional:** a later stage is linked only when its controlling source or
  observed decision says the condition was met.
- **Unavailable:** confidential commercial evidence and non-public deliberation
  are represented as unavailable, never reconstructed from summaries.
- **Not applicable:** medicine-only, service-only, and payer-specific stages are
  explicitly absent rather than treated as failures.
- **Loss:** a public process description may omit internal roles, confidential
  negotiations, or exact decision criteria; those omissions are recorded as
  representational loss.

## Authority boundaries

Medsafe, TGA, MHRA, and FDA are modeled as medicine regulators. Pharmac, PBAC,
PBS, NICE, CMS, MSAC, and MBS are modeled according to their distinct advisory,
funding, coverage, service, or schedule functions. FDA is not a payer; MBS and
MSAC are not medicine regulators; PBAC and NICE advice is not identical to a
listing or coverage decision.
