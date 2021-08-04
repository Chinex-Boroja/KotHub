package spices

fun main() {
    println("this is the main function and the entry point of this program")

}
abstract class Spice(val nameOfSpice: String,
                     val spiciness: String = "mild", color: SpiceColor):
    SpiceColor by color {

    abstract fun prepareSpice()
}
class Curry(nameOfSpice: String, spiciness: String,
            color: SpiceColor = YellowSpiceColor) :

    Spice(nameOfSpice, spiciness, color), Grinder {
    override fun grind() {
    }
    override fun prepareSpice() {
        grind()
    }
}

interface Grinder {
    fun grind()
}
interface SpiceColor {
    var color: String

}
object YellowSpiceColor: SpiceColor {
    override var color = "Yellow"
}