package classesAndObjects
fun main() {
    val id1 = Individual("Chinedu", "Ihedioha", 38)
    val id2 = Individual("Alexis", "Martha", 38)
    val id3 = Individual()
    println(id3)

    println(id1 == id2)
    println(id1)
    println(id1.fullName())
    println(id2.nameLength())

    //Component method in Kotlin mainly used for destructuring
    val (fName, lName, personAge) = id1

    val firstName = id1.firstName
    val lastName = id1.lastName
    val age = id1.age

    println(fName)
    println(lName)
    println(personAge)
    
    println(id1.component1())
    println(id1.component2())
    println(id1.component3())
    println(id2.component1())
    println(id2.component2())
    println(id2.component3())
    println(id3.component3())

    //Creating a Copy of some files
    val sibling = id2.copy(firstName ="Innocent", age = 50)
    println(id2)
    println(sibling)

    val order = PurchaseOrder(amount = 100, customer = sibling)
    println(order)

    val newOrder = order.copy(amount = 200)
    println(newOrder)

    val newOrder2 = order.copy(customer = id1)
    println(newOrder2)

    //built in data classes using pairs
    val pair = "foo" to "bar" //using the "to" syntax
    //val pair = Pair("foo", "bar")
    println(pair.first)
    println(pair.second)

    //Triple values
    val triple = Triple("foo", "bar", "win")

}
//implementing Copy
data class PurchaseOrder(val amount: Int, val customer: Individual)
// equals / hashcode / toString
data class Individual(
    val firstName: String = "Unknown",
    val lastName: String = "unknown",
    val age: Int = 0
) {
    fun fullName(): String {
        return "$firstName $lastName"
    }
    fun nameLength(): Int = fullName().length
}