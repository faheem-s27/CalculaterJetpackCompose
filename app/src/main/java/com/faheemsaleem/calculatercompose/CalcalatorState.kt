package com.faheemsaleem.calculatercompose

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null,
    val result: String = "",
    val lastOperation: CalculatorOperation? = null,
    val lastNumber: String = ""
)
