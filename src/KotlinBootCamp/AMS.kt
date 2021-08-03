package KotlinBootCamp

import java.util.*

fun main(args: Array<String>) {
    println("Hello, ${args[0]}!")
    feedTheFish()

    canAddFish(10.0, listOf(3,3,3))
    canAddFish(8.0, listOf(2,2,2), hasDecorations = false)
    canAddFish(9.0, listOf(1,1,3), 3)
    canAddFish(10.0, listOf(), 7, true)

    getFortuneCookie()
    println("\nYour fortune is: ${getFortuneCookie()}")

    var fortune: String
    for (i in 1..10) {
        fortune = getFortuneCookie()
        println("\nYour fortune is: $fortune")
        if (fortune.contains("Take it easy")) break
    }
    swim(50, speed = "slow")
}
fun canAddFish(tankSize: Double,
               currentFish: List<Int>,
               fishSize: Int = 2,
               hasDecorations: Boolean = true): Boolean {

    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() +fishSize)
}
//parameters with default values
fun swim(time: Int, speed: String = "Fast") {
    println("swimming $speed")
}
fun shouldChangeWater(
    day: String,
    temperature: Int = 22,
    dirty: Int = 20) : Boolean{

    return true
}

//Random food for each week
fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    shouldChangeWater(day,20,50)
    shouldChangeWater(day)
    shouldChangeWater(day = "Monday")

    if (shouldChangeWater(day)) {
        println("Change the water today")
    }
}
fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}
fun getFortuneCookie(): String {
    val fortunes = listOf("You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )
    print("\nEnter your birthday: ")

    val birthday = readLine()?.toIntOrNull() ?: 1
    return fortunes[birthday.rem(fortunes.size)]
}
fun fishFood(day: String) : String {
    var food = "fasting"

    //we can return a when value directly without needing to assign the value
    return when(day) {
        "Monday" -> "flakes"
        "Tuesday" -> "Pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}
