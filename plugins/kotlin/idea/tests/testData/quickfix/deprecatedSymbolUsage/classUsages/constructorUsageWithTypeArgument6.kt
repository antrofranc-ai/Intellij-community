// "Replace with 'test.New'" "true"
// WITH_STDLIB

package test

abstract class Main<T>

@Deprecated("", ReplaceWith("test.New"))
class Old<T> : Main<T>()

class New<T> : Main<T>()

fun test() {
    val main = <caret>Old<Int>()
}