// WITH_STDLIB
// INTENTION_TEXT: "Replace with 'firstOrNull()'"
// IS_APPLICABLE_2: false
fun foo(list: List<String>): String? {
    <caret>for (s in list) {
        return s
    }
    return null
}