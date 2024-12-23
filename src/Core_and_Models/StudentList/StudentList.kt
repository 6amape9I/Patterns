package Core_and_Models.StudentList

import Core_and_Models.Student.Student

interface StudentList {
    fun read(fileName: String) : MutableList<Student>
    fun write(fileName: String, students: MutableList<Student>)
}