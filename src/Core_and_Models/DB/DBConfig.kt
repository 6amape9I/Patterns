package Core_and_Models.DB

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet


class DBConfig {

    var connection: Connection? = connectToDatabase()

    init {
        if (connection == null) {
            println("Не удалось подключиться к базе данных")
        }
    }

    private fun connectToDatabase(): Connection? {
        if (connection != null) {
            return connection
        }
        val url = "jdbc:postgresql://localhost:5432/StudentsDB" // Замените на ваш URL базы данных
        val user = "postgres" // Замените на ваше имя пользователя
        val password = "Tima2706" // Замените на ваш пароль

        return try {
            DriverManager.getConnection(url, user, password)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun executeQuery(connection: Connection) {
        val sql = "SELECT * FROM student" // Замените на ваше имя таблицы
        val statement = connection.createStatement()
        val resultSet: ResultSet = statement.executeQuery(sql)

        while (resultSet.next()) {
            println(resultSet) // Измените индекс или имя столбца по необходимости
        }

        statement.close()
    }

    fun close() {
        try {
            connection?.close()
        } catch (e: Exception) {
            println(e.message)
        }
    }



}