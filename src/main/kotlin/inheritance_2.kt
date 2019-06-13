open class Base_open(p: Int) {
    open val text = "base"

    open fun shout() {}
}

class Derived_override(p: Int) : Base_open(p) {
    override val text = "derived"

    override fun shout() {}
}