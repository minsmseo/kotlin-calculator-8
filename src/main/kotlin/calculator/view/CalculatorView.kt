package calculator.view

class CalculatorView {
    fun getInput(): String{
        println("덧셈할 문자열을 입력해 주세요.")
        return readLine() ?:""
    }
    fun showResult(result: Int){
        println("결과 : $result")
    }
}