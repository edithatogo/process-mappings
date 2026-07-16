# FOI-O Candidate Review

This is a human-certified PIC compatibility candidate, not a canonical FOI-O
profile and not a legal interpretation. It is derived from the staged FOI-O
rules design, source notes, PIC artifacts, and the pinned FOI-O integration
evidence under `external/foi-o/`.

| FOI-O / process concept | PIC process-profile representation | Status |
| --- | --- | --- |
| request receipt | observed `RequestObserved` event and initial state | candidate |
| transfer assessment/notification | `TransferAssessed` and `TransferNotified` events and transitions | candidate |
| response deadline | derived `DeadlineCalculated` event and working-day timer | candidate |
| extension assessment/notification | `ExtensionAssessed` and `ExtensionNotified` events and transitions | candidate |
| overdue / deemed-refusal signal | derived `OverdueFlagged` event and non-terminal reviewability signal | candidate |
| response communication | observed `DecisionCommunicated` event | candidate |

`foi-o` remains authoritative for FOI semantics and `foi-process` remains the
execution/evidence source. Dylan certified the PIC compatibility projection on
2026-07-16. Canonical promotion remains subject to repository cutover #50. The
candidate does not
assert that an overdue flag is an Ombudsman review outcome or a legal refusal
conclusion.
