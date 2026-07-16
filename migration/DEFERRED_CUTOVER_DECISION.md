# Deferred Canonical Cutover

Decision date: 2026-07-16
Status: retain this subtree; do not create a standalone remote yet.

The process-mappings work remains an ordinary tracked subrepo inside
`rac-conformance`, with no nested Git repository and no separate writable
canonical copy. This is a deliberate deferral, not a rejection of the future
neutral repository design.

Reconsider extraction only when a second domain profile has a named consumer,
an independent consumer needs the mappings, and the mapping artifacts require
their own release or governance lifecycle. The full decision record and human
provenance are maintained in the parent Conductor track:
`conductor/archive/process_mappings_repository_20260714/migration/DEFERRED_CUTOVER_DECISION.md`.

Until then, changes land through `rac-conformance`; no destination repository,
issue migration, redirect, or canonical-home claim is authorized.
