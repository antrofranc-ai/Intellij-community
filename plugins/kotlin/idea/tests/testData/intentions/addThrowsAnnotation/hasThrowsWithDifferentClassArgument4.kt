// WITH_STDLIB
class FooException : Exception()

class BarException : Exception()

@Throws(exceptionClasses = arrayOf(BarException::class))
fun test() {
    <caret>throw FooException()
}