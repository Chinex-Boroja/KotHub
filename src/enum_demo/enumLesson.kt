package enum_demo

fun main() {
    //iterate over an enum class
    for (accountVariety in AccountVariety.values()) {
        // println("Different types of accounts: $accountVariety")
        //AccountVariety.values().forEach { println(it) }
    }

    val accountTypeFromApi = "silver"
    val accountType = AccountType.valueOf(accountTypeFromApi.toUpperCase())

    val users = User("Chinedu", "Ihedioha", AccountType.PLATINUM)
    println(accountType)
    println(AccountType.GOLD)
    println(AccountType.GOLD.discountPercent)
    println(AccountType.GOLD.numberOfSubscriptions)

    val value = AccountType.valueOf("Bronze".toUpperCase())
    println(value)
    println(value.discountPercent)
    println(value.numberOfSubscriptions)

    val fromApi = "fiXED"
    val accountType1 = AccountVariety.valueOf(fromApi.toUpperCase())
    println(accountType1.calculateDiscountPercent())

    //Kotlin Switch statement is know as a "When"
    val user = User("Chinedu", "Ihedioha")
    when (user.firstName) {
        "Chinedu" -> {
            println("This is Chinedu")
        }
    }

    val account = Account.getAccountTypeByName("Student")
    println("Account type is of: $account's")
}
// to add a static method to an enum, use a companion object
enum class Account {
    STUDENT,
    COOPERATE,
    FAMILY,
    SOLE;

    companion object {
        fun getAccountTypeByName(name: String) = valueOf(name.toUpperCase())
    }
}
enum class AccountType(val discountPercent: Int, val numberOfSubscriptions: Int) {
    BRONZE(10, 20),
    SILVER(15, 15),
    GOLD(20, 10),
    PLATINUM(25, 5)
}
enum class AccountVariety {
    SAVINGS {
        override fun calculateDiscountPercent() = 5
    },
    CURRENT {
        override fun calculateDiscountPercent() = 10
    },
    FIXED {
        override fun calculateDiscountPercent() = 40
    };

    // how to implement abstract method in an enum class
    abstract fun calculateDiscountPercent(): Int
}
