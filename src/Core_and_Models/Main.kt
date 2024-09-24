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

    val StuString = "John,Doe,Doe,+1234567890,@johndoe,sdvnsdv@knsfvk.com,johndoe"

    val student4 = Student(StuString)

    val students = mutableListOf(student, student2, student3, student4)
    students.forEach { println(it) }

    student3.nameSetter("Jane")

    students.forEach { println(it) }
    println(student.phoneNumber)

    val check = Student().write_to_txt("students.txt", students)
    val stuList = Student().read_from_txt("students.txt")

    val dTable = Data_table(3, 3, "data")
    val dTable2 = Data_table(3.14)
    val dTable3 = Data_table(arrayOf(1, 2, 3))
    val dTable4 = Data_table("1,2,3\n4,5,6\n7,8,9")
    val dTable5 = Data_table(arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9)))
    val dTable6 = Data_table(3, 3, "data")

    println(dTable.get_by_row_col(1, 1))
    println(dTable2.get_by_row_col(0, 0))
    println(dTable3.get_by_row_col(1, 0))
    println(dTable4.get_by_row_col(1, 1))
    println(dTable5.get_by_row_col(2, 2))
    println(dTable6.get_by_row_col(1, 1))
}