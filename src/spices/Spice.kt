package spices

import KotlinBootCamp.Color

fun main() {
    println("This is the main function and the entry point of this program")
    val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
        SpiceContainer(Curry("Red Curry","Medium")),
        SpiceContainer(Curry("Green Curry", "Spicy")))

    for (element in spiceCabinet) println(element.label)

}
//Making Spice a sealed class helps keep all the spices together in one file.
sealed class Spice(val nameOfSpice: String,
                     val spiciness: String = "mild", color: SpiceColor):
    SpiceColor by color {

    abstract fun prepareSpice()
}
data class SpiceContainer(var spice: Spice) {
    val label = spice.nameOfSpice
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
    var color: Color

}
object YellowSpiceColor: SpiceColor {
    override var color = Color.YELLOW
}