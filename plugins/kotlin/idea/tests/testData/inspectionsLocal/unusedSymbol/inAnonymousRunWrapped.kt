// PROBLEM: none
// WITH_STDLIB

fun testDC(): String {
    val x = run {
        object {
            val <caret>users = "XXX"
        }
    }

    return x.users
}