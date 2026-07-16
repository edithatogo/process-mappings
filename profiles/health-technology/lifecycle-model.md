# Neutral Lifecycle Model

This vocabulary is a comparison projection, not a claim that agencies share a
workflow. Each event retains `jurisdiction`, `authority`, `authorityClass`,
`stage`, `effectiveFrom`, and source assertion identifiers.

## Stages

`submission` -> `validation` -> `evidence_request` -> `technical_review` ->
`committee_advice` -> `consultation` -> `decision` -> `negotiation` ->
`listing_or_restriction` -> `implementation` -> `exception` -> `monitoring`.

The arrows are permitted transitions, not mandatory ordering. A pathway may
branch, run in parallel, be terminated, be resubmitted, or be conditional.
Market authorisation, HTA advice, payer coverage, service funding, listing, and
post-market monitoring are separate decision domains.

## Evidence states

`public_verified`, `public_unverified`, `confidential_unavailable`,
`not_applicable`, and `source_blocked` are mutually explicit. A missing public
record cannot be converted into a negative finding, and confidential evidence
must never be reconstructed from a summary.

## Portability loss

The neutral model intentionally does not encode statutory tests, clinical
effectiveness, price, prioritisation, or patient-level access outcomes. Those
remain jurisdiction-owned assertions. A profile records `lossNotes` whenever a
source-specific concept cannot be represented without changing its meaning.
