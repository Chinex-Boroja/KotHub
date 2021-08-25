package classesAndObjects

fun main () {
    val lambo = Lambo()
    val acura = Acura()
    val mayBack = MayBack("Black", 4, 2)
    val astonMartin = AstonMartin("silver", 4, 4)

    driveMotor(lambo)
    driveMotor(acura)
    driveMotor(mayBack)
    driveMotor(astonMartin)
}

fun driveMotor(motor: Motor) {
    motor.drive()
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

    override fun drive() {
        driveFast()
    }
}
class Lambo: TwoDoorCar("Red", 4) {
    override fun drive() {
        println("drive fast")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override fun driveFast() {
        //just drive fast
    }
}
class Acura(): TwoDoorCar("Green", 4){
    override fun driveFast() {
        println("Zoom")
    }

    override fun drive() {
        println("zoom zoom")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

}
class AstonMartin(color: String, numberOfWheels: Int, numberOfDoors: Int):
Motor(color, numberOfWheels, numberOfDoors) {
    override fun drive() {
        println("presidential")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }
}
class MayBack(color: String, numberOfWheels: Int, numberOfDoors: Int):
        Motor(color, numberOfWheels, numberOfDoors) {
    override fun drive() {
        println("fast ride")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }
}
