# Tests

The parent repository runs the executable consumption checks in
`contracts/tools/tests/test_process_mappings_consumption.py`. Those checks pin
the released `pic-process-profile/0.1.0` contract by full commit and schema
digest, validate the vendored examples against the parent schema, and require
the FOI source manifest and evidence paths to remain aligned. Future tests must
also cover jurisdiction/effective-date isolation, candidate promotion rules,
adapter loss reporting, and deterministic normalized traces.
