package KotlinBootCamp

fun String.hasSpaces() = find { it == ' ' } != null

fun extensionExample() {
    "Does it have spaces?".hasSpaces() //resolves to true
}

open class AquariumPlant(val color: String, private val size: Int)

val AquariumPlant.isGreen: Boolean
    get() = color == "Green"

fun propertyExample() {
    val plant = AquariumPlant("Green", 50)
    plant.isGreen
}

//You can also make the class nullable
fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}
fun nullableExtension() {
    val plant: AquariumPlant? = null
    plant.pull()
}

class GreenLeafyPlant(size: Int): AquariumPlant("Green", size)

fun AquariumPlant.isRed() = color == "Red"
fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun staticExample() {
    val plant = GreenLeafyPlant(size = 50)
    plant.print() //resolves to GreenLeafyPlant

    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()
}
fun main(args: Array<String>) {
    staticExample()
}