// PROBLEM: none
// WITH_STDLIB

interface Foo {
    fun add(i: Int): Boolean
}

class Bar: ArrayList<Int>(), Foo {
    override <caret>fun add(i: Int) = super.add(i)
}