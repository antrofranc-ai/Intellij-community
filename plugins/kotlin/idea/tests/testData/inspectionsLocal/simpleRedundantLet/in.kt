// PROBLEM: none
// WITH_STDLIB


fun foo(list: List<Int>) {
    list.filter { it.let<caret> { it in 1000..3000 } }
}