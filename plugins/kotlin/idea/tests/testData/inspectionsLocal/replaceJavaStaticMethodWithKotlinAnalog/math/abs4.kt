// WITH_STDLIB
fun x() {
    val a = 4
    val b = Math.<caret>abs(a).let { println(it) }
}