package classesAndObjects

//Operations in collection class

fun main(args: Array<String>) {
    val names: List<String> = listOf("John", "Amanda", "James", "Frank", "Emily", "Joy", "Mitchell")
    val filtered : List<String> = names.filter { it.toLowerCase().contains("n") }
    println(filtered)

    val ages :List<Int> = listOf(23, 33, 12, 9, 17, 19, 99)
    val adults :List<Int> = ages.filter (::isAdult )
    println(adults)

    val result :String? = names.firstOrNull() { it == "Jo" }
    //val result1 :String? = names.first { it.toLowerCase().contains("James") }

    println(result?.length)
    //println(result1)

    val approved :MutableList<String> = mutableListOf("Daniele", "Paul")
    names.filterNotTo(approved) { it.contains("a") }

    println(approved)

    val mine :List<String> = listOf("Apples", "Grapes")
    val theirs :List<String> = listOf("Oranges", "Pears", "Strawberries")
    val others :List<String> = listOf("Kiwi", "Watermelon")
    val allOfUs :List<List<String>> = listOf(mine, theirs, others)

    //println(allOfUs)
    //println(allOfUs.flatten())

    val mineArray :Array<String> = arrayOf("Apples", "Grapes")
    val theirsArray :Array<String> = arrayOf("Oranges", "Pears", "Strawberries")
    val othersArray :Array<String> = arrayOf("Kiwi", "Watermelon")
    val allArrays :Array<Array<String>> = arrayOf(mineArray, theirsArray, othersArray)

    println(allArrays)
    println(allArrays.flatten())

    val result2 :List<String> = mine.plus(theirs).plus(others)
    println(result2)

    //Map operator
    val items = listOf("Ihedioha Chinedu", "Jane Doe", "Katrina Kait", "John Wick", "Mundial Futbol")
    val abbreviations = items.map { it.substring(0,3).toUpperCase() }
        .sumBy { it.length }
    println(abbreviations)


}
fun isAdult(value: Int): Boolean {
    //
    //
    //
    return value >= 18
}