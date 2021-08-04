package KotlinBootCamp

import java.lang.IllegalArgumentException

class CustomGetterSetter( email: String, pwd: String, age: Int, gender: Char) {
    var emailID: String = email
    get() {
        return field.toLowerCase()
    }
    var password: String = pwd
    set(value) {
        field = if (value.length > 6) value else throw
                IllegalArgumentException("password is too short")
    }
    var age: Int = age
    set(value) {
        field = if (value > 18) value else throw
                IllegalArgumentException("Must be 18+")
    }
    var gender: Char = gender
    set (value)  {
        field = if (value == 'M' || value == 'F') value else throw
                IllegalArgumentException("User should be Male or Female")
    }

}
fun main() {
    val bio = CustomGetterSetter(
        "ihediohachinedu21@gmail.com",
        "isAllAboutPracticeMan",
        18,
        'F')

    println("${bio.emailID}")
    bio.emailID = "chinex@yahoo.com"
    println("${bio.emailID}")
    bio.age = 25
    println("${bio.age}")
    bio.gender = 'F'
    println("${bio.gender}")
}