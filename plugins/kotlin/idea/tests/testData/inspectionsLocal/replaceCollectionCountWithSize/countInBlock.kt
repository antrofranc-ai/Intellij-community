// WITH_STDLIB

fun foo() {
    var list = listOf(1, 2, 3)
    list.run {
        <caret>count()
    }
}
