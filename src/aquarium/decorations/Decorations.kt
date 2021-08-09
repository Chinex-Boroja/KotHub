package aquarium.decorations

fun main(args: Array<String>) {
    makeDecorations()
}

fun makeDecorations() {
    val decorations0 = Decorations0("Granite")
    println("$decorations0")

    val decorations1 = Decorations0("Slate")
    println("$decorations1")

    val decorations2 = Decorations0("Slate")
    println("$decorations2")

    println(decorations0.equals(decorations1))
    println(decorations2.equals(decorations1))

    //copying data objects using copy() method

    val decorations3 : Decorations0 = decorations2.copy()
    println(decorations2)
    println(decorations3)

    val decorations4 = Decorations1("crystal", "wood","diver")
    println("$decorations4")

    //using a concept call decomposition
    val (rock: kotlin.String, wood: kotlin.String, diver: kotlin.String) = decorations4
    println(rock)
    println(wood)
    println(diver)
}
data class Decorations0(val rocks: String) {}

data class Decorations1(val rocks: String, val wood: String, val diver: String) {}

