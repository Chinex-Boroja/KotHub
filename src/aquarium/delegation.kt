package aquarium

fun main(args: Array<String>) {
    delegate()
}
fun delegate() {
    val pleco = Plecostomuses()
    println("Fish has color ${pleco.color }")
    pleco.eats()
}

interface ActionOfTheFish {
    fun eats()
}
interface ColorOfTheFish {
    val color: String
}
class Plecostomuses(fishColor: ColorOfTheFish = RedColor):
    ActionOfTheFish by PrintingFishAction("a lot of algae"),
    ColorOfTheFish by fishColor

object GoldColor: ColorOfTheFish {
    override val color = "gold yellow"
}
object RedColor: ColorOfTheFish {
    override val color = "red"
}
class PrintingFishAction(private val food: String): ActionOfTheFish {
    override fun eats() {
        println(food)
    }
}
