// "Create local variable '-'" "false"
// ACTION: Create extension function 'A.minus'
// ACTION: Create member function 'A.minus'
// ACTION: Replace overloaded operator with function call
// ERROR: Unresolved reference. None of the following candidates is applicable because of receiver type mismatch: <br>public inline operator fun BigDecimal.minus(other: BigDecimal): BigDecimal defined in kotlin<br>public inline operator fun BigInteger.minus(other: BigInteger): BigInteger defined in kotlin<br>public operator fun <T> Iterable<TypeVariable(T)>.minus(element: TypeVariable(T)): List<TypeVariable(T)> defined in kotlin.collections<br>public operator fun <T> Iterable<TypeVariable(T)>.minus(elements: Array<out TypeVariable(T)>): List<TypeVariable(T)> defined in kotlin.collections<br>public operator fun <T> Iterable<TypeVariable(T)>.minus(elements: Iterable<TypeVariable(T)>): List<TypeVariable(T)> defined in kotlin.collections<br>public operator fun <T> Iterable<TypeVariable(T)>.minus(elements: Sequence<TypeVariable(T)>): List<TypeVariable(T)> defined in kotlin.collections<br>public operator fun <K, V> Map<out TypeVariable(K), TypeVariable(V)>.minus(key: TypeVariable(K)): Map<TypeVariable(K), TypeVariable(V)> defined in kotlin.collections<br>public operator fun <K, V> Map<out TypeVariable(K), TypeVariable(V)>.minus(keys: Array<out TypeVariable(K)>): Map<TypeVariable(K), TypeVariable(V)> defined in kotlin.collections<br>public operator fun <K, V> Map<out TypeVariable(K), TypeVariable(V)>.minus(keys: Iterable<TypeVariable(K)>): Map<TypeVariable(K), TypeVariable(V)> defined in kotlin.collections<br>public operator fun <K, V> Map<out TypeVariable(K), TypeVariable(V)>.minus(keys: Sequence<TypeVariable(K)>): Map<TypeVariable(K), TypeVariable(V)> defined in kotlin.collections<br>public operator fun <T> Set<TypeVariable(T)>.minus(element: TypeVariable(T)): Set<TypeVariable(T)> defined in kotlin.collections<br>public operator fun <T> Set<TypeVariable(T)>.minus(elements: Array<out TypeVariable(T)>): Set<TypeVariable(T)> defined in kotlin.collections<br>public operator fun <T> Set<TypeVariable(T)>.minus(elements: Iterable<TypeVariable(T)>): Set<TypeVariable(T)> defined in kotlin.collections<br>public operator fun <T> Set<TypeVariable(T)>.minus(elements: Sequence<TypeVariable(T)>): Set<TypeVariable(T)> defined in kotlin.collections<br>public operator fun <T> Sequence<TypeVariable(T)>.minus(element: TypeVariable(T)): Sequence<TypeVariable(T)> defined in kotlin.sequences<br>public operator fun <T> Sequence<TypeVariable(T)>.minus(elements: Array<out TypeVariable(T)>): Sequence<TypeVariable(T)> defined in kotlin.sequences<br>public operator fun <T> Sequence<TypeVariable(T)>.minus(elements: Iterable<TypeVariable(T)>): Sequence<TypeVariable(T)> defined in kotlin.sequences<br>public operator fun <T> Sequence<TypeVariable(T)>.minus(elements: Sequence<TypeVariable(T)>): Sequence<TypeVariable(T)> defined in kotlin.sequences
class A

fun bar() {
    val a = A()
    return a <caret>- a
}