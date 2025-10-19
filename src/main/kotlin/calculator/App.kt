package calculator

import calculator.model.CalculatorModel
import calculator.view.CalculatorView
import calculator.controller.CalculatorController

fun main() {
    // TODO: 프로그램 구현
    val controller = CalculatorController(CalculatorView(), CalculatorModel())
    controller.run()
}
