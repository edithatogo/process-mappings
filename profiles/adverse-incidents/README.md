# Adverse Incidents and Open Disclosure

Planned home for the source-backed mappings and synthetic candidate scenarios
from `adverse_incident_open_disclosure_20260714`.

No real incident data, automated clinical/legal judgement, or substantive
mapping is present in this scaffold.

`AUTHORITY_VARIATION_MATRIX.json` separates national consistency, jurisdictional
requirements, regional implementation, and hypothetical local procedure. It is
an authority analysis, not a semantic crosswalk. Rows remain agent-proposed
until blocked source text, effective dates, applicability, and interpretation
are independently reviewed.

Generate the deterministic triangulation result with:

```sh
python tools/adverse_incident_triangulation.py \
  subrepos/process-mappings/profiles/adverse-incidents/candidates/SOURCE_ASSERTIONS.json \
  subrepos/process-mappings/profiles/adverse-incidents/candidates/CANDIDATE_MAPPINGS.json \
  subrepos/process-mappings/profiles/adverse-incidents/results/triangulated-candidates.json
```

The output is a proposal packet only. `agent-proposed` assertions and
dispositions cannot certify a legal, clinical, or organisational obligation.

Synthetic process-profile candidates are generated into
`candidates/process-profiles/` by `tools/generate_adverse_incident_fixtures.py`.
They contain no incident facts and are not golden fixtures.

The optional aggregate safety handoff is defined under `safety-handoff/`.
It permits only aggregate, provenance-bearing signals for an explicit purpose;
it excludes patient-level data, inferred causation, and downstream action.
