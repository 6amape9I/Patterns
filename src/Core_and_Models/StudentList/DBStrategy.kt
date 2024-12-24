package Core_and_Models.StudentList

import Core_and_Models.DB.DBConfig
import Core_and_Models.Student.Student

class DBStrategy: StudentList {

    override fun read(fileName: String): MutableList<Student> {
        val students = mutableListOf<Student>()
        val sql = "SELECT * FROM student"
        val connection = DBConfig.connection
        val statement = connection?.createStatement()
        val resultSet = statement?.executeQuery(sql)

        if (resultSet != null) {
            while (resultSet.next()) {
                val id = resultSet.getInt(1)
                val name = resultSet.getString(2)
                val secondName = resultSet.getString(3)
                val fathersName = resultSet.getString(4)
                val phoneNumber = resultSet.getString(5)
                val telegram = resultSet.getString(6)
                val email = resultSet.getString(7)
                val github = resultSet.getString(8)

                students.add(Student(name, secondName, fathersName, phoneNumber, telegram, email, github))
            }
        }else{
            return mutableListOf<Student>()
        }
        return students
    }

    override fun write(fileName: String, students: MutableList<Student>) {
        clear()
        val connection = DBConfig.connection
        var counter = 0
        val statement = connection?.createStatement()
        val sql = "INSERT INTO student (id, name, secondName, fathersName, phoneNumber, telegram, email, github) VALUES "
        students.forEachIndexed { index, student ->
            val values = "(${counter++}, '${student.name}', '${student.secondName}', '${student.fathersName}', '${student.phoneNumber}', '${student.telegram}', '${student.email}', '${student.github}')"
            statement?.executeUpdate(sql + values)
        }
    }

    fun clear () {
        val connection = DBConfig.connection
        val statement = connection?.createStatement()
        val sql = "DELETE FROM student"
        statement?.executeUpdate(sql)
    }

}