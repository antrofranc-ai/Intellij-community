// FIR_IDENTICAL
// FIR_COMPARISON
fun foo(list: List<String>, b: Boolean) {
    val v = if (b) list else emp<caret>
}

// ELEMENT: emptyList
