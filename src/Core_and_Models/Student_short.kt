package Core_and_Models

class Student_short: Student {

    var contact: String? = null

    constructor(
        name: String,
        phoneNumber: String? = null,
        github: String? = null,
        secondName: String? = null,
        fathersName: String? = null
    ): super(
        name=name + " " + (secondName?.get(0) ?: "" ) + " " + (fathersName?.get(0) ?: ""),
        github=github
    ){
        this.contact = phoneNumber ?: telegram ?: email
    }


    constructor(
        StuString: String
    ): super(StuString){
        val temp = StuString.split(",")
        this.contact = temp[3] ?: temp[4] ?: temp[5]
    }

}