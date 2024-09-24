package Core_and_Models

class Data_table {

    val dArray: Array<Array<Any>>

    constructor(rows: Int, columns: Int, data: Any){
        dArray = Array(rows) { Array(columns) { "" } }
        for (i in 0..<rows){
            for (j in 0..<columns){
                dArray[i][j] = data
            }
        }
    }

    constructor(number: Number){
        dArray = Array(1) { Array(1) { "" } }
        dArray[0][0] = number
    }

    constructor(numbers: Array<Number>){
        dArray = Array(numbers.size) { Array(1) { "" } }
        for (i in numbers.indices){
            dArray[i][0] = numbers[i]
        }
    }
    constructor(data: Array<Array<Any>>){
        dArray = data
    }

    constructor(data: String){
        val temp = data.split("\n")
        val rows = temp.size
        val columns = temp[0].split(",").size
        dArray = Array(rows) { Array(columns) { "" } }
        for (i in 0..<rows){
            val temp2 = temp[i].split(",")
            for (j in 0..<columns){
                dArray[i][j] = temp2[j]
            }
        }
    }

    fun get_by_row_col(row: Int, col: Int): Any {
        return dArray[row][col]
    }

}