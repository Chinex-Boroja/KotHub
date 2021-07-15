package classesAndObjects

private fun justDemo() {} // visible inside demoFile.kt

public var bar: Int = 5 // property is visible everywhere
    private set // setter is visible only in demoFile.kt
internal val baz = 6 // Visible inside the same module

// Just like regular members of the companion object, they can be called using only the class name as the qualifier:
class MyClass {
    companion object {

    }
}

fun MyClass.Companion.printCompanion() {
    println("companion")
}

// Declaring extensions as members
class Host(val hostname: String) {
    fun printHostname() {
        print(hostname)
    }
}

//Declaring extensions as members
class Connection(private val host: Host, private val port: Int) {
    private fun printPort() {
        print(port)
    }

    private fun Host.printConnectionString() {
        printHostname() // calls Host.printHostname()
        print(":")
        printPort() //calls Connection.printPort()
    }

    fun connect() {
        host.printConnectionString()    // calls the extension function
    }
}

//Extensions declared as members can be declared as open and overridden in subclasses.
// This means that the dispatch
// of such functions is virtual with regard to the dispatch receiver type,
// but static with regard to the extension receiver type.

open class Base {}
class Derived : Base() {}

open class BaseCaller {
    open fun Base.printFunctionInfo() {
        println("Base extension function in BaseCaller")
    }

    open fun Derived.printFunctionInfo() {
        println("Derived extension function in BaseCaller")
    }

    fun call(b: Base) {
        b.printFunctionInfo() // call the extension function
    }
}

class DerivedCaller : BaseCaller() {
    override fun Base.printFunctionInfo() {
        println("Based extension function in DerivedCaller")
    }

    override fun Derived.printFunctionInfo() {
        println("Derived extension function in DerivedCaller")
    }
}

fun main() {
    BaseCaller().call(Base()) //"Base extension function in BaseCaller"
    DerivedCaller().call(Base()) //"Base extension function in DerivedCaller
    DerivedCaller().call(Derived()) //"Base extension function in DerivedCaller

    //Declaring extensions as members
    Connection(Host("kotl.in"), 443).connect()

    //Companion object extensions
    MyClass.printCompanion()

    //This example prints Shape,
    // because the extension function called depends only on the declared type of the parameter s, which is the Shape class.
    open class Shape()

    class RectangleShape : Shape()

    fun Shape.getName() = "Shape"
    fun RectangleShape.getName() = "Rectangle"

    fun printClassName(s: Shape) {
        println(s.getName())
    }

    printClassName(RectangleShape())


    //Member function always wins. Extension functions can also extend member functions with different parameters
    class Example {
        fun printFunctionType() {
            println("Class method")
        }
    }

    fun Example.printFunctionType(i: Int) {
        println("Extension function")
    }
    Example().printFunctionType(1)
}
//Companion object extensions
//To use an extension outside its declaring package, import it at the call site:
