package Core_and_Models

fun main() {
    val student = Student(
        name="John",
        secondName="Doe",
        fathersName="Doe",
        phoneNumber="+1234567890",
        telegram="@johndoe",
        email="rffvokm@nvfjkv.com",
        github="johndoe"
    )
    val student2 = Student(
        name="John",
        secondName="Doe",
        fathersName="Doe",
        phoneNumber="+1234567890",
        telegram="@johndoe",
        email="jsviksfjv@nskfvj.com",
        github="johndoe"
    )
    val StuHas = HashMap<String, Any?>(
        mapOf(
            "name" to "John",
            "secondName" to "Doe",
            "fathersName" to "Doe",
            "phoneNumber" to "+1234567890",
            "telegram" to "@johndoe",
            "email" to "dfnvkdjvn@oifdv.com",
            "github" to "johndoe"
    )
    )

    val student3 = Student(StuHas)

    val students = mutableListOf(student, student2, student3)
    students.forEach { println(it) }

    println(student.phoneNumber)
}