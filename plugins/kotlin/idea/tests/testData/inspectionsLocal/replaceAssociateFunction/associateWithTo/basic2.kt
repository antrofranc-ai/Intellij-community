// PROBLEM: Replace 'associateTo' with 'associateWithTo'
// FIX: Replace with 'associateWithTo'
// WITH_STDLIB
fun getValue(i: Int): String = ""

fun associateWithTo() {
    val destination = mutableMapOf<Int, String>()
    listOf(1).<caret>associateTo(destination) { i -> i to getValue(i) }
}
