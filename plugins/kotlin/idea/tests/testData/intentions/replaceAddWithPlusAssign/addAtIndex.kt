// IS_APPLICABLE: false
// WITH_STDLIB

fun foo() {
    val a = arrayListOf<Int>(1, 2, 3)
    a.<caret>add(1, 4)
}
