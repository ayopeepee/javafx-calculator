package com.example.lab4

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField

// After saving .fxml file in SceneBuilder
// attribute {xmlns:fx} must be changed: http://javafx.com/fxml/1 -> http://javafx.com/fxml
// attribute {xmlns} must be deleted
// attribute {id} in any control element must be changed: id -> fx:id
// If you catch {lateinit property exception} check next:
// you use @FXML to initialize property in Controller
// your variable name in Controller is the same as {fx:id} in .fmxl file


class CalculatorController : Display {

    @FXML
    private lateinit var inputField: TextField

    private val calculator: Calculator


    init {
        calculator = Calculator(this)
    }

    @FXML
    private fun onButtonDigitClick(event: ActionEvent) {
        val button = event.source as Button
        val digit = button.text
        calculator.digit(digit)
    }
    @FXML
    fun onButtonOperatorClick(actionEvent: ActionEvent) {
        val button = actionEvent.source as Button
        val operator = button.text
        calculator.operator(operator)
    }

    fun onButtonEnterClick(actionEvent: ActionEvent) {
        calculator.enter()
    }

    override var diplayField: String
        get() = inputField.text
        set(displayField) {
            inputField.text = displayField
        }

    @FXML
    private fun onButtonClearClick(actionEvent: ActionEvent){
        calculator.clear()
    }

    @FXML
    private fun onButtonCommaClick(actionEvent: ActionEvent) {
        calculator.comma()
    }

    @FXML
    private fun onButtonClearEnteredClick(actionEvent: ActionEvent) {
        calculator.clearEntered()
    }



    @FXML
    private fun onButtonNegateClick(actionEvent: ActionEvent) {
        calculator.negate()
    }
}