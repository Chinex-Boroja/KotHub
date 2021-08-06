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