package Core_and_Models

class Students_list_JSON {

    private val students: MutableList<Student> = mutableListOf()

    fun readFromFile(fileName: String) {
        students.clear()
        students.addAll(Student.read_from_JSON(fileName))
    }

    fun writeToFile(fileName: String) {
        Student.write_to_JSON(fileName, students)
    }

    fun getStudentById(id: Int): Student? {
        return students.find { it.id == id }
    }

    fun get_k_n_student_short_list(k: Int, n: Int): Data_list {
        val shortList = students.take(k).take(n)
        return Data_list(shortList)
    }

    fun SortByName() {
        students.sortBy { it.name }
    }

    fun sortBySurnameInitials() {
        students.sortBy { "${it.secondName} ${it.name.firstOrNull() ?: ""}${it.fathersName?.firstOrNull() ?: ""}" }
    }

    fun addStudent(student: Student) {
        student.id = Student.AutoIncrementId()
        students.add(student)
    }

    fun replaceStudentById(id: Int, newStudent: Student): Boolean {
        val index = students.indexOfFirst { it.id == id }
        return if (index != -1) {
            newStudent.id = id
            students[index] = newStudent
            true
        } else {
            false
        }
    }

    fun removeStudentById(id: Int): Boolean {
        return students.removeIf { it.id == id }
    }

    fun getStudentShortCount(): Int {
        return students.size
    }
}