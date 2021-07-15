package nestedClass

class Vehicle {
    var brand: String = "unknown"
    fun info() = println(brand)

    inner class SteeringWheel {
        var name = "Leather"
        fun info() = println("$brand is the brand of vehicle with a $name steering wheel")
    }

    inner class Transmission {
        var type = "Automatic"
        fun shift() = println("The vehicle has shifted")
    }
}