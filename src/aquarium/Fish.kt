package aquarium

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {

    val size: Int

    init {
        println("First init block")
    }
    constructor(): this(true, 9){
        println("Running secondary constructor")
        println("implementing starts")
    }
    init {
        if (friendly) {
            size = volumeNeeded
        } else {
            size = volumeNeeded * 2
        }
    }
    init {
        println("constructed with fish of size $volumeNeeded final size ${this.size}")
    }
    init {
        println("last init block")
    }
}
fun makeDefaultFish() = Fish(true, 50)
fun fishExample() {
    val fish = Fish(true, 20)
    println("is this friendly? ${fish.friendly}. It needs volume ${fish.size}")
}

