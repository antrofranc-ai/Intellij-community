// FIR_IDENTICAL
// FIR_COMPARISON
fun foo(param: String) {
    val s = "$param.<caret>bla-bla-bla"
}

// ELEMENT: equals
// TAIL_TEXT: "(other: Any?)"