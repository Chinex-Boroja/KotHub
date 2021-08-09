package KotlinBootCamp

//to Create a singleton, use the object keyword

object MobyDickWhale {
    // kotlin will instantiate only one instance of the class
    val author = "Herman Melville"

    fun jump() {

    }
}
//Enum class helps to enumerate items
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00)
}
//subclassed ony inside the file which you have declared
sealed class Seal

class SeaLion: Seal()
class Walrus: Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}
