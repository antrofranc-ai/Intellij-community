// WITH_STDLIB

fun test(list: List<Int>) {
    val any: Boolean = list.<caret>filter { it > 1 }.any()
}