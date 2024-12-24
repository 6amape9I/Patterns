import Core_and_Models.Student.Student
import javafx.beans.property.SimpleStringProperty
import tornadofx.ItemViewModel

class StudentViewModel : ItemViewModel<Student>() {
    val name = bind {SimpleStringProperty(item.name)}
    val surname = bind {SimpleStringProperty(item.secondName)}
    val fathersName = bind {SimpleStringProperty(item.fathersName)}
    val phoneNumber = bind {SimpleStringProperty(item.phoneNumber)}
    val telegram = bind {SimpleStringProperty(item.telegram)}
    val email = bind {SimpleStringProperty(item.email)}
    val github = bind {SimpleStringProperty(item.github)}
}