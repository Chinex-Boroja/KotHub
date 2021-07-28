package classesAndObjects

fun main () {
    var lambo = Lambo()
    var mayBack = MayBack("Black", 4, 2)
    var astonMartin = AstonMartin("silver", 4, 4)

}

abstract class Motor(var color: String, val numberOfWheels: Int, val numberOfDoors: Int) {
    // Not allowed to create an instance of an Abstract class, use actual implementation

    abstract fun drive()
    abstract fun stop()

    fun openDoor() {
    }
    fun turnOffIgnition() {
    }
}

//Implementation of an Abstract class
abstract class TwoDoorCar( color: String, numberOfWheels: Int):
    Motor(color, numberOfWheels, 2) {
    abstract fun driveFast()
}
class Lambo: TwoDoorCar("Red", 4) {
    override fun drive() {
        //just drive
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override fun driveFast() {
        //just drive fast
    }
}
class AstonMartin(color: String, numberOfWheels: Int, numberOfDoors: Int):
Motor(color, numberOfWheels, numberOfDoors) {
    override fun drive() {
        //smoothRide
    }

    override fun stop() {
        TODO("Not yet implemented")
    }
}
class MayBack(color: String, numberOfWheels: Int, numberOfDoors: Int):
        Motor(color, numberOfWheels, numberOfDoors) {
    override fun drive() {
        //fastRide
    }

    override fun stop() {
        TODO("Not yet implemented")
    }
}
