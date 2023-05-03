package com.example.lab4

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 400.0, 600.0)
        stage.title = "Calculator!"
        stage.scene = scene
        stage.isResizable = false
        stage.show()
        //TODO("древнерусские величины (длина 4-5 штук) базовые мат операции перевод в десятичную. отдельным интерейсов. можно доп задание на торнадо переписать")
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}