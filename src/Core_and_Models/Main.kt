package Core_and_Models

fun main() {
    val student = Student(
        name = "John",
        secondName = "Doe",
        fathersName = "Doe",
        phoneNumber = "+1234567890",
        telegram = "@johndoe",
        email = ""
    )
    println(student)
    println(student.phoneNumber)
}