package classesAndObjects

typealias AuthToken = String

fun main() {
    val user = User("Donn", "23YTEFHF-JHXFTEYJ243")

    val name = "Donn Felker"
    println(name.initials())

    val age = 35
    println(age.isAdult())

    val name1 = Name("Chinedu", "Ihedioha", 78)
    println("${name1.fullName()}")

    val greeter: (String, String) -> String = {firstName: String, lastName: String ->
        val modifiedFirstName = firstName.toUpperCase()
        val modifiedLastName = lastName.toUpperCase()
        "Hello $modifiedFirstName $modifiedLastName"}

    val greeting = greeter("Chinedu", "Ihedioha")
    println(greeting)

    val greet = {name2: String -> println("hello $name2")}
    greet("Uzoma Ihedioha")

    lineLogger {
        println("message 1")
        println("message 2")
        println("message 3")
    }
    derbyAnnouncer { player: String ->
        "$player is a great asset to the team"
    }
}
fun derbyAnnouncer(block: (String) -> String) {
    val players = listOf(
        "Messi",
        "Ronaldo",
        "Mbappe",
        "Salah",
        "Mane",
        "Maguire"
    )
    val randomPlayer = players.random()
    println("The next player......$randomPlayer")
    val announcerMessage = block(randomPlayer)
    println(announcerMessage)
}

fun lineLogger(block: () -> Unit) {
    repeat(5) {
        println("----------")
    }
    block()
    repeat(5) {
        println("---------")
    }
}
data class User(val username: String, val authToken: AuthToken)

data class Account(val authToken: AuthToken)

data class Order(val authToken: AuthToken)

class Name(val firstName: String, val lastName: String, val age: Int)

