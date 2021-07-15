package classesAndObjects
import kotlin.reflect.jvm.internal.impl.incremental.components.Position

open class RectangleDemo {
    open fun draw() {
        println("Draw a rectangle")
    }

    val borderColor: String get() = "black"
}

class FilledRectangle : RectangleDemo() {
    override fun draw() {
        val filler = Filler()
        filler.drawAndFill()
    }

    inner class Filler {
        fun fill() {
            println("Filling")
        }

        fun drawAndFill() {
            super@FilledRectangle.draw() // Calls Rectangle's implementation of draw()
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}")

        }
    }
}

open class Triangle {
    open fun draw() {
    }
}

interface Polygon {
    fun draw() { // Interface members are open by default
    }
}

class Square() : Triangle(), Polygon {
    override fun draw() {
        super<Triangle>.draw() // call to Triangle.draw
        super<Polygon>.draw() // call to Polygon.draw
    }
}

class Address {
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    var zip: String = "123456"

    fun copyAddress(address: Address): Address {
        val result = Address()
        result.name = address.name
        result.street = address.street
        result.zip = address.zip

        return result
    }

    //If you want to do something that does not fit into
    // this implicit backing field scheme, you can always fall back to having a backing property:

    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap() // Type parameters are inferred
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }
}

//interface inheritance
interface Named {
    val named: String
}

interface PersonBio : Named {
    val firstName: String
    val lastName: String

    override val named: String get() = "$firstName $lastName"
}

data class Employee(
    override val firstName: String,
    override val lastName: String,
    val position: Position
) : PersonBio

//creating an instance of a class


/**fun interface IntPredicate {
fun accept(i: Int): Boolean

}

val isEven = object : IntPredicate {
override fun accept(i: Int): Boolean {
return i % 2 == 0
}

} */

/**fun interface IntPredicate {
fun accept(i: Int): Boolean
}
val isEven = IntPredicate { it % 2 == 0 } */

fun main() {
    val fr = FilledRectangle()
    fr.draw()
    var call = Address()
    call.street = "transamadi"
    println(Address().city)

    println(call.copyAddress(Address()))

    //you can define the accessor without defining its body
}
class C private constructor(a: Int)

