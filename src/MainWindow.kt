

import Core_and_Models.Student.Student
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.control.Alert
import tornadofx.*

class MyApp : App(MainView::class)


class MainView : View("Simple CRUD App") {
    private val items = mutableListOf<Student>().observable()
    private var selectedObject = SimpleObjectProperty<Student?>()

    override val root = vbox {
        // Область фильтрации
        hbox {
            textfield {
                promptText = "Search..."
                // Добавьте логику фильтрации здесь
            }
            button("Filter") {
                action {
                    // Логика фильтрации
                }
            }
        }

        // Область вывода таблицы
        tableview(items) {
            column("ID", Student::id)
            column("Name", Student::name)
            column("Surname", Student::secondName)
            column("FathersName", Student::fathersName)
            column("PhoneNumber", Student::phoneNumber)
            column("Email", Student::email)
            column("Telegram", Student::telegram)
            column("Github", Student::github)

            // Обработка выбора элемента
            selectionModel.selectedItemProperty().addListener { _, _, newValue ->
                selectedObject.set(newValue)
            }
        }

        // Область кнопок CRUD
        hbox {
            button("Add") {
                action {
                    val dialog = find<AddItemDialog>()
                    dialog.openModal(block = true)
                }
            }
            button("Update") {
                action {
                    selectedObject.get()?.let {
                        handleUpdate(it)
                    }
                }
            }

            button("Change") {
                action {
                    selectedObject.get()?.let {
                        handleChange(it)
                    } ?: showError("Error", "No item selected")
                }
            }
            button("Delete") {
                action {
                    selectedObject.get()?.let {
                        handleDelete(it)
                    } ?: showError("Error", "No item selected")
                }
            }
        }
    }

    private fun handleAdd(newItem: Student) {
        items.add(newItem)
    }

    private fun handleUpdate(student: Student) {
        // Логика обновления выбранного элемента в таблице
        println("Update button clicked")
        // Пример обновления элемента:
        // val selectedItem = tableView.selectionModel.selectedItem
        // if (selectedItem != null) { ... }
    }

    private fun handleChange(student: Student) {
        // Логика изменения выбранного элемента в таблице
        println("Change button clicked")
        // Пример изменения элемента:
        // val selectedItem = tableView.selectionModel.selectedItem
        // if (selectedItem != null) { ... }
    }

    private fun handleDelete(student: Student) {
        items.remove(student)
    }

    private fun showError(title: String, message: String) {
        val alert = Alert(Alert.AlertType.ERROR)
        alert.title = title
        alert.headerText = null
        alert.contentText = message
        alert.showAndWait()
    }
}

fun main() {
    launch<MyApp>()
}