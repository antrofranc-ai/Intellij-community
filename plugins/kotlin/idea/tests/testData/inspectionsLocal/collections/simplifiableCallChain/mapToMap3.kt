// FIX: Merge call chain to 'associateWith'
// WITH_STDLIB
fun getValue(i: Int): String = ""

fun test(list: List<Int>) {
    val map: Map<Int, String> = list.<caret>map { it to getValue(it) }.toMap()
}