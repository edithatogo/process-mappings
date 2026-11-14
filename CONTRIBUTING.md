# Contributing to process-mappings

Process Mappings is an incubator for source-backed process profiles, jurisdiction overlays and optional platform adapters. Contributions should keep profile evidence and ownership clear while respecting its current non-canonical incubation status.

## Before you start

Read [README.md](README.md), [REPOSITORY_BOUNDARY.md](REPOSITORY_BOUNDARY.md), [LICENSE_BOUNDARY.md](LICENSE_BOUNDARY.md) and [STATUS.md](STATUS.md). Reconcile the existing Conductor cutover work before proposing a new mapping. Normative PIC contracts remain with `rac-conformance`; do not silently duplicate or relocate them.

For bugs, provide the affected version or commit, environment, minimal reproduction, expected result and observed result. For a substantial proposal, describe the use case and compatibility impact before expanding implementation scope. Use existing issue templates when offered.

## Development and validation

The existing [standalone workflow](.github/workflows/standalone-check.yml) runs:

```sh
sh ci/check.sh
```

Inspect [tests/README.md](tests/README.md) and the boundary checker for the current validation scope. Report exact commands and outcomes. A scaffold check does not establish that a substantive mapping has been implemented or independently qualified.

For a profile or overlay, identify the source, edition, jurisdiction, rights, applicable scope and evidence limitations. Keep observed requirements separate from interpretation and synthetic candidate scenarios. Include independently checkable fixtures and negative cases for changed contracts. Optional adapter output must retain its relationship to the source profile and document any portability loss.

Preserve the incubation and extraction rights described in the boundary documents. Repository contributions do not themselves satisfy the cutover gate or authorise publication as an independent product.

## Pull requests

Create a focused branch from the current `main` branch and submit a pull request to this repository. Link the relevant issue or existing project task, explain the resulting behaviour, and update affected examples and documentation. Keep unrelated changes in separate pull requests.

Report executed commands, outcomes and the commit they validate. Identify unavailable checks and remaining limitations explicitly. Follow the repository's existing review and automated-check requirements; retain required gates and current ownership. Address findings and verify the final head before integration. Repository changes do not themselves authorise a release or external operational action.

## Security, rights and conduct

Follow the [security policy](SECURITY.md). Use private vulnerability reporting if available; otherwise request a private contact without publishing vulnerability details. Keep credentials, personal information and restricted source material out of issues, fixtures, logs and artifacts.

Read the [existing licence](LICENSE) and preserve attribution and third-party terms. Follow the [code of conduct](https://github.com/edithatogo/.github/blob/main/CODE_OF_CONDUCT.md) and keep technical discussions respectful.

## Basis for this guide

This guide follows [GitHub's contribution-guideline guidance](https://docs.github.com/en/communities/setting-up-your-project-for-healthy-contributions/setting-guidelines-for-repository-contributors) and the contribution-process and testing principles in [OpenSSF Best Practices](https://www.bestpractices.dev/en/criteria). It does not assert certification.
