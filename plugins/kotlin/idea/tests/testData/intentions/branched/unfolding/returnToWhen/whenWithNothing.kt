// WITH_STDLIB
fun test(b: Boolean): Int {
    <caret>return when (b) {
        true -> 1
        else -> TODO()
    }
}