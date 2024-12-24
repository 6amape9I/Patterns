package main

import Core_and_Models.Student.StudentView
import Core_and_Models.Student.StudentViewModel
import controller.StudentController
import javafx.application.Application
import javafx.stage.Stage

class MainApp : Application() {
    override fun start(primaryStage: Stage) {
        val controller = StudentController()
        val viewModel = StudentViewModel()
        StudentView(primaryStage, controller, viewModel)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(MainApp::class.java, *args)
        }
    }
}