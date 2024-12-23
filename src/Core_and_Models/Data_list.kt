package Core_and_Models

open class Data_list {
    var dList: MutableList<Any> = mutableListOf()
    private var selected: MutableList<Any> = mutableListOf()

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
        selected.add(dList[number])
    }

    fun get_selsected(): MutableList<Int> {
        val ids = mutableListOf<Int>()
        for (i in selected){
            ids.add(dList.indexOf(i))
        }
        return ids
    }

}