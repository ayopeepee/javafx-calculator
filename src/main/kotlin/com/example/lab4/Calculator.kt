package com.example.lab4

import java.lang.Exception
import java.math.BigDecimal
import kotlin.jvm.Throws

class Calculator(private val display: Display) {

    var number: BigDecimal
        get() { return BigDecimal(display.diplayField.replace(',','.')) }
        set(number) { display.diplayField = number.toString() }

    var isLastButtonWasDigit: Boolean = false
    var operator = "+"
    var value1 = BigDecimal.ZERO
    var value2 = BigDecimal.ZERO

    fun digit(digit: String) {
        if (isLastButtonWasDigit) {
            display.diplayField = display.diplayField + digit
        } else {
            display.diplayField = digit
        }
        isLastButtonWasDigit = true
    }

    fun clear() {
        number = BigDecimal.ZERO
        isLastButtonWasDigit = false
        operator = "+"
        value1 = BigDecimal.ZERO
        value2 = BigDecimal.ZERO
    }

    fun operator(operator: String) {
        if (isLastButtonWasDigit) {
            value2 = number
            calculate()
        }
        this.operator = operator
    }

    fun enter() {
        if (isLastButtonWasDigit) {
            value2 = number
        }
        calculate()
    }

    fun clearEntered() {
        number = BigDecimal.ZERO
    }

    fun comma() {
        if (!display.diplayField.contains(",")) {
            display.diplayField = display.diplayField + ","
        }
        isLastButtonWasDigit = true
    }

    fun negate() {
        number = number.negate()
    }

    fun percent() {
        number = BigDecimal((value1.toInt() * value2.toInt()) / 100)
        value1 = number
        isLastButtonWasDigit = false
    }

    fun mod() {
        number = value1.rem(value2)
        value1 = number
        isLastButtonWasDigit = false
    }

    private fun calculate(){
        when (operator) {
            "+" -> number = value1.add(value2)
            "-" -> number = value1.subtract(value2)
            "×" -> number = value1.multiply(value2)
            "÷" -> try { number =  value1.divide(value2) }
            catch (e: ArithmeticException) {
                display.diplayField = "division by zero"
                return
            }
            "MOD" -> number = value1.rem(value2)
            "%" -> number = value1.multiply(value2.divide(BigDecimal(100)))
            "√" -> try { number = BigDecimal(Math.pow(value1.toDouble(), 0.5)) }
            catch (e: NumberFormatException) {
                display.diplayField = "NaN"
                return
            }
            "^" -> try { number = BigDecimal(Math.pow(value1.toDouble(), value2.toDouble())) }
            catch (e: NumberFormatException) {
                display.diplayField = "inf"
                return
            }
            else -> throw IllegalStateException("unknown operator $operator")
        }
        value1 = number
        isLastButtonWasDigit = false
    }
}