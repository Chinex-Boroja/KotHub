package classesAndObjects
import classesAndObjects.Chef
import classesAndObjects.Person
import nestedClass.Vehicle

fun main() {
    val p = Person("Chinedu", 37)
    val fav = Chef("Uche", 20, "Burger")

    p.printMyFavoriteFood()

    fav.printMyFavoriteFood()
    fav.setMyFavoriteFood("Fufu")
    fav.printMyFavoriteFood()

    val p1 = Person1("Amaka", 23)
    val fav2 = Chef1("Bob", 55, "Hamburger")

    fav2.setMyFavoriteFood("Akara")

    //Using Internal Modifier on a class
    val v = Vehicle("Red")

    v.addAxel(9)
}