package enum_demo

class User (
    var firstName: String, var lastName: String,
    var accountType: AccountType = AccountType.PLATINUM
) {

    fun fullName(): String = "$firstName - $lastName"
    override fun toString(): String {
        return fullName()
    }
}
