package com.faheemsaleem.calculatercompose

sealed class CalculatorAction {
    data class Number(val number: Int) : CalculatorAction()
    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    object Decimal: CalculatorAction()
    object Calulate: CalculatorAction()
    object Power: CalculatorAction()
    data class Operation(val operation: CalculatorOperation) : CalculatorAction()
}
