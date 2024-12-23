package Core_and_Models.StudentList

import Core_and_Models.Student.Student
import java.io.File

class TxtStrategy: StudentList{
    override fun read(fileName: String) : MutableList<Student>{
        val students = mutableListOf<Student>()
        val lines = File(fileName).readLines()
        for (line in lines) {
            println(line)
            students.add(Student(line))
        }
        return students
    }
    override fun write(fileName: String, students: MutableList<Student>) {
        val file = File(fileName)
        file.writeText("")
        for (student in students) {
            file.appendText(student.toString() + "\n")
        }
    }

}