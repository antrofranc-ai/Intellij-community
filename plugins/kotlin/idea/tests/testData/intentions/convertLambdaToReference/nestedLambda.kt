// IS_APPLICABLE: false
// WITH_STDLIB

fun foo() {
    listOf(1).forEach { run { <caret>bar(it) } }
}

fun bar(i: Int) {
}