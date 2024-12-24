package Core_and_Models.Student

import controller.StudentController
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage
import kotlin.reflect.KMutableProperty1

class StudentView(stage: Stage, private val controller: StudentController, private val viewModel: StudentViewModel) {

    private val itemsPerPage = 10

    init {


        val root = VBox()
        val tableView = TableView(controller.students)
        tableView.columns.addAll(
            createColumn("Name", Student::name),
            createColumn("Surname", Student::secondName),
            createColumn("Father's Name", Student::fathersName),
            createColumn("Phone Number", Student::phoneNumber),
            createColumn("Telegram", Student::telegram),
            createColumn("Email", Student::email),
            createColumn("GitHub", Student::github)
        )


        val generalTextField = TextField()
        generalTextField.onAction = EventHandler { e: ActionEvent? ->
            val filter = generalTextField.text
            tableView.items = controller.filtered_students
        }

        val comboBoxOptions = FXCollections.observableArrayList("Да", "Нет", "-")

        val comboBox1 = ComboBox(comboBoxOptions)
        val textField1 = createLabeledField("Phone",TextField())
        val comboBox2 = ComboBox(comboBoxOptions)
        val textField2 = createLabeledField("Telegram",TextField())
        val comboBox3 = ComboBox(comboBoxOptions)
        val textField3 = createLabeledField("Email",TextField())
        val comboBox4 = ComboBox(comboBoxOptions)
        val textField4 = createLabeledField("GitHub",TextField())

        val comboBoxTextField1 = HBox(comboBox1, textField1)
        comboBoxTextField1.spacing = 10.0
        val comboBoxTextField2 = HBox(comboBox2, textField2)
        comboBoxTextField2.spacing = 10.0
        val comboBoxTextField3 = HBox(comboBox3, textField3)
        comboBoxTextField3.spacing = 10.0
        val comboBoxTextField4 = HBox(comboBox4, textField4)
        comboBoxTextField4.spacing = 10.0

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

        val addButton = Button("Add")
        addButton.onAction = EventHandler { e: ActionEvent? ->
            AddStudentView(controller, viewModel).show()
        }

        val loadButton = Button("Load")
        loadButton.onAction = EventHandler { e: ActionEvent? ->
            controller.load()
        }

        val updateButton = Button("Update")
        updateButton.onAction = EventHandler { e: ActionEvent? ->
            val selectedStudent = tableView.selectionModel.selectedItem
            if (selectedStudent != null) {
                UpdateStudentView(controller, viewModel, selectedStudent).show()
                //controller.updateStudent(selectedStudent, newStudent)
            }
        }

        val deleteButton = Button("Delete")
        deleteButton.onAction = EventHandler { e: ActionEvent? ->
            val selectedStudent = tableView.selectionModel.selectedItem
            if (selectedStudent != null) {
                controller.deleteStudent(selectedStudent)
            }
        }

        val buttonBox = HBox(addButton, loadButton, updateButton, deleteButton)
        buttonBox.spacing = 10.0

        root.children.addAll(
            createLabeledField("Name",generalTextField),
            comboBoxTextField1,
            comboBoxTextField2,
            comboBoxTextField3,
            comboBoxTextField4,
            tableView,
            buttonBox
        )

        stage.scene = Scene(root, 1000.0, 800.0)
        stage.show()
    }

    private fun createLabeledField(labelText: String, textField: TextField): HBox {
        val label = Label(labelText)
        val hbox = HBox(label, textField)
        hbox.spacing = 10.0
        return hbox
    }

    private fun createColumn(title: String, mapper: KMutableProperty1<Student, String?>): TableColumn<Student, String> {
        val column = TableColumn<Student, String>(title)
        column.setCellValueFactory { cellData: TableColumn.CellDataFeatures<Student, String> ->
            SimpleStringProperty(mapper(cellData.value))
        }
        return column
    }
}