// "Replace with 'Factory<Int>()'" "true"
// WITH_STDLIB

class Foo<T> @Deprecated("", ReplaceWith("Factory<T>()")) constructor()
fun <T> Factory(): Foo<T> = TODO()

fun baz() {
    val foo = <caret>Foo<Int>()
}