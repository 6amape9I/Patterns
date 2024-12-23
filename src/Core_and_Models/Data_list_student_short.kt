package Core_and_Models

class Data_list_student_short : Data_list {
    constructor(data: List<Any>) : super(data)
    constructor(data: String) : super(data)

    companion object{
        var id = 0
        fun AutoIncrementId(): Int {
            id = id + 1
            return id
        }
    }

    fun get_names(): List<String> {
        val names = mutableListOf<String>()
        names.add("name")
        names.add("contact")
        names.add("github")
        return names
    }

    fun get_data(): Data_table {
        var s = ""
        val names = get_names()
        s += "N"
        for (name in names){
            s += "|$name"
        }
        s+= "\n"
        this.dList.forEach(){
            stu: Any -> s += stu.toString() +"\n"
        }
        val ans = Data_table(s)
        return ans
    }

}