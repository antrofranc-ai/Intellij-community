// FIR_IDENTICAL
// FIR_COMPARISON
fun some(list: List<String>?) {
    list?.<caret>
}

// ABSENT: "[]"
