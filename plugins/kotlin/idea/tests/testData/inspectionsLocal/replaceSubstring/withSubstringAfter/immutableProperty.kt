// WITH_STDLIB

class A(val x: String)

fun foo(a: A) {
    a.x.substring<caret>(a.x.indexOf('x'))
}