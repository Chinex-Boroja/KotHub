package KotlinBootCamp

open class Book(var title: String, var author: String) {

    private var currentPage = 1
    open fun readPage() {
        currentPage++
    }
}
class EBook(title: String, author: String, var format: String = "Text"):
    Book(title, author) {

    private var wordsRead = 0
    override fun readPage() {
        wordsRead += 250

    }
}

class BookClass(var title: String, var author: String, var year: Int) {


    fun getAuthorAndTitle(): Pair<String, String> {
        return (title to author)
    }

    fun getAuthorTitleAndYear(): Triple<String, String, Int> {
        return Triple(title, author, year )
    }
}

fun main(args: Array<String>) {
    var book = BookClass("Things Fall Apart", "Chinua Achebe", 1973)
    val bookTitleAuthor = book.getAuthorAndTitle()
    val bookTitleAuthorYear = book.getAuthorTitleAndYear()

    println("Here is your book ${bookTitleAuthor.first} written by ${bookTitleAuthor.second}")
    println("Here is your book ${bookTitleAuthorYear.first} written by ${bookTitleAuthorYear.second} " +
            "in ${bookTitleAuthorYear.third}")

    //learning pairs
    val equipment = "fishnet" to "catching fish"
    println(equipment.first)

    val equipment1 = "fishnet" to "catching fish" to "of big size" to "and strong"
    println(equipment1)

    val equipment2 = "fishnet" to "catching fish" to "of big size" to "and strong"
    val equip = ("fishnet" to "catching fish") to ("of big size" to "and strong")
    val fishnet = "fishnet" to "catching fish"
    val (tool, use) = fishnet
    println("The $tool is a tool for $use")

    val fishnetString = fishnet.toString()
    println(fishnetString)

    println(fishnet.toList())

    fun giveMeTool(): Pair<String, String> {
        return ("fishnet" to "catching")
    }

    val (tool1, use1) = giveMeTool()
    println(tool1)
    println(use1)


}