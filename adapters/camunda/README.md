# Camunda Adapter

Optional Camunda 8 projection, deterministic process tests, trace reconciliation,
and migration evidence for `camunda_portability_20260714`.

The architecture and version lock are recorded in:

- [`ARCHITECTURE_DECISION.md`](./ARCHITECTURE_DECISION.md)
- [`VERSION_LOCK.json`](./VERSION_LOCK.json)

The adapter is not a PIC dependency. Runtime tests require Java 17 and either a
Docker-compatible Testcontainers runtime or an explicitly configured remote
Camunda runtime. No runtime state, credentials, confidential evidence, or
generated reports belong in this directory.
