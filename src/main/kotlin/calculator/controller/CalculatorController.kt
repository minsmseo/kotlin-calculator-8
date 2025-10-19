package calculator.controller

import calculator.model.CalculatorModel
import calculator.view.CalculatorView

class CalculatorController(
    private val view: CalculatorView,
    private val model: CalculatorModel
) {
    fun run(){
        val input = view.getInput()
        val numbers= parseNumbers(input)
        val result=model.calculate(numbers)
        view.showResult(result)
    }
    private fun parseNumbers(input: String): List<Int> {
        if (input.isBlank()) {
            return emptyList()
        }
        return input.split(',', ':')
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
    }
}