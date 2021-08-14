//@file:JvmName("InteropFish")
package KotlinBootCamp

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

/**class InteropFish {
    companion object{
        @JvmStatic fun interop() {

        }
    }
}*/

@ImAPlant class Plant {
    fun trim() {}
    fun fertilizer() {}

    @get:OnGet
    val isGrowing: Boolean = true

    @set:Onset
    var needFood: Boolean = false
}
annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class Onset

fun reflections() {
    val classObj : KClass<Plant> = Plant::class
    //for (method: KFunction<*> in classObj.declaredMemberFunctions){
        //println(method.name)
    //}
    for (annotation: Annotation in classObj.annotations) {
        println(annotation.annotationClass.simpleName)
    }
    //find one annotation or null
    val annotated : ImAPlant? = classObj.findAnnotation<ImAPlant>()
    annotated?.apply {
        println("found a plant annotation")
    }
}
fun main() {
    reflections()
}


