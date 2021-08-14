package aquarium.generics

fun main(args: Array<String>) {
    genericExample()
}

open class WaterSupply(var needProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)
class LakeWater : WaterSupply(true){
    fun filter() {
        needProcessed = false
    }
}

class Aquarium<out T: WaterSupply>(val waterSupply: T){
    fun addWater() {
        check(!waterSupply.needProcessed) {
            "water supply needs processed"
        }
        println("adding water from $waterSupply")
    }
    inline fun <reified R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R

    /**fun addWater(cleaner: Cleaner<T>) {
        //{"water supply needs processed"}
        if(waterSupply.needProcessed) {
            cleaner.clean(waterSupply)
        }
        println("adding water supply $waterSupply")
    } */
}
fun <T: WaterSupply>isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${aquarium.waterSupply.needProcessed}")
}

//In Type Example
interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}
class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

//Out types
fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T
fun genericExample() {
    val aquarium:Aquarium<TapWater> = Aquarium(TapWater()) //uses Type Inference
    aquarium.waterSupply.addChemicalCleaners()
    val cleaner = TapWaterCleaner()
    //aquarium.addWater(cleaner
    isWaterClean(aquarium)
    aquarium.hasWaterSupplyOfType<TapWater>() //true
    aquarium.waterSupply.isOfType<LakeWater>() //false

    val aquarium2: Aquarium<LakeWater> = Aquarium(LakeWater())
    aquarium2.waterSupply.filter()
    //aquarium2.addWater()
    //Calling out type function
    //addItemTo(aquarium)
}