// WITH_STDLIB
// FIX: none
fun test(x: Int) {
    val p = { _: String -> true }
    x.run {<caret> p::invoke }
}