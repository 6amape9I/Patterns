package Core_and_Models

class Data_list_student_short : Data_list {
    constructor(data: List<Any>) : super(data)
    constructor(data: String) : super(data)

    override fun get_names(): List<String> {
        val names = mutableListOf<String>()
        names.add("name")
        names.add("contact")
        names.add("github")
        return names
    }

    override fun get_data(): Data_table {
        var s = ""
        this.dList.forEach(){
            stu: Any -> s += stu.toString() +"\n"
        }
        val ans = Data_table(s)
        return ans
    }
}