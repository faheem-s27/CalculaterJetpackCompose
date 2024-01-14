package com.faheemsaleem.calculatercompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction)
    {
        when(action)
        {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calulate -> performCalculation()
            is CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.Power -> performPower()
        }
    }

    private fun performPower() {
        if (state.number1.isNotBlank() && state.operation == null) {
            if (state.number1.toDouble() % 1 == 0.0) {
                state = state.copy(
                    number1 = power(state.number1.toInt()).toString(),
                    lastNumber = "", lastOperation = null
                )
            }
            else{
                state = state.copy(
                    number1 = power(state.number1.toDouble()).toString(),
                    lastNumber = "", lastOperation = null
                )
            }
        }
    }

    private fun power(number1: Double, number2: Double = number1): Double
    {
        return number1 * number2
    }

    private fun power(number1: Int, number2: Int = number1): Int
    {
        return number1 * number2
    }

    private fun performDeletion() {
        when{
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
        performCalculationForResult()
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        val lastNumber = state.lastNumber.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                null -> return
            }

            // check if result is an integer
            if (result % 1 == 0.0) {
                state = state.copy(
                    number1 = result.toInt().toString().take(15),
                    number2 = "",
                    operation = null,
                    result = result.toInt().toString(),
                    lastOperation = state.operation,
                    lastNumber = state.number2
                )
                return
            }

            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null,
                result = result.toString(),
                lastOperation = state.operation,
                lastNumber = state.number2
            )
        }
        else if (state.lastOperation != null && lastNumber != null && number1 != null)
        {
            val result = when (state.lastOperation) {
                is CalculatorOperation.Add -> number1 + lastNumber
                is CalculatorOperation.Subtract -> number1 - lastNumber
                is CalculatorOperation.Multiply -> number1 * lastNumber
                is CalculatorOperation.Divide -> number1 / lastNumber
                null -> return
            }

            // check if result is an integer
            if (result % 1 == 0.0) {
                state = state.copy(
                    number1 = result.toInt().toString().take(15),
                    number2 = "",
                    operation = null,
                    result = result.toInt().toString(),
                    lastOperation = state.lastOperation,
                    lastNumber = lastNumber.toString()
                )
                return
            }

            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null,
                result = result.toString(),
                lastOperation = state.lastOperation,
                lastNumber = lastNumber.toString()
            )
        }
    }

    private fun performCalculationForResult() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                null -> return
            }

            // check if result is an integer
            if (result % 1 == 0.0) {
                state = state.copy(
                    result = result.toInt().toString()
                )
                return
            }

            state = state.copy(
                result = result.toString()
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()){
            state = state.copy(operation = operation)
        }
        performCalculationForResult()
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".")
            && state.number1.isNotBlank()
        ) {
            state = state.copy(number1 = state.number1 + ".")
            return
        }

        if (!state.number2.contains(".")
            && state.number2.isNotBlank()
        ) {
            state = state.copy(number2 = state.number2 + ".")
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null)
        {
            if (state.number1.length >= MAX_NUM_LENGTH) return

            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }

        if (state.number2.length >= MAX_NUM_LENGTH) return


        state = state.copy(
            number2 = state.number2 + number,
        )

        performCalculationForResult()

    }

    companion object {
        private const val MAX_NUM_LENGTH = 10
    }
}
