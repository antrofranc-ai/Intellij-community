// FIR_IDENTICAL
// FIR_COMPARISON
class Some() {
    public val testPublic = 12
    protected val testProtected = 12
    private val testPrivate = 12
    val testPackage = 12
}

class SomeSubclass : Some() {
    fun test() {
        <caret>
    }
}

// INVOCATION_COUNT: 1
// EXIST: testPublic, testProtected, testPackage
// ABSENT: testPrivate