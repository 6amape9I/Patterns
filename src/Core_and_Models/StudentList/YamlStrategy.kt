package Core_and_Models.StudentList

import Core_and_Models.Student.Student
import java.io.File

class YamlStrategy: StudentList{

    override fun read(fileName: String) : MutableList<Student>{
        val students = mutableListOf<Student>()
        val yaml = File(fileName).readText()
        val regex = Regex("- id: (\\d+)\n  name: (\\w+)\n  secondName: (\\w+)\n  fathersName: (\\w+)\n  phoneNumber: (\\+\\d{10,12})\n  telegram: (@\\w+)\n  email: (\\w+@\\w+\\.\\w+)\n  github: (\\w+)")
        regex.findAll(yaml).forEach {
            val (id, name, secondName, fathersName, phoneNumber, telegram, email, github) = it.destructured
            students.add(Student(id.toInt(), name, secondName, fathersName, phoneNumber, telegram, email, github))
        }

        return students
    }
    override fun write(fileName: String, students: MutableList<Student>) {
        val file = File(fileName)
        file.writeText("")
        students.forEach { student ->
            val yaml = """
            - id: ${student.id}
              name: ${student.name}
              secondName: ${student.secondName}
              fathersName: ${student.fathersName}
              phoneNumber: ${student.phoneNumber}
              telegram: ${student.telegram}
              email: ${student.email}
              github: ${student.github}
        """.trimIndent()
            file.appendText(yaml + "\n")
        }
    }


}