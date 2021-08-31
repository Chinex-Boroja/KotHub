package simple.calculator

import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    println("Please enter an arithmetic problem.....")
    var input = readLine()
    while (input != null && input.isNotBlank()) {

        val value = input.split(' ')

        if (value.size < 3) {
            println("Invalid input. Expected value + value. Received: $input")
        }
        else {
            val operator = value[1]
            val lhs = value[0].toDoubleOrNull() ?: throw IllegalArgumentException("Invalid input: ${value[0]}")
            val rhs = value[2].toDoubleOrNull() ?: throw IllegalArgumentException("Invalid input: ${value[1]}")

            val output = when (operator) {
                "+" -> lhs + rhs
                "-" -> lhs - rhs
                "/" -> lhs / rhs
                "*" -> lhs * rhs
                else -> throw IllegalArgumentException("Invalid operator: $operator")
            }
            println(output)

        }
        input = readLine()
    }
}