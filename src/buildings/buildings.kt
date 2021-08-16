package buildings

open class BaseBuildingMaterial() {
    open val numberNeeded = 1
}

class Wood : BaseBuildingMaterial() {
    override val numberNeeded = 4
}
class Brick: BaseBuildingMaterial() {
    override val numberNeeded = 8
}
class Building<out T: BaseBuildingMaterial>(val buildingMaterial: T) {

    private val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println("$actualMaterialsNeeded ${baseMaterialsNeeded::class.simpleName} required")
    }
}

fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) println("small building")
    else println("large building")
}

fun main(args: Array<String>) {
    Building(Wood()).build()
    isSmallBuilding(Building(Brick()))
}