class C{}

fun foo(c: C){}
fun foo(c: C, i: Int){}

fun foo() {
    foo(<caret>
}

// AUTOCOMPLETE_SETTING: true