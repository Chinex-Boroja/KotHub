package basics

inline fun <reified A, reified B> Pair<*, *>.asPairOf(): Pair<A, B>? {
    if (first !is A || second !is B) return null
    return first as A to second as B
}

val somePair: Pair<Any?, Any?> = "items" to listOf(1, 2, 3)


val stringToSomething = somePair.asPairOf<String, Any>()
val stringToInt = somePair.asPairOf<String, Int>()
val stringToList = somePair.asPairOf<String, List<*>>()
val stringToStringList = somePair.asPairOf<String, List<String>>()
fun main() {
    // Kotlin
    val countDown = buildString {
        for (i in 5 downTo 1) {
            append(i)
            appendLine()
        }
    }
    println(countDown)

    val numbers = mutableListOf(1, 2, 3, 4, 5, 6)
    val oddNumbers = numbers
        .filter { it % 2 != 0 }
        .joinToString { "${-it}" }
    println(oddNumbers)
    //String template
    println(
        """
    Not
    trimmed
    text
    """
    )

    println(
        """
    Trimmed
    text
    """.trimIndent()
    )

    println()

    val a = """Trimmed to margin text:
          |if(a > 1) {
          |    return a
          |}""".trimMargin()

    println(a)

    fun printDouble(d: Double, i: Int, f: Float) {
        println(d)
        println(i)
        println(f)
    }

    val i = 1
    val d = 1.0
    val f = 1.0f

    printDouble(d, i, f)

    //nullable references to the same number can be different objects
    val a1: Int = 100
    val boxedA: Int? = a1
    val anotherBoxedA: Int? = a1

    val b: Int = 10000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b
    println(boxedA === anotherBoxedA)
    println(boxedB === anotherBoxedB)

    val b1: Byte = 1
    val b2: Int = b1.toInt()
    println(b2)

    val x1 = 5 / 2.toDouble()
    println(x1 == 2.5)

    val myTrue: Boolean = true
    val myFalse: Boolean = false
    val boolNull: Boolean? = null

    println(myTrue || myFalse)
    println(myTrue && myFalse)
    println(!myTrue)

    val aChar: Char = 'a'

    println(aChar)
    println('\n') //prints an extra newline character
    println('\uFF00')

    // String Operation
    var str = "abcd"
    println(str.toUpperCase())
    println(str)
    for (a in str) {
        println(a)
    }
    val s = "abc" + 1
    println(s + "def")

    //String literal
    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
    println(text)

    val price = """
        ${'$'}9.99
        """.trimIndent()
    println(price)

    //Arrays
    val asc = Array(5) { i -> (i * i).toString() }
    asc.forEach { println(it) }

    val x: IntArray = intArrayOf(1, 2, 4, 5)
    x[0] = x[1] + x[2]
    x.forEach { println(it) }

    var arr = IntArray(5) { it * 1 }
    arr.forEach { println(it) }

    println("stringToSomething = " + stringToSomething)
    println("stringToInt = " + stringToInt)
    println("stringToList = " + stringToList)
    println("stringToStringList = " + stringToStringList)
}


fun appendLine() {
}
/**class Array<T> private constructor() {
val size: Int = 0
operator fun get(index: Int): T {
index.and(6)
}
operator fun set(index: Int, value: T): Unit{

}

operator fun iterator(): Iterator<T>{

}
} */


