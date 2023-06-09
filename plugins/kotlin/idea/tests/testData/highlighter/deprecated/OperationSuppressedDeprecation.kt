class MyClass {
    val i = 0
}

@Deprecated("Use A instead") operator fun MyClass.minus(i: MyClass) { i.i }
@Deprecated("Use A instead") operator fun MyClass.div(i: MyClass) { i.i }
@Deprecated("Use A instead") operator fun MyClass.times(i: MyClass) { i.i }

@Deprecated("Use A instead") operator fun MyClass.not() { }
@Deprecated("Use A instead") operator fun MyClass.unaryPlus() { }

@Deprecated("Use A instead") operator fun MyClass.contains(i: MyClass): Boolean { i.i; return false }

@Deprecated("Use A instead") operator fun MyClass.plusAssign(i: MyClass) { i.i }

@Deprecated("Use A instead") operator fun MyClass.rangeTo(i: MyClass): IntRange { return IntRange(i.i, i.i) }

fun test() {
    val x1 = MyClass()
    val x2 = MyClass()

    x1 - x2
    x1 / x2
    x1 * x2

    !x1
    +x1

    x1 in x2
    x1 !in x2

    x1 += x2

    x1..x2
}

// NO_CHECK_INFOS
// NO_CHECK_WEAK_WARNINGS
// REGISTRY: kotlin.highlighting.suppress.deprecated true