// WITH_STDLIB
// PROBLEM: none

fun foo() {
    val foo: String? = null
    foo?.let {
        text ->
        text.to(text)<caret>
    }
}