// WITH_STDLIB
// INTENTION_TEXT: "Replace with 'all{}'"
// IS_APPLICABLE_2: false
fun foo(): Boolean {
    val list = listOf(1, 2, 3, 4, 5)
    <caret>for (e in list) {
        if (!(e <= 3)) {
            return false
        }
    }
    return true
}
