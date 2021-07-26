package classesAndObjects
import classesAndObjects.Chef
import classesAndObjects.Person

fun main() {
    val p = Person("Chinedu", 37)
    val fav = Chef("Uche", 20, "Burger")

    p.printMyFavoriteFood()

    fav.printMyFavoriteFood()
    fav.setMyFavoriteFood("Fufu")
    fav.printMyFavoriteFood()
}