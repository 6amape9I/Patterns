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

class AddStudentView(private val controller: StudentController, private val viewModel: StudentViewModel) {
    fun show() {
        val stage = Stage()
        val root = VBox()

        val nameField = TextField()
        nameField.textProperty().bindBidirectional(viewModel.nameProperty())
        val surnameField = TextField()
        surnameField.textProperty().bindBidirectional(viewModel.surnameProperty())
        val fathersNameField = TextField()
        fathersNameField.textProperty().bindBidirectional(viewModel.fathersNameProperty())
        val phoneNumberField = TextField()
        phoneNumberField.textProperty().bindBidirectional(viewModel.phoneNumberProperty())
        val telegramField = TextField()
        telegramField.textProperty().bindBidirectional(viewModel.telegramProperty())
        val emailField = TextField()
        emailField.textProperty().bindBidirectional(viewModel.emailProperty())
        val githubField = TextField()
        githubField.textProperty().bindBidirectional(viewModel.githubProperty())

        val saveButton = Button("Save")
        saveButton.onAction = EventHandler { e: ActionEvent? ->
            val student = viewModel.student
            controller.addStudent(student)
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