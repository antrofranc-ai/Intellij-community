// WITH_STDLIB
// AFTER-WARNING: Parameter 'f' is never used
fun foo(f: (Int) -> String) {}

fun test() {
    foo {<caret>
        listOf(1).map {
            return@map 2
        }
        return@foo "$it"
    }
}