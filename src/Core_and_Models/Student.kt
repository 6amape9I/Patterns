package Core_and_Models

import java.io.File
import kotlin.reflect.KFunction1


open class Student(
    var id: Int? = AutoIncrementId(),
    var name: String,
    var secondName: String? = null,
    var fathersName: String? = null,
    var phoneNumber: String? = null,
    var telegram: String? = null,
    var email: String? = null,
    var github: String? = null
){

    fun nameSetter(name: String){
        validateName(name)
        this.name = name
    }
    fun secondNameSetter(secondName: String){
        validateSecondName(secondName)
        this.secondName = secondName
    }
    fun fathersNameSetter(fathersName: String){
        validateFathersName(fathersName)
        this.fathersName = fathersName
    }
    fun phoneNumberSetter(phoneNumber: String?){
        validatePhoneNumber(phoneNumber)
        this.phoneNumber = phoneNumber
    }
    fun telegramSetter(telegram: String?){
        validateTelegram(telegram)
        this.telegram = telegram
    }
    fun emailSetter(email: String?){
        validateEmail(email)
        this.email = email
    }
    fun githubSetter(github: String?){
        validateGithub(github)
        this.github = github
    }

    fun getInfo(): String {
        var temp_str = "Student('$name' '${secondName?.get(0)}' '${fathersName?.get(0)}'"
        if (github != null) temp_str += "-github:$github"
        if (phoneNumber != null) temp_str += "-phone:$phoneNumber"
        else if (telegram != null) temp_str += "-telegarm:$telegram"
        else if (email != null) temp_str += "-email:$email"
        return temp_str
    }

    private fun <T>validatorFunc(value:T, errorMessage:String, valudatorFunction: KFunction1<T, Boolean>){
        require(valudatorFunction(value)) { errorMessage }
    }

    private fun validateName(name: String) = validatorFunc(name, "Name must contain only letters", ::isValidName)
    private fun validateSecondName(secondName: String?) = validatorFunc(secondName, "Second name must contain only letters", ::isValidSecondName)
    private fun validateFathersName(fathersName: String?) = validatorFunc(fathersName, "Fathers name must contain only letters", ::isValidFathersName)
    private fun validatePhoneNumber(phoneNumber: String?) = validatorFunc(phoneNumber, "Phone number must contain only letters", ::isValidPhoneNumber)
    private fun validateTelegram(telegram: String?) = validatorFunc(telegram, "Telegram must contain only letters", ::isValidTelegram)
    private fun validateEmail(email: String?) = validatorFunc(email, "Email must contain only letters", ::isValidEmail)
    private fun validateGithub(github: String?) = validatorFunc(github, "Github must contain only letters", ::isValidGithub)

    init {
        validateName(this.name)
        validateSecondName(this.secondName)
        validateFathersName(this.fathersName)
        validatePhoneNumber(this.phoneNumber)
        validateTelegram(this.telegram)
        validateEmail(this.email)
        validateGithub(this.github)
    }

    companion object{
        var id = 0
        fun AutoIncrementId(): Int {
            id = id + 1
            return id
        }

        fun read_from_JSON(file_name: String): MutableList<Student> {
            val students = mutableListOf<Student>()
            val json = File(file_name).readText()
            val regex = Regex("\\{\\s*\"id\":\\s*(\\d+),\\s*\"name\":\\s*\"(\\w+)\",\\s*\"secondName\":\\s*\"(\\w+)\",\\s*\"fathersName\":\\s*\"(\\w+)\",\\s*\"phoneNumber\":\\s*\"(\\+\\d{10,12})\",\\s*\"telegram\":\\s*\"(@\\w+)\",\\s*\"email\":\\s*\"(\\w+@\\w+\\.\\w+)\",\\s*\"github\":\\s*\"(\\w+)\"\\s*}")
            regex.findAll(json).forEach {
                val (id, name, secondName, fathersName, phoneNumber, telegram, email, github) = it.destructured
                students.add(Student(id.toInt(), name, secondName, fathersName, phoneNumber, telegram, email, github))
            }

            return students
        }

        fun write_to_JSON(file_name: String, students: MutableList<Student>) {
            val file = File(file_name)
            file.writeText("[\n")
            students.forEachIndexed { index, student ->
                val json = """
            {
            "id": ${student.id},
            "name": "${student.name}",
            "secondName": "${student.secondName}",
            "fathersName": "${student.fathersName}",
            "phoneNumber": "${student.phoneNumber}",
            "telegram": "${student.telegram}",
            "email": "${student.email}",
            "github": "${student.github}"}
        """.trimIndent()
                file.appendText(json)
                if (index < students.size - 1) {
                    file.appendText(",\n")
                }
            }
            file.appendText("\n]")
        }

        fun read_from_txt(file_name: String): MutableList<Student> {
            val students = mutableListOf<Student>()
            val lines = File(file_name).readLines()
            for (line in lines) {
                println(line)
                students.add(Student(line))
            }
            return students
        }
        fun write_to_txt(file_name: String, students: MutableList<Student>) {
            val file = File(file_name)
            file.writeText("")
            for (student in students) {
                file.appendText(student.toString() + "\n")
            }
        }
    }

    private fun isValidName(name: String): Boolean {
        return name.matches(Regex("^[a-zA-Z]+\$"))
    }
    private fun isValidSecondName(secondName: String?): Boolean {
        return secondName?.matches(Regex("^[a-zA-Z]+\$")) ?: true
    }

    private fun isValidFathersName(fathersName: String?): Boolean {
        return fathersName?.matches(Regex("^[a-zA-Z]+\$")) ?: true
    }

    private fun isValidPhoneNumber(phoneNumber: String?): Boolean {
        return phoneNumber?.matches(Regex("^\\+\\d{10,12}\$")) ?: true
    }

    private fun isValidTelegram(telegram: String?): Boolean {
        return telegram?.matches(Regex("^@\\w+\$")) ?: true
    }

    private fun isValidEmail(email: String?): Boolean {
        return email?.matches(Regex("^\\w+@\\w+\\.\\w+\$")) ?: true
    }

    private fun isValidGithub(github: String?): Boolean {
        return github?.matches(Regex("^\\w+\$")) ?: true
    }

    constructor():this(
        id = AutoIncrementId(),
        name = "John",
        secondName = "Doe",
        fathersName = "Doe",
        phoneNumber = "+1234567890",
        telegram = "@johndoe",
        email = "odvodkv@wrff.erf",
        github = "johndoe"
    )

    constructor(stuMap: HashMap<String, Any?>):this(
        id = AutoIncrementId(),
        name = stuMap["name"] as String,
        secondName = stuMap["secondName"] as String,
        fathersName = stuMap["fathersName"] as String,
        phoneNumber = stuMap.getOrDefault("phoneNumber", null) as String?,
        telegram = stuMap.getOrDefault("telegram", null) as String?,
        email = stuMap.getOrDefault("email", null) as String?,
        github = stuMap.getOrDefault("github", null) as String?
    )



    constructor(stringStu: String):this(
        id = AutoIncrementId(),
        name = stringStu.split(",")[0],
        secondName = stringStu.split(",")[1],
        fathersName = stringStu.split(",")[2],
        phoneNumber = stringStu.split(",")[3],
        telegram = stringStu.split(",")[4],
        email = stringStu.split(",")[5],
        github = stringStu.split(",")[6]
    )

    override fun toString(): String {
        return "$name,$secondName,$fathersName,$phoneNumber,$telegram,$email,$github"
    }

}