# Proposed GitHub Migration Packet

Status: **deferred by human decision on 2026-07-16**. No remote repository has
been created and no hosted setting in this packet is asserted as configured.

The active decision is recorded in
[`DEFERRED_CUTOVER_DECISION.md`](DEFERRED_CUTOVER_DECISION.md). This packet
remains the preparation record if the reconsideration triggers are later met.

## Destination

- Proposed owner: `edithatogo`
- Proposed repository: `process-mappings`
- Proposed canonical URL: `https://github.com/edithatogo/process-mappings`
- Initial visibility: private or public only after Dylan records the decision
- Initial release: no release until the extracted clone and hosted checks are
  independently verified
- Initial version proposal: `0.1.0-incubating`; reserve `1.0.0` for a reviewed
  platform-neutral profile contract and at least one independently certified
  jurisdiction profile

## Proposed repository metadata

Description:

> Source-backed, jurisdiction-aware process profiles and optional platform
> adapters. Normative contracts remain in `rac-conformance`.

Suggested topics: `process-mapping`, `policy-as-process`, `jurisdictional-
profiles`, `process-mining`, `camunda`, `public-interest-technology`.

The Apache-2.0 license must be copied from the parent root and retained with
the extracted tree. External source rights remain governed by each source
manifest; unclear or incompatible material stays referenced, not vendored.
The FOI source manifest now uses immutable FOI-O blob/tree locators, with byte
equality and SHA-256 evidence in
`profiles/foi/SOURCE_REFERENCE_PORTABILITY.json`. The parent-only
`contracts/consumption.json` retains local evidence paths for parent CI and now
also carries pinned `portableEvidenceSources`; the portability ledger remains
the byte-level destination-facing source record.

## Required hosted controls

Configure only after the human cutover decision and verify the actual check
names against the first destination workflow run:

- protect the default branch and require pull requests;
- require the repository owner’s approval policy selected by Dylan;
- require the destination’s full quality suite and dependency review;
- require workflow security and workflow lint checks;
- enable automatic cancellation for superseded workflow runs;
- enable Dependabot or an equivalent pinned-dependency update path;
- add `CODEOWNERS`, issue forms/templates, pull-request template, security
  policy, and contribution guidance;
- enable secret scanning and push protection if available for the selected
  repository visibility.

The parent’s current check names are evidence for planning only. A future
destination must not copy a required-check name until the hosted run proves it
exists and is trustworthy.

## Initial issue mapping

| Parent issue | Destination treatment | Condition |
| --- | --- | --- |
| [#50](https://github.com/edithatogo/rac-conformance/issues/50) | Parent migration/cutover issue; link from destination umbrella issue | Keep open until canonical cutover and parent closeout |
| [#40](https://github.com/edithatogo/rac-conformance/issues/40) | Link as upstream contract dependency | Keep process-profile certification in `rac-conformance` |
| FOI-O and `foi-process` inputs | Destination profile-source issues | Preserve source provenance and candidate status |
| adverse incidents/open disclosure | Future destination profile issue | Do not create until the profile has a named consumer |
| health-technology pathways | Future destination profile issue | Do not create until scope and source authority are approved |
| Camunda adapter | Future destination adapter issue | Keep optional and platform-neutral |

Any destination issues must link back to #50 and record the parent commit from
which their initial files were extracted. Parent issues remain the record of
the migration decision until the human gate is complete.

## Extraction and rollback

1. Dylan approves repository creation, visibility, owner, and conditions.
2. Create the remote and import the exact tree recorded by
   `migration/REHEARSAL_REPORT.json`.
3. Run the destination CI, dependency, link, provenance, and independent-clone
   checks; record the immutable migration commit.
4. If any hosted control fails, stop canonical cutover, delete or quarantine
   the destination, and retain the parent subtree as the only writable source.
5. Only after hosted verification, convert the parent subtree to a read-only
   reference or remove it and update all consumers.

No simultaneous writable parent and destination copies are permitted.
