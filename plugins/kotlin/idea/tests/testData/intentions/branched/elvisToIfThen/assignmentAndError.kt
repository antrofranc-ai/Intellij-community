// WITH_STDLIB
fun foo(list: List<String>): String {
    val first = list.firstOrNull() ?:<caret> error("empty")
    return "First length: ${first.length}"
}