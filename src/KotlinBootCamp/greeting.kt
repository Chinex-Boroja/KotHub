package KotlinBootCamp

fun main(args: Array<String>) {
    if (args[0].toInt()<12) println("Good morning Kotlin")
    else println("Good night Kotlin")

    println("Good ${if (args[0].toInt()<12) "morning" else "night"},Kotlin")

    /** var fortune: String
    for (i in 1..10) {
    fortune = getFortune(getBirthday())
    println("\nYour fortune is: $fortune")
    if (fortune.contains("Take it easy")) break;
    } */

    /**var fortune: String = ""
    repeat(10) {
    fortune = getFortune(getBirthday())
    println("\nYour fortune is: $fortune")
    if (fortune.contains("Take it easy"))
    } */

    var fortune: String = ""
    while (!fortune.contains("Take it easy")) {
        fortune = getFortune(getBirthday())
        println("\nYour fortune is: $fortune")
    }
}

fun getBirthday(): Int {
    print("\nEnter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}

fun getFortune(birthday: Int): String {
    val fortunes = listOf("You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends, because they are your greatest fortune.")
    val index = when (birthday) {
        in 1..7 -> 4
        28, 31 -> 2
        else -> birthday.rem(fortunes.size)
    }
    return fortunes[index]
}