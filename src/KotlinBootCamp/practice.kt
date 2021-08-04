package KotlinBootCamp

import java.util.*

fun main(args:Array<String>) {

    gamePlay(rollDice2(4)) //Generate a dice everytime gameplay() is called
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")
    val sortLength = spices.filter { it.contains("curry") }.sortedBy { it.length }
    val cAndE = spices.filter { it.startsWith('c') }.filter { it.endsWith('e') }
    val firstThreeElements = spices.take(3).filter{it.startsWith('c')}

    val list = listOf(1, 2, 3)

    list.filter {
        it == 2
    }
    println(list)

    println(sortLength)
    println(cAndE)
    println(firstThreeElements)
    eagerExample()

    //lambda functions
    val swim = { println("swim\n")}
    swim()
    //lambdas can take argument just like name functions
    val dirty = 20
    val waterFilter = { dirty: Int -> dirty / 2 }
    waterFilter(dirty)

    println(whatShouldIDoToday("happy", "sunny"))
    println(whatShouldIDoToday("sad"))
    print("How do you feel")
    println(whatShouldIDoToday(readLine()!!))
}

fun myMood(mood: String, weather: String) = mood == "happy" && weather == "sunny"

fun checkMoodWeatherCold(mood: String, weather: String, temperature: Int) =
    mood == "sad" && weather == "rainy" && temperature == 0

fun isHotOrCold(temperature: Int) = temperature == 35

fun  whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {

    return when {
        isHotOrCold(temperature) -> "go swimming"
        checkMoodWeatherCold(mood, weather, temperature) -> "stay in bed"
        myMood(mood, weather) -> "go for a Walk"
        else -> "Stay home and read."

    }
}
fun eagerExample() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    val eager = decorations.filter { it[0] == 'p' }
    println(eager)

    //apply filter lazily
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println(filtered)
    println(filtered.toList())

    //apply map lazily
    val lazyMap = decorations.asSequence().map {
        println("map: $it")
        it
    }
    println(lazyMap)
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")
}
//Practice Time: Lambdas
val rollDice0 = { Random().nextInt(12) + 1 }

val rollDice = { sides: Int ->
    Random().nextInt(sides) + 1
}
val rollDice1 = {sides: Int ->
    if (sides == 0) 0
    else Random().nextInt(sides) + 1
}
val rollDice2: (Int) -> Int = { sides ->
    if (sides == 0) 0
    else Random().nextInt() + 1
}
fun gamePlay(diceRoll: Int) {
    println(diceRoll)
}
