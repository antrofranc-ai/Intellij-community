// WITH_STDLIB
// DISABLE-ERRORS
// IS_APPLICABLE: false

class FooException : Exception()

@Throws(exceptionClasses = FooException::class)
fun test() {
    <caret>throw FooException()
}