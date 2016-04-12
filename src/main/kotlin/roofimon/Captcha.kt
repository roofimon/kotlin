package roofimon

/**
 * Created by roofimon on 4/7/2016 AD.
 */

class Captcha(_pattern: Int, _left: Int, _operator: Int, _right: Int) {
    val left:Operand = createLeft(_pattern, _left)
    val right:Operand = createRight(_pattern, _right)
    val operator:Operator = Operator(_operator)
}

fun createLeft(pattern: Int, value: Int): Operand {
    when(pattern) {
        1 -> return IntegerOperand(value)
        else -> return StringOperand(value)
    }
}

fun createRight(pattern: Int, value: Int): Operand {
    if(pattern == 1)
        return StringOperand(value)
    return IntegerOperand(value)
}

abstract class Operand(_value: Int) {
    val value = _value
    abstract fun string(): String
}

class StringOperand(_value: Int): Operand(_value) {
    override fun string(): String {
        val mapping = arrayListOf("ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE")
        return mapping[value-1]
    }
}

class IntegerOperand(_value: Int): Operand(_value) {
    override fun string(): String {
        return value.toString()
    }
}

class Operator(val valueIs: Int) {
    fun string(): String {
        when (valueIs) {
            1 -> return "+"
            2 -> return "*"
            else -> return "-"
        }
    }
}

