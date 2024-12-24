package Core_and_Models.Student

import javafx.beans.property.SimpleStringProperty
import tornadofx.ViewModel

class StudentViewModel : ViewModel() {
    val name = SimpleStringProperty()
    val surname = SimpleStringProperty()
    val fathersName = SimpleStringProperty()
    val phoneNumber = SimpleStringProperty()
    val telegram = SimpleStringProperty()
    val email = SimpleStringProperty()
    val github = SimpleStringProperty()

    var student: Student
        get() = Student(
            name.get(),
            surname.get(),
            fathersName.get(),
            phoneNumber.get(),
            telegram.get(),
            email.get(),
            github.get()
        )
        set(student) {
            name.set(student.name)
            surname.set(student.secondName)
            fathersName.set(student.fathersName)
            phoneNumber.set(student.phoneNumber)
            telegram.set(student.telegram)
            email.set(student.email)
            github.set(student.github)
        }

    fun nameProperty(): SimpleStringProperty {
        return name
    }

    fun surnameProperty(): SimpleStringProperty {
        return surname
    }

    fun fathersNameProperty(): SimpleStringProperty {
        return fathersName
    }

    fun phoneNumberProperty(): SimpleStringProperty {
        return phoneNumber
    }

    fun telegramProperty(): SimpleStringProperty {
        return telegram
    }

    fun emailProperty(): SimpleStringProperty {
        return email
    }

    fun githubProperty(): SimpleStringProperty {
        return github
    }

}