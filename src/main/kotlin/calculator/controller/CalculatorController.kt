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
        val nums = mutableListOf<Int>()
        val (numbers, delimiters) = extractDelimetersAndNumbers(input)
        val tokens = numbers.split(*delimiters.toTypedArray())
            .map { it.trim() }
            .filter { it.isNotEmpty() }
        for(tok in tokens){
            nums.add(tok.toInt())
        }

        return nums
    }

    private fun extractDelimetersAndNumbers(input: String): Pair<String, List<String>> {
        val delims = listOf(",", ":")
        if (!input.startsWith("//")) {
            return input to delims
        }
        // ^//: 문자열 시작이 //, (.+?): 구분자 그룹 , (?:\\n|\\r|\R) : \\n 인식 , (.*) : 개행 이후 모든 문자열
        val pat = Regex(
            """^//(.+?)(?:\\n|\\r|\R)(.*)\z""",
            RegexOption.DOT_MATCHES_ALL
        )
        val m = pat.matchEntire(input)
            ?: throw IllegalArgumentException("잘못된 커스텀 구분자 양식입니다.")
        //m.groupValues[0] = 전체 정규식
        //m.groupValues[1] = 캡쳐 그룹 중 첫번째 부분 <- (.+?)
        //m.groupValues[2] = 캡쳐 그룹 중 두번째 부분 <- (.*)
        val custom = m.groupValues[1]
        val numbers = m.groupValues[2]

        if (custom.length != 1) {
            throw IllegalArgumentException("잘못된 입력값입니다.") // 구분자는 한 글자만 허용
        }
        return numbers to (delims + custom)
    }
}