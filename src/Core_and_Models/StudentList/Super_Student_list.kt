package Core_and_Models.StudentList

import Core_and_Models.Data.Data_list
import Core_and_Models.Student.Student

class Super_Student_list(strategy: TxtStrategy) {

    var strategy: StudentList = strategy
    private val students: MutableList<Student> = mutableListOf()

    fun SetStragegy(strategy: StudentList){
        this.strategy = strategy
    }

    fun read(fileName: String) : MutableList<Student> {
        students.clear()
        students.addAll(strategy.read(fileName))
        return students
    }

    fun write(fileName: String) {
        strategy.write(fileName, students)
    }

    /*fun getStudentById(id: Int): Student? {
        return students.find { it.id == id }
    }*/

    fun get_k_n_student_short_list(k: Int, n: Int): Data_list {
        val shortList = students.take(k).take(n)
        return Data_list(shortList)
    }

    fun sortByNameAndSurnameInitials() {
        students.sortBy { "${it.name} ${it.secondName} ${it.fathersName}" }
    }

    fun addStudent(student: Student) {
        students.add(student)
    }

    /*fun replaceStudentById(id: Int, newStudent: Student): Boolean {
        val index = students.indexOfFirst { it.id == id }
        return if (index != -1) {
            newStudent.id = id
            students[index] = newStudent
            true
        } else {
            false
        }
    }*/

    /*fun removeStudentById(id: Int): Boolean {
        return students.removeIf { it.id == id }
    }*/

    fun getStudentShortCount(): Int {
        return students.size
    }
}