fun foo(i: Int) {
    <caret>Integer.valueOf(1)
}

// EXPECTED: Integer.valueOf(1)
// EXPECTED_LEGACY: null