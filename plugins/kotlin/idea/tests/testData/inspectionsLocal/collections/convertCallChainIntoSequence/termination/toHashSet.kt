// WITH_STDLIB

fun test(list: List<Int>) {
    val toHashSet: HashSet<Int> = list.<caret>filter { it > 1 }.toHashSet()
}