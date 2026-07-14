# Repository Boundary

## Ownership

- `rac-conformance` owns normative PIC contracts, validators, conformance tests,
  qualification evidence, and release policy.
- `process-mappings` owns source-backed profiles, jurisdiction overlays,
  synthetic candidate scenarios, and optional platform adapters.
- `foi-o` owns canonical FOI semantics and jurisdiction-specific ontology work.
- `foi-process` owns deterministic FOI replay, event projections, OCEL/process
  intelligence, and operational implementation evidence.

## Integration rules

- Consume released or commit-pinned upstream contracts and record provenance.
- Reference normative schemas; do not copy and silently modify them.
- Treat FOI-O exports as semantic inputs and foi-process exports as execution
  evidence. Neither makes this repository authoritative for FOI law.
- Store AI-drafted mappings only as `agent-proposed` candidates. Promotion
  requires human certification and independent source evidence.
- Keep platform adapters optional. Adapter convenience cannot redefine the
  platform-neutral profile.

## Data boundary

Only public or appropriately licensed sources and synthetic scenarios are
allowed. Patient-level, personally identifiable, confidential, commercially
sensitive, or inferred unavailable evidence is prohibited.
