package KotlinBootCamp

import java.util.*

const val MAX_NUMBER_BOOKS = 20
object Constant {
    const val BASE_URL = "http://www.turtlecare.net"
}

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
        wordsRead += 250 }
}

class BookClass(var title: String, var author: String, var year: Int, var pages: Int) {

    fun getAuthorAndTitle(): Pair<String, String> {
        return (title to author)
    }

    fun getAuthorTitleAndYear(): Triple<String, String, Int> {
        return Triple(title, author, year )
    }
    fun canBorrow(hasBooks: Int): Boolean {
        return (hasBooks < MAX_NUMBER_BOOKS)
    }
    fun printURL() {
        println(Constant.BASE_URL + title + ".html")
    }
    companion object {
        val BASE_URL = "http://www.turtlecare.net/"
    }
}
//practice time
fun BookClass.weight(): Double { return (pages * 1.5) }
fun BookClass.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

class Puppy() {
    fun playWithBook(book: BookClass) {
        book.tornPages(Random().nextInt(12))
    }
}

fun main(args: Array<String>) {

    var book = BookClass("Things Fall Apart", "Chinua Achebe", 1973, 450)
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

    val puppy = Puppy()
    val book1 = BookClass("Oliver Twist", "Charles Dickens", 1873, 540)

    while (book1.pages > 0) {
        puppy.playWithBook(book1)
        println("${book1.pages} left in ${book1.title}")
    }
    println("Sad puppy, no more pages in ${book1.title}")
}