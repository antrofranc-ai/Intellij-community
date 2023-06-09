open class A() {
  fun foo() {
      if (this is B) {
          bar()
      }
  }
}

class B() : A() {
  fun bar() {}
}

fun f9(a : A?) {
  a?.foo()
  a?.<error descr="[UNRESOLVED_REFERENCE] Unresolved reference: bar">bar</error>()
  if (a is B) {
    a.bar()
    a.foo()
  }
  a?.foo()
  a?.<error descr="[UNRESOLVED_REFERENCE] Unresolved reference: bar">bar</error>()
  if (!(a is B)) {
    a?.<error descr="[UNRESOLVED_REFERENCE] Unresolved reference: bar">bar</error>()
    a?.foo()
  }
  if (!(a is B) || a.bar() == Unit) {
      a?.<error descr="[UNRESOLVED_REFERENCE] Unresolved reference: bar">bar</error>()
  }
  if (!(a is B)) {
    return;
  }
  a.bar()
  a.foo()
}

fun fAny(a : Any?) {
    if (a is B) {
        a.bar()
        a.foo()
    }
    if (!(a is B)) {
        return;
    }
    a.bar()
    a.foo()
}

fun f10(a : A?) {
  if (!(a is B)) {
    return;
  }
  if (!(a is B)) {
    return;
  }
}

class C() : A() {
  fun bar() {

  }
}

fun f101(a : A?) {
    if (a is C) {
      a.bar();
    }
}

fun f11(a : A?) {
  when (a) {
    is B -> a.bar()
    is A -> a.foo()
    is Any -> a.foo()
    is Any? -> a.<error descr="[UNRESOLVED_REFERENCE] Unresolved reference: bar">bar</error>()
    else -> a?.foo()
  }
}

fun f12(a : A?) {
  when (a) {
    is B -> a.bar()
    is A -> a.foo()
    is Any -> a.foo();
    is Any? -> a.<error descr="[UNRESOLVED_REFERENCE] Unresolved reference: bar">bar</error>()
    is C -> a.bar()
    else -> a?.foo()
  }

  if (a is Any?) {
    a?.<error descr="[UNRESOLVED_REFERENCE] Unresolved reference: bar">bar</error>()
  }
  if (a is B) {
    a.bar()
  }
}

fun f13(a : A?) {
  if (a is B) {
    a.foo()
    a.bar()
  }
  else {
    a?.foo()
    <error descr="[UNRESOLVED_REFERENCE] Unresolved reference: c">c</error>.bar()
  }

  a?.foo()
  if (!(a is B)) {
    a?.foo()
  }
  else {
    a.foo()
  }

  a?.foo()
  if (a is B && a.foo() == Unit) {
    a.foo()
    a.bar()
  }
  else {
    a?.foo()
  }

  if (!(a is B) || !(a is C)) {
  }
  else {
  }

  if (!(a is B) || !(a is C)) {
  }

  if (!(a is B)) return
  a.bar()
}

fun f14(a : A?) {
  while (!(a is B)) {
  }
  a.bar()
}
fun f15(a : A?) {
  do {
  } while (!(a is B))
  a.bar()
}

fun getStringLength(obj : Any) : Char? {
  if (obj !is String)
    return null
  return obj.get(0) // no cast to kotlin.String is needed
}

fun toInt(i: Int?): Int = if (i != null) i else 0
fun illegalWhenBody(a: Any): Int = when(a) {
    is Int -> a
    is String -> a
    else -> 1
}
fun illegalWhenBlock(a: Any): Int {
    when(a) {
        is Int -> return a
        is String -> return <error descr="[RETURN_TYPE_MISMATCH] Return type mismatch: expected kotlin/Int, actual kotlin/String">a</error>
        else -> return 1
    }
}
fun declarations(a: Any?) {
    if (a is String) {
       val p4: String = a
    }
    if (a is String?) {
        if (a != null) {
            val s: String = a
        }
    }
    if (a != null) {
        if (a is String?) {
            val s: String = a
        }
    }
}
fun vars(a: Any?) {
    var b: Int = 0
    if (a is Int) {
        b = a
    }
}
fun returnFunctionLiteralBlock(a: Any?): Function0<Int> {
    if (a is Int) return { a }
    else return { 1 }
}
fun returnFunctionLiteral(a: Any?): Function0<Int> =
    if (a is Int) (fun (): Int = a)
    else { -> 1 }

fun mergeSmartCasts(a: Any?) {
  if (a is String || a is Int) {
    a.compareTo(<error descr="[ARGUMENT_TYPE_MISMATCH] Argument type mismatch: actual type is kotlin/String but it(kotlin/String & kotlin/Int) was expected">""</error>)
    a.toString()
  }
  if (a is Int || a is String) {
    a.compareTo(<error descr="[ARGUMENT_TYPE_MISMATCH] Argument type mismatch: actual type is kotlin/String but it(kotlin/Int & kotlin/String) was expected">""</error>)
  }
  when (a) {
    is String, is Any -> a.<error descr="[UNRESOLVED_REFERENCE] Unresolved reference: compareTo">compareTo</error>("")
  }
  if (a is String && a is Any) {
    val i: Int = a.compareTo("")
  }
  if (a is String && a.compareTo("") == 0) {}
  if (a is String || a.<error descr="[UNRESOLVED_REFERENCE] Unresolved reference: compareTo">compareTo</error>("") == 0) {}
}

//mutability
fun f(): String {
    var a: Any = 11
    if (a is String) {
        val i: String = a
        a.compareTo("f")
        val f: Function0<String> = <error descr="[INITIALIZER_TYPE_MISMATCH] Initializer type mismatch: expected kotlin/Function0<kotlin/String>, actual kotlin/Function0<kotlin/Int>">{
            a = 42
            a
        }</error>
        return <error descr="[RETURN_TYPE_MISMATCH] Return type mismatch: expected kotlin/String, actual kotlin/Int">a</error>
    }
    return ""
}

class Mutable(var x: String?) {

    val xx: String?
        get() = x

    fun foo(): String {
        if (x is String) {
            return <error descr="[SMARTCAST_IMPOSSIBLE] Smart cast to 'kotlin/String' is impossible, because 'this@R|/Mutable|.R|/Mutable.x|' is a mutable property that could have been changed by this time">x</error>
        }
        if (x != null) {
            return <error descr="[SMARTCAST_IMPOSSIBLE] Smart cast to 'kotlin/String' is impossible, because 'this@R|/Mutable|.R|/Mutable.x|' is a mutable property that could have been changed by this time">x</error>
        }
        if (xx is String) {
            return <error descr="[SMARTCAST_IMPOSSIBLE] Smart cast to 'kotlin/String' is impossible, because 'this@R|/Mutable|.R|/Mutable.xx|' is a property that has open or custom getter">xx</error>
        }
        return ""
    }

    fun bar(other: Mutable): String {
        var y = other
        if (y.x is String) {
            return <error descr="[SMARTCAST_IMPOSSIBLE] Smart cast to 'kotlin/String' is impossible, because 'R|<local>/y|.R|/Mutable.x|' is a mutable property that could have been changed by this time">y.x</error>
        }
        return ""
    }
}

fun foo(aa: Any): Int {
    var a = aa
    if (a is Int) {
        return a
    }
    return 1
}

fun inForLoop(x: Any?) {
    if (x is Array<*>) {
        for (i in x) {}
    }
    for (i in <error descr="[ITERATOR_MISSING] ">x</error>) {}
}

class ExplicitAccessorForAnnotation {
    val tt: String? = "good"
        get

    fun foo(): String {
        if (tt is String) {
            return tt
        }
        return ""
    }
}
