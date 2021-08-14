package aquarium.generics

fun main(args: Array<String>) {

    val production1 : Production<Food> = FoodStore()
    val production2 : Production<Food> = FastFoodStore()
    val production3 : Production<Food> = InOutGrills()

    //for 'in' generic, we could assign a class of super-type to a class of subtype
    val consumer1 : Consumer<BigShollaGrills> = Everybody()
    val consumer2 : Consumer<BigShollaGrills> = ModernPeople()
    val consumer3 : Consumer<BigShollaGrills> = ComputerGuys()
}

//produce = output out
interface Production<out E> { //known as covariant
    fun produce(): E
}
interface Consumer<in E>{
    //Contravariance
    fun consume(item: E) //consume = input = in
}
//invariant type
interface ProductionConsumer<E> {
    fun produce(): E
    fun consume(item: E)
}
// for "out" generic, we can assign a class of subtype to a class of super-type
open class Food
open class FastFood : Food()
class BigShollaGrills : FastFood()

class FoodStore : Production<Food> {
    override fun produce(): Food {
        println("Produce food")
        return Food()
    }
}

class FastFoodStore : Production<FastFood> {
    override fun produce(): FastFood {
        println("Produce fast food")
        return FastFood()
    }
}
class InOutGrills : Production<BigShollaGrills> {
    override fun produce(): BigShollaGrills {
        println("Produce BigShollaGrills")
        return BigShollaGrills()
    }
}

class Everybody : Consumer<Food> {
    override fun consume(item: Food) {
        println("Eat food")
    }
}

class ModernPeople : Consumer<FastFood> {
    override fun consume(item: FastFood) {
        println("Eat fast food")
    }
}

class  ComputerGuys : Consumer<BigShollaGrills> {
    override fun consume(item: BigShollaGrills) {
        println("Eat Grills made by Shola")
    }
}