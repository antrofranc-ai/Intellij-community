// WITH_STDLIB

const val y = 0

class Your {
    companion object {
        @JvmField val <caret>z = y + 3
    }
}