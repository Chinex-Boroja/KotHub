package classesAndObjects

fun String.initials(): String {
    val values = this.split(' ')
    val firstInitials = values[0].substring(0,1)
    val lastInitial = values[1].substring(0,1)
    return "$firstInitials$lastInitial"
}
fun Int.isAdult() = this >= 18

fun Name.fullName() = "${this.firstName} ${this.lastName}"