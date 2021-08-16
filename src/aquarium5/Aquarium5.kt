package aquarium5

data class Fish(var name: String)

fun main(args: Array<String>) {
    fishExamples()
    fishExamples0()
}

fun fishExamples() {
    val fish = Fish("splashy")

    //Higher order functions
    myWith(fish.name) {
       // this.capitalize() //object is implicitly referenced by the word this
        println(capitalize())
    }
    println(fish.run { name })
    println(fish.apply {  })

    val fish2: Fish = Fish(name = "splashy").apply { name = "Sharky" }
    println(fish2.name)

    println(fish.let { it.name.capitalize() }
        .let { it + "fish" }.let { it.length }.let { it + 31 })

}
fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

//Inline function manipulation

data class Fish0(val name: String)

fun fishExamples0() {
    val fish = Fish0("splashy")

    //without inline an object is created every call to myWith
    myWith0(fish.name, object : Function1<String, Unit> {
        override fun invoke(name: String){
            name.capitalize()
        }
    })

    // with inline no object is created, and lambda body is inlined here
    fish.name.capitalize()
}
inline fun myWith0(name: String, block: String.() ->Unit) {
    name.block()
}