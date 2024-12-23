
import Core_and_Models.StudentList.DBStrategy
import Core_and_Models.StudentList.Super_Student_list
import Core_and_Models.StudentList.TxtStrategy


fun main() {
    val ssl = Super_Student_list(TxtStrategy())

    ssl.SetStragegy(DBStrategy())
    var students = ssl.read("src/StudentList.txt")

    ssl.SetStragegy(TxtStrategy())
    var stud = ssl.read("students.txt")
    ssl.SetStragegy(DBStrategy())

    ssl.write("src/StudentList.txt")
    ssl.read("src/StudentList.txt")
    println("")



}

