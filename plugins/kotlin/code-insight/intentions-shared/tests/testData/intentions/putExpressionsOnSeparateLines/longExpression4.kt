class MyClass(
    private val firstProp: Int,
    private val secondProp: Boolean,
    private val thirdProp: String,
) {
    override fun equals(other: Any?): Boolean {
        return this === other || other is MyClass && other.firstProp == firstProp && other.secondProp == secondProp &<caret>& other.thirdProp == thirdProp
    }
}