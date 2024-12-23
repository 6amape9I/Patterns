package Core_and_Models

class Students_list_JSON : Super_Student_list() {

    private val students: MutableList<Student> = mutableListOf()

    fun readFromFile(fileName: String) {
        students.clear()
        students.addAll(Student.read_from_JSON(fileName))
    }

    fun writeToFile(fileName: String) {
        Student.write_to_JSON(fileName, students)
    }

}