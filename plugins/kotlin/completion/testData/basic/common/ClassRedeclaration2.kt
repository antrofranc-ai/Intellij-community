// FIR_IDENTICAL
// FIR_COMPARISON

class A {
  fun f() : A
}

class A {
  fun f() : A<caret>
}

// EXIST: A