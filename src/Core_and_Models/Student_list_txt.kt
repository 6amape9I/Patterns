package Core_and_Models

import java.io.File

class Student_list_txt: Super_Student_list(){

    private val students: MutableList<Student> = mutableListOf()



    fun readFromFile(fileName: String) {
        students.clear()
        students.addAll(Student.read_from_txt(fileName))
    }

    fun writeToFile(fileName: String) {
        Student.write_to_txt(fileName, students)
    }

}