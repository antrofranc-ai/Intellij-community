// WITH_STDLIB
fun x() {
    listOf<Int>()
        .take(10)
        .filter { Math.<caret>abs(it) < 10 }
}