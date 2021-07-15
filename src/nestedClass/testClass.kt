package nestedClass

fun main() {
    val myCar = Vehicle()
    myCar.brand = "Mercedez Benz"
    myCar.info()

    val switch = myCar.SteeringWheel()
    switch.info()

    val transmission = myCar.Transmission()
    transmission.shift()
}