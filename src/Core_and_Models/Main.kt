package Core_and_Models

import Core_and_Models.Student.Companion.read_from_JSON
import Core_and_Models.Student.Companion.read_from_YAML
import Core_and_Models.Student.Companion.read_from_txt
import Core_and_Models.Student.Companion.write_to_JSON
import Core_and_Models.Student.Companion.write_to_YAML
import Core_and_Models.Student.Companion.write_to_txt

fun main() {

    val students = read_from_txt("students.txt")
    val chek = write_to_YAML("students.yaml", students)
    val chek2 = write_to_JSON("students.json", students)

    val students_yaml = read_from_YAML("students.yaml")

    students_yaml.forEach {
        println(it)
    }

}