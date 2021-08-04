package KotlinBootCamp

import java.util.*

fun main(args: Array<String>) {
    println("Hello, ${args[0]}")

    val isUnit = println("This is an expression")
    println(isUnit)

    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    val message = "you are ${ if (temperature > 50) "fried" else "safe"} fish"
    println(message)

    dayOfWeek()
}
fun dayOfWeek() {
    println("What is the day of the week?")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println(when (day) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "Time has stopped"

    })
}
