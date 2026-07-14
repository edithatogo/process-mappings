# Extraction Rehearsal

The parent repository can rehearse extraction with:

```sh
PYTHONPATH=. uv run python - <<'PY'
from pathlib import Path
from tools.process_mappings_rehearsal import run_rehearsal

run_rehearsal(Path.cwd(), Path("subrepos/process-mappings/migration/REHEARSAL_REPORT.json"))
PY
```

The procedure copies only tracked subtree files into a temporary local Git
repository, transfers the parent Apache-2.0 license, repairs the one
parent-relative license link for standalone use, creates a local commit, clones
that repository independently, audits local links and provenance files, and
deletes the temporary repositories. It never creates or contacts a remote.

The incubator is currently documentation and contract data, not an installable
runtime package. The rehearsal therefore records local Git/install boundaries
and the required future standalone-CI check rather than claiming a package
installation that does not exist. Remote creation, hosted controls, and
canonical cutover remain human-gated.
