// FIR_IDENTICAL
// FIR_COMPARISON
interface Interface {
    var field: Int
}

expect class SClass : Interface {
    override<caret>
}
// ELEMENT_TEXT: "override var field: Int"