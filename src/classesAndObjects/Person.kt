package classesAndObjects

open class Person (var name: String, var age: Int) {
    protected var favoriteFood: String = "Unknown"

    fun info() {
        println("This person's name is $name and they are $age year(s) old")
    }
    //Print my favorite from the super class
    fun printMyFavoriteFood() {
        println(favoriteFood)
    }
}
class Chef(name: String, age: Int, favFood: String) : Person(name, age) {
    init {
        favoriteFood = favFood
    }
    fun setMyFavoriteFood(food: String) {
        favoriteFood = food
        //printMyFavoriteFood()
    }
}


