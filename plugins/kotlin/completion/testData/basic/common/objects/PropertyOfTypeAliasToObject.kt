// FIR_IDENTICAL
// FIR_COMPARISON

object Obj {
    val inObject = 1
}

typealias TA = Obj

val usage = TA.<caret>

// EXIST: inObject