package basics

fun main() {
    for (i in 1..3) {
        //println(i)
    }
    for (i in 6 downTo 0 step 2) {
        //println(i)
    }
    //iterate through a list with an index
    val array = arrayOf("a", "b", "c")
    for (i in array.indices) {
        println(array[i])
    }
    //Alternatively
    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }
    foo()
    foo1()
    addLabel()
    foo2()
}
//return expression
fun foo() {
    listOf(1, 2, 3, 4, 5).forEach() {
        if (it == 6) return
    }
    println("this point is unreachable")
}
fun addLabel() {
    listOf(1, 2, 4, 5, 6).forEach lit@{
        if (it == 3)
            print(it)
    }
    println(" done with explicit label")
}
fun foo1() {
    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
        if (value == 3) return  // local return to the caller of the anonymous function - the forEach loop
        print(value)
    })
    println(" done with anonymous function")
}
fun foo2() {
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 5) return@loop
            println(it)
        }
    }
    println("done with nested loop")
}
