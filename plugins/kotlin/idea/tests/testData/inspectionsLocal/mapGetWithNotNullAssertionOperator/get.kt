// FIX: Replace with 'getValue' call
// WITH_STDLIB
fun test(map: Map<Int, String>) {
    val s = map.get(1)!!<caret>
}