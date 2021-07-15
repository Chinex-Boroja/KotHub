package classesAndObjects

data class DataUser(val name: String = " ", var age: Int = 0) {

    //fun copy(name: String = this.name, age: Int = this.age) = DataUser(name, age)
}

interface Expr

sealed class MathExpr {
    constructor() {

    }

    private constructor(vararg operands: Number) : this() {}
}
data class Const(val number: Double) : MathExpr()
data class Sum(val e1: Expr, val e2: Expr) : MathExpr()
object NotANumber : Expr

/**fun eval(expr: Expr): Double = when (expr) {
is Const -> expr.number
is Sum -> eval(expr.e1) + eval(expr.e2)
NotANumber -> Double.NaN
}
 */

fun main() {
    val person1 = DataUser("John")
    val person2 = DataUser("John")
    person1.age = 40
    person2.age = 50
    println("person1 == person2: ${person1 == person2}")
    println("person1  with age ${person1.age}: $person1")
    println("person2 with age ${person2.age}: $person2")

    val jane = DataUser("Jane", 35)
    val (name, age) = jane
    println("$name, $age years of age")
    // val jack = DataUser(name = "Jack", age = 1)
    //val olderJack = jack.copy(age = 2)
}
