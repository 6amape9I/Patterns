package Core_and_Models.StudentList

import Core_and_Models.Student.Student
import java.io.File

class JsonStrategy: StudentList {

    override fun read(fileName: String): MutableList<Student> {
        val students = mutableListOf<Student>()
        val json = File(fileName).readText()
        val regex = Regex("\\{\\s*\"id\":\\s*(\\d+),\\s*\"name\":\\s*\"(\\w+)\",\\s*\"secondName\":\\s*\"(\\w+)\",\\s*\"fathersName\":\\s*\"(\\w+)\",\\s*\"phoneNumber\":\\s*\"(\\+\\d{10,12})\",\\s*\"telegram\":\\s*\"(@\\w+)\",\\s*\"email\":\\s*\"(\\w+@\\w+\\.\\w+)\",\\s*\"github\":\\s*\"(\\w+)\"\\s*}")
        regex.findAll(json).forEach {
            val (id, name, secondName, fathersName, phoneNumber, telegram, email, github) = it.destructured
            students.add(Student(id.toInt(), name, secondName, fathersName, phoneNumber, telegram, email, github))
        }

        return students
    }

    override fun write(fileName: String, students: MutableList<Student>) {
        val file = File(fileName)
        file.writeText("[\n")
        students.forEachIndexed { index, student ->
            val json = """
            {
            "id": ${student.id},
            "name": "${student.name}",
            "secondName": "${student.secondName}",
            "fathersName": "${student.fathersName}",
            "phoneNumber": "${student.phoneNumber}",
            "telegram": "${student.telegram}",
            "email": "${student.email}",
            "github": "${student.github}"}
        """.trimIndent()
            file.appendText(json)
            if (index < students.size - 1) {
                file.appendText(",\n")
            }
        }
        file.appendText("\n]")
    }


}