// "Remove redundant 'open' modifier" "true"

interface My {
    <caret>open fun foo()
}

// Ignore in K2 as the `RedundantOpenInInterface` quickfix has been removed in K2 and a `TOOL_FIR` test directive doesn't exist. In K2,
// this test case is covered by `redundantOpenFunctionInInterface.kt` in the `inspections-k2` module.
/* IGNORE_FIR */