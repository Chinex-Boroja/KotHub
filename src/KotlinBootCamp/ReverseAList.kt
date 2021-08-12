package KotlinBootCamp

fun main(args: Array<String>) {

    val testList: List<Int> = listOf(11,12,13,14,15,16,17,18,19,20)

    println(testList.reversed())

    val symptoms : MutableList<String> = mutableListOf("white spots", "red spots", "not eating", "bloated", "belly up")
    symptoms.add("white fungus")
    symptoms.remove("white fungus")

    symptoms.contains("red") //false
    symptoms.contains("red spots") //true

    println(symptoms.subList(4, symptoms.size))
    println(listOf(1, 5, 3).sum())
    println(listOf("a", "b", "cc").sumBy { it.length })

    val cures : Map<String, String> = mapOf("white spots" to "Ich", "red sores" to "hole disease")

    println(cures.get("white spots"))
    println(cures["white spots"])

    println(cures.getOrDefault("bloating", "sorry I dont know"))
    cures.getOrElse("bloating") {"No cure for this"}

    val inventory : MutableMap<String, Int> = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    inventory.remove("fish net")

    //practice time
    val allBooks = setOf("William ShakesSpare", "Halmet", "Macbet", "Romeo and Juliet", "Things fall Apart")
    val library = mapOf("Shakespeare" to allBooks)
    println(library.any{ it.value.contains("Hamlet") })

    val moreBooks = mutableMapOf<String, String>("Chinue Achebe" to "Schiller")
    moreBooks.getOrPut("Jungle Book") {"Kipling"}
    moreBooks.getOrPut("Halmet") {"Shakespeare"}
    println(moreBooks)
}
fun reverseList(list: List<Int>): List<Int> {
    val result: MutableList<Int> = mutableListOf<Int>()
    for (i: Int in 0..list.size - 1) {
        result.add(list[list.size - i - 1])
    }
    return result
}
fun reverseListAgain(list: List<Int>): List<Int> {
    val result : MutableList<Int> = mutableListOf<Int>()
    for (i:Int in list.size-1 downTo 0) {
        result.add(list.get(i))
    }
    return result
}