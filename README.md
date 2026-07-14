# Process Mappings Incubator

Status: **non-canonical incubator**. This tracked subtree is not a nested Git
repository and must not be published as an independent product before the
cutover gate in `process_mappings_repository_20260714`.

The intended product is a domain-neutral collection of source-backed process
profiles, jurisdiction overlays, synthetic candidate scenarios, and optional
platform adapters. Normative PIC contracts remain in `rac-conformance`.

See [REPOSITORY_BOUNDARY.md](REPOSITORY_BOUNDARY.md) for ownership and
[LICENSE_BOUNDARY.md](LICENSE_BOUNDARY.md) for incubation and extraction rights.

## Initial profile homes

- `profiles/foi/`: compatibility with FOI-O semantics and foi-process evidence.
- `profiles/adverse-incidents/`: adverse-incident/open-disclosure mappings.
- `profiles/health-technology/`: regulator, HTA, payer, and service-funding mappings.
- `adapters/camunda/`: optional Camunda projection and portability artifacts.

No substantive mapping is implemented by this scaffold.
