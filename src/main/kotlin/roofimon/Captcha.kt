package roofimon

/**
 * Created by roofimon on 4/7/2016 AD.
 */

enum class Position { LEFT, RIGHT }

class Captcha(val _pattern: Int, val _left: Int, val _operator: Int, val _right: Int) {
    val left:Operand = createOperand(_pattern, _left, Position.LEFT)
    val right:Operand = createOperand(_pattern, _right, Position.RIGHT)
    val operator:Operator = Operator(_operator)

    override fun toString(): String {
        return "${left.string()} ${operator.string()} ${right.string()}"
    }
}

fun createOperand(pattern: Int, value: Int, position: Position): Operand {
    val integerPattern = if(position == Position.LEFT) 1 else 2
    when(pattern) {
        integerPattern -> return IntegerOperand(value)
        else -> return StringOperand(value)
    }
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

