package controller

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.TableView
import javafx.scene.control.TextArea

class MainController {

    // Объявление элементов управления из FXML
    @FXML
    private lateinit var comboBox1: ComboBox<String>

    @FXML
    private lateinit var textArea1: TextArea

    @FXML
    private lateinit var comboBox2: ComboBox<String>

    @FXML
    private lateinit var textArea2: TextArea

    @FXML
    private lateinit var comboBox3: ComboBox<String>

    @FXML
    private lateinit var textArea3: TextArea

    @FXML
    private lateinit var tableView: TableView<Any> // Замените Any на ваш тип данных

    @FXML
    private lateinit var addButton: Button

    @FXML
    private lateinit var updateButton: Button

    @FXML
    private lateinit var deleteButton: Button

    @FXML
    private lateinit var changeButton: Button

    // Метод для инициализации контроллера после загрузки FXML
    @FXML
    fun initialize() {
        // Инициализация комбобоксов или других элементов, если необходимо

        addButton.setOnAction { handleAdd() }
        updateButton.setOnAction { handleUpdate() }
        deleteButton.setOnAction { handleDelete() }
        changeButton.setOnAction { handleChange() }
    }

    // Обработчики событий для кнопок CRUD
    private fun handleAdd() {
        // Логика добавления элемента в таблицу или другую логику
        println("Add button clicked")
        // Пример добавления элемента в таблицу:
        // tableView.items.add(NewItem(...))
    }

    private fun handleUpdate() {
        // Логика обновления выбранного элемента в таблице
        println("Update button clicked")
        // Пример обновления элемента:
        // val selectedItem = tableView.selectionModel.selectedItem
        // if (selectedItem != null) { ... }
    }

    private fun handleDelete() {
        // Логика удаления выбранного элемента из таблицы
        println("Delete button clicked")
        val selectedItem = tableView.selectionModel.selectedItem
        if (selectedItem != null) {
            tableView.items.remove(selectedItem)
        }
    }

    private fun handleChange() {
        // Логика изменения выбранного элемента в таблице
        println("Change button clicked")
        // Пример изменения элемента:
        // val selectedItem = tableView.selectionModel.selectedItem
        // if (selectedItem != null) { ... }
    }
}
