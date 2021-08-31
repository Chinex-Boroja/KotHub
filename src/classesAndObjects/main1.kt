package classesAndObjects

import java.lang.IllegalArgumentException
import java.util.concurrent.TimeUnit
import kotlin.system.measureNanoTime

fun main(args: Array<String>) {

    val groceryBags :List<ShoppingBag> = listOf(
        ShoppingBag(listOf("Grapes", "Apples", "Oranges")),
        ShoppingBag(listOf("Milk", "Eggs", "Pasta")),
        ShoppingBag(listOf("Bread", "Tea", "Coke"))
    )

    val retailBags: List<ShoppingBag> = listOf(
        ShoppingBag(listOf("Shirt", "Pants", "Trouser")),
        ShoppingBag(listOf("Socks", "Shoes")),
        ShoppingBag(listOf("Jacket", "Sweater", "Scarf"))
    )

    val groceries :List<String> = groceryBags.flatMap { it.items }
    println(groceries)

    //Set of value, Helper function
    val name :Set<String> = setOf("Donn", "John", "Felicia")

    val clothes :List<List<String>> = retailBags.map { it.items }
    println(clothes)

    val people = listOf(
        Person0("Chinedu"), Person0("Jake"), Person0("Janet")
    )

    people.map { it.name }.map { it.toUpperCase() }.forEach {
        println(it.reversed())
    }
    people.forEachIndexed{index, person ->
        println("Index: $index, Person: $person")
    }

    val states :Map<String, String> = mapOf(
        "NY" to "New York",
        "NJ" to "New Jersey",
        "CA" to "California"
    )
    val result :String = states.getOrDefault("NY", "UNKNOWN_VALUE")
    println(result)
    println(states.entries)
    println(states.keys)
    println(states.values)

    measure {
        //generating large sequences
        val sequence :Sequence<Int> = generateSequence(1) { it + 1 }
            .take(50_000_000)
            //.toList()

        //val output: Double = list.filter { it % 3 == 0 }.average()
        val output: Double = sequence.filter { it % 3 == 0 }.average()
        println("Done")
        println(output)
    }

    listOf("A", "B", "C").filter {
        println("filter: $it")
        true
    }
        .forEach { println("forEach: $it")
        }
    println("-------")

    sequenceOf("X", "Y", "Z")
        .filter {
            println("filter: $it")
            true
        }
        .forEach {
            println("forEach: $it")
        }

    //using double bang operator
    var identity: String? = "Donn"

    val length = requireNotNull(identity) { "The name should not be null" }.length
    println(length)

    val identity1: Person3? = Person3("Donn")
    println(identity1!!.name)

    val map = mapOf("Donn" to 32, "Tushar" to 45)

    //practicing generic class
    val listOfStrings: List<String> = listOf("Donn", "John", "Mary")
    val listOfInts: List<Int> = listOf(1, 2, 3, 4, 5)

    val result1 :EvenList<String> = EvenList(listOfStrings)
    println(result1.evenItems())

    val result2 = EvenList(listOfInts)
    println(result2.evenItems())

    val p = listOf(
        Person0("Felicia"),
        Person0("Emea"),
        Person0("Manuel"),
        Person0("Merlin")
    )
    println(EvenList(p).evenItems())

    //Exception Demo
    val human = Human("Donnie", 21)
    if (human.age < 18) {
        throw InvalidAgeException(human.age, "User is not old enough. User is too young")
    }

    val human1 = Human("Donny", 13)
    try {
        checkAge(human1)
        println("After check age")
    }catch (ex: IllegalArgumentException) {
        println("Handled")
    } finally {
        println("finally")
    }
    println("After try")


}
fun measure(block: () ->Unit) {
    val nanoTime :Long = measureNanoTime(block)
    val millis :Long = TimeUnit.NANOSECONDS.toMillis(nanoTime)
    println("$millis ms")
}

class ShoppingBag(val items: List<String>)

data class Person0(val name: String)

class Person3(val name: String)

//Generic class
class EvenList<T>(val list: List<T>) {
    fun evenItems(): List<T> {
        return list.filterIndexed{ index, value-> index % 2 == 0  }
    }
}

//Exception in Kotlin
class InvalidAgeException(val age: Int, message: String): IllegalArgumentException("Invalid age: $age. $message")

data class Human(val name: String, val age: Int)

private fun checkAge(p: Human) {
    if(p.age < 18){
        throw IllegalArgumentException("Boom")
    }
}