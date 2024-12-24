import Core_and_Models.Student.Student
import tornadofx.*

class AddItemDialog : Fragment("Add Item") {
    private val viewModel = StudentViewModel()

    override val root = form {
        fieldset("Item Details") {
            field("Name") {
                textfield(viewModel.name).required()
            }
            field("Surname") {
                textfield(viewModel.surname).required()
            }
            field("Father's Name") {
                textfield(viewModel.fathersName).required()
            }
            field("Phone Number") {
                textfield(viewModel.phoneNumber).required()
            }
            field("Telegram") {
                textfield(viewModel.telegram).required()
            }
            field("Email") {
                textfield(viewModel.email).required()
            }
            field("GitHub") {
                textfield(viewModel.github).required()
            }
        }
        hbox {
            button("Cancel") {
                action {
                    close()
                }
            }
            button("Add") {
                enableWhen(viewModel.valid)
                action {
                    viewModel.commit {
                        val newItem = Student().apply {
                            name = viewModel.name.value
                            secondName = viewModel.surname.value
                            fathersName = viewModel.fathersName.value
                            phoneNumber = viewModel.phoneNumber.value
                            telegram = viewModel.telegram.value
                            email = viewModel.email.value
                            github = viewModel.github.value
                        }
                        // Add newItem to the list
                        close()
                    }
                }
            }
        }
    }
}