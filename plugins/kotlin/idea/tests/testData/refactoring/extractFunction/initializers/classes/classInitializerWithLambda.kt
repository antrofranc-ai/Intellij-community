// PARAM_TYPES: kotlin.Int
// PARAM_DESCRIPTOR: value-parameter b: kotlin.Int defined in A.`<init>`
class A(val a: Int, b: Int) {
    init {
        println({ <selection>a + b</selection> - 1 }.invoke())
    }
}