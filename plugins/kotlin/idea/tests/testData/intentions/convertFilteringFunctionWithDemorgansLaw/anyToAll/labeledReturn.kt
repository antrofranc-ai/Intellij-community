// WITH_STDLIB
// AFTER-WARNING: Variable 'b' is never used
fun test(list: List<Int>) {
    val b = list.<caret>any { return@any it != 1 }
}