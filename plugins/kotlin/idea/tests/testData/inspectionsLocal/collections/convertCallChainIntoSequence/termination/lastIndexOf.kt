// WITH_STDLIB

fun test(list: List<Int>) {
    val lastIndexOf: Int = list.<caret>filter { it > 1 }.lastIndexOf(1)
}