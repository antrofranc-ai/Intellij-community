// WITH_STDLIB

fun test(list: List<Int>) {
    val joinToString: String = list.<caret>filter { it > 1 }.joinToString()
}