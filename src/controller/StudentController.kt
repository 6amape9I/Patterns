package controller

import Core_and_Models.Student.Student
import Core_and_Models.StudentList.Super_Student_list
import Core_and_Models.StudentList.TxtStrategy
import javafx.collections.FXCollections
import javafx.collections.ObservableList

class StudentController {
    val students: ObservableList<Student> = FXCollections.observableArrayList()
    val filtered_students: ObservableList<Student> = FXCollections.observableArrayList()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun load(){
        val ssl = Super_Student_list(TxtStrategy())
        students.clear()
        students.addAll(ssl.read("students.txt"))
    }


    fun addStudents(students: MutableList<Student>) {
        this.students.addAll(students)
    }

    fun updateStudent(oldStudent: Student, newStudent: Student) {
        val index = students.indexOf(oldStudent)
        if (index >= 0) {
            students[index] = newStudent
        }
    }

    fun deleteStudent(student: Student) {
        students.remove(student)
    }
}