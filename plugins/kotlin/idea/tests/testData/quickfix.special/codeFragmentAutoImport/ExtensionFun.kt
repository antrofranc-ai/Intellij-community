// WITH_STDLIB
import java.util.concurrent.locks.*

fun foo(lock: ReentrantReadWriteLock) {
    <caret>val v = 1
}