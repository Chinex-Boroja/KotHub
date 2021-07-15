package basics

//top level declaration
val PI = 3.14
var x = 0

fun incrementX() {
    x = +1
}

fun sum(a: Int, b: Int) = a + b
fun printSum(a: Int, b: Int) {
    println("basics.sum of $a and $b is ${a + b}")
}

//Conditional expressions
fun maxOf(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

fun main() {
    println("max of a and b is: ${maxOf(0, 48)}")

    println("basics.sum of 20 and 68 is ${sum(20, 68)}")
    println(sum(3, 5))
    println(printSum(3, 7))

    println("basics.getX = $x; basics.getPI = $PI")
    incrementX()
    println("basics.getX = $x; basics.getPI = $PI")

    val rectangle = Rectangle(8.0, 10.0)
    println("The perimeter is ${rectangle.perimeter}")


    //String templates
    var a = 1
    //simple name in template
    val s1 = "a is $a"
    a = 2
    // arbitrary expression in template
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)

    //for loop expression
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items)
        println("the list of fruits $item")
    //or
    val fruits = listOf("orange, guava, pear")
    for (index in fruits.indices) {
        println("item at $index is ${fruits[index]}")
    }

    //while loop expression
    val things = listOf("apple", "banana", "kiwifruit")
    var indexes = 0
    while (indexes < things.size) {
        println("things at $indexes is ${things[indexes]}")
        indexes++
    }

    println(describe(1))
    println(describe("Hello"))
    println(describe(100L))
    println(describe(2))
    println(describe("other"))

    //Ranges
    val n = 10
    val m = 9
    if (n in 1..m + 1) {
        println("fits in range")
    }
    //check whether a number is out of range
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
    //iterate over a range
    for (x in 1..5) {
        println(x)
    }
    println()
    //iterate over a progression
    for (z in 1..10 step 2) {
        println(z)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        println(x)
    }
    //Collections
    val fruitItems = listOf("apple", "banana", "kiwiFruit")
    for (fruitItem in fruitItems) {
        println(fruitItem)
    }

    //Check if a collection contains an object using in operator.
    val listOfItems = setOf("Apple", "Banana", "Kiwifruit")
    when {
        "orange" in listOfItems -> println("Juicy")
        "Apple" in listOfItems -> println("apple is fine too")
    }
    //Using lambda expressions to filter and map collections
    val vegies = listOf("banana", "avocado", "apple", "kiwifruit")
    vegies
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { print(it) }
    println()

    //use a function returning nullable value:
    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("a", "b")

    //type checks and automatic casts
    fun printLength(obj: Any) {
        println("Getting the length of '$obj'. Result: ${getStringLength(obj)}")
    }
    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))
}

//type check and casts
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }
    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

//fun basics.getStringLength(obj: Any): Int? {
//    if (obj !is String) return null
//
//    // `obj` is automatically cast to `String` in this branch
//    return obj.length
//}
//fun basics.getStringLength(obj: Any): Int? {
//    // `obj` is automatically cast to `String` on the right-hand side of `&&`
//    if (obj is String && obj.length > 0) {
//        return obj.length
//    }
//
//    return null
//}
//using a function returning nullable value
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    //using basics.getX*y yields error because they made hold nulls
    if (x !== null && y != null) {
        //basics.getX and y are automatically cast to non=nullable after null check
        println(x * y)
    } else {
        println("'$arg1 or '$arg2' is not a number")
    }
    /* if(basics.getX == null) {
    println("wrong number format in arg1: '$arg1'")
    return
    }
    if (y == null) {
    println("Wrong number format in arg2: '$arg2'")
    return
    }
    //basics.getX and y are automatically cast to non-nullable after null check
    println(basics.getX * y)
     */
}

//when expression
fun describe(obj: Any): String = when (obj) {
    1 -> "One"
    "Hello" -> "Greeting"
    is Long -> "Long"
    !is String -> "Not a string"
    else -> "Unknown"
}

class Rectangle(var height: Double, var length: Double) {
    var perimeter = (height + length) * 2
}
