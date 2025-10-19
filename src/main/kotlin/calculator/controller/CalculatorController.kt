package calculator.controller

import calculator.model.CalculatorModel
import calculator.view.CalculatorView

class CalculatorController(
    private val view: CalculatorView,
    private val model: CalculatorModel
) {
    fun run(){
        val input = view.getInput()
        val result=model.calculate(input)
        view.showResult(result)
    }
}