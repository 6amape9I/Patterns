package Core_and_Models.Student

import controller.StudentController
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage

class UpdateStudentView(private val controller: StudentController, private val viewModel: StudentViewModel, private val student: Student) {
    fun show() {
        val stage = Stage()
        val root = VBox()

        val nameField = TextField(student.name)
        viewModel.nameProperty().bindBidirectional(nameField.textProperty())
        val surnameField = TextField(student.secondName)
        viewModel.surnameProperty().bindBidirectional(surnameField.textProperty())
        val fathersNameField = TextField(student.fathersName)
        viewModel.fathersNameProperty().bindBidirectional(fathersNameField.textProperty())
        val phoneNumberField = TextField(student.phoneNumber)
        viewModel.phoneNumberProperty().bindBidirectional(phoneNumberField.textProperty())
        val telegramField = TextField(student.telegram)
        viewModel.telegramProperty().bindBidirectional(telegramField.textProperty())
        val emailField = TextField(student.email)
        viewModel.emailProperty().bindBidirectional(emailField.textProperty())
        val githubField = TextField(student.github)
        viewModel.githubProperty().bindBidirectional(githubField.textProperty())

        val saveButton = Button("Save")
        saveButton.onAction = EventHandler { e: ActionEvent? ->
            val student = viewModel.student
            controller.updateStudent(this.student, student)
            stage.close()
        }

        fun createLabeledField(labelText: String, textField: TextField): HBox {
            val label = Label(labelText)
            val hbox = HBox(label, textField)
            hbox.spacing = 10.0
            return hbox
        }

        root.children.addAll(
            createLabeledField("Name", nameField),
            createLabeledField("Surname", surnameField),
            createLabeledField("Father's Name", fathersNameField),
            createLabeledField("Phone Number", phoneNumberField),
            createLabeledField("Telegram", telegramField),
            createLabeledField("Email", emailField),
            createLabeledField("GitHub", githubField),
            saveButton
        )

        stage.scene = Scene(root, 400.0, 400.0)
        stage.show()
    }
}