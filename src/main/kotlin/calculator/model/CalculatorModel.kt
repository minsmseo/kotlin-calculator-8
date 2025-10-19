package calculator.model

class CalculatorModel {
    fun calculate(nums: List<Int>): Int {
        var res = 0
        for (num in nums) {
            res += num
        }
        return res
    }
}