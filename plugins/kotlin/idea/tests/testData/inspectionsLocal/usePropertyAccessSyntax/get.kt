// PROBLEM: "Use of getter method instead of property access syntax"
// WITH_STDLIB
import java.io.File

fun foo(file: File) {
    file.getAbsolutePath<caret>()
}