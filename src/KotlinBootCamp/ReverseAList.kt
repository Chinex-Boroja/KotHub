package KotlinBootCamp

fun main(args: Array<String>) {

    val testList: List<Int> = listOf(11,12,13,14,15,16,17,18,19,20)

    println(testList.reversed())
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