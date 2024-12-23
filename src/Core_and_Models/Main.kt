package Core_and_Models

import Core_and_Models.StudentList.JsonStrategy
import Core_and_Models.StudentList.Super_Student_list
import Core_and_Models.StudentList.TxtStrategy


fun main() {

    var ssl = Super_Student_list(TxtStrategy())
    ssl.read("students.txt")
    ssl.sortByNameAndSurnameInitials()
    ssl.write("students.txt")
    println(ssl.getStudentShortCount())
    println(ssl.getStudentById(1))
    println(ssl.get_k_n_student_short_list(2, 2))
    println(ssl.getStudentShortCount())
    println(ssl.getStudentById(1))

    ssl.SetStragegy(JsonStrategy())
    ssl.read("students.json")
    ssl.sortByNameAndSurnameInitials()
    ssl.write("students.json")
    println(ssl.getStudentShortCount())
    println(ssl.getStudentById(1))
    println(ssl.get_k_n_student_short_list(2, 2))
    println(ssl.getStudentShortCount())


}