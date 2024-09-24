package Core_and_Models

abstract class Data_list {
    var dList: MutableList<Any> = mutableListOf()

    init {
        dList = mutableListOf()
    }
    constructor(data: List<Any>){
        dList = data.toMutableList()
    }

    constructor(data: String){
        dList = data.split(",").toMutableList()
    }

    fun select(number: Int){
        dList[number]
    }

    fun get_selsected(selected: MutableList<Any>): MutableList<Int> {
        val ids = mutableListOf<Int>()
        for (i in selected){
            ids.add(dList.indexOf(i))
        }
        return ids
    }

    abstract fun get_names(): List<String>
    abstract fun get_data(): Data_table
}