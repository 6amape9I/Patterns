package Core_and_Models

data class Student(
    var id: Int? = AutoIncrementId(),
    var name: String,
    var secondName: String,
    var fathersName: String,
    var phoneNumber: String? = null,
    var telegram: String? = null,
    var email: String? = null,
    var github: String? = null
)

fun AutoIncrementId(): Int {
    var id = 0
    return id++
}