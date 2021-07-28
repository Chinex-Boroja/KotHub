package classesAndObjects

import java.awt.Color

open class Person1(var name: String, var age: Int) {
    fun info() {
        println("This person's name is $name and they are $age years(s) old")
    }
}
open class Chef1(name: String, age: Int, var favoriteFood: String) : Person1(name, age) {

    protected fun printMyFavoriteFood() {
        println(favoriteFood)
    }
    fun setMyFavoriteFood(food: String) {
        favoriteFood = food
        printMyFavoriteFood()
    }
}
class SousChef(name: String, age: Int, var favFood: String): Chef1(name, age, favFood) {

    init {
        printMyFavoriteFood()
    }
}

//Using Internal Modifier on Class

internal class Axel(val numberOfWheels: Int) {

}
open class Vehicle(var color: String) {
    private lateinit var axles: MutableList<Axel>
    
    fun info() {
        println("The vehicle is $color")
    }
    fun addAxel(numberOfWheels: Int) {
        axles.add(Axel(numberOfWheels))
    }
}
class Truck(color: String): Vehicle(color) {
    init {
        addAxel(6)
        addAxel(8)
    }
}