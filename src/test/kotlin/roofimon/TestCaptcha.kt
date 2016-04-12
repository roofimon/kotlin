package roofimon
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestIntegerOperand {
    @Test fun testIntegerShouldBe1() {
        val integerOperand = IntegerOperand(1)
        assertEquals("1", integerOperand.string())
    }
    @Test fun testIntegerShouldBe9() {
        val integerOperand = IntegerOperand(9)
        assertEquals("9", integerOperand.string())
    }
}

class TestStringOperand {
    @Test fun testStringShouldBeONE() {
        val stringOperand = StringOperand(1)
        assertEquals("ONE", stringOperand.string())
    }
    @Test fun testStringShouldBeNINE() {
        val stringOperand = StringOperand(9)
        assertEquals("NINE", stringOperand.string())
    }
}
class TestCreateOperand {
    @Test fun testFirstPatternLeftShouldBeIntegerOperand() {
        assertTrue(createOperand(1, 1, Position.LEFT) is IntegerOperand)
    }
    @Test fun testSecondPatternLeftShouldBeStringOperand() {
        assertTrue(createOperand(2, 1, Position.LEFT) is StringOperand)
    }

    @Test fun testFirstPatternLeftShouldBeStringOperand() {
        assertTrue(createOperand(1, 1, Position.RIGHT) is StringOperand)
    }
    @Test fun testSecondPatternRightShouldBeIntegerOperand() {
        assertTrue(createOperand(2, 2, Position.RIGHT) is IntegerOperand)
    }
}

class TestCaptchaToString {
    @Test fun firstPatternStringShouldBe1PlusONE() {
        val captcha = Captcha(1, 1, 1, 1)
        assertEquals("1 + ONE", captcha.toString())
    }
    @Test fun secondPatternStringShouldBeONEPlus1() {
        val captcha = Captcha(2, 1, 1, 1)
        assertEquals("ONE + 1", captcha.toString())
    }
    @Test fun firstPatternStringShouldBe9MultiplyFOUR() {
        val captcha = Captcha(1, 9, 2, 4)
        assertEquals("9 * FOUR", captcha.toString())
    }
    @Test fun secondPatternStringShouldBENineMinus1() {
        val captcha = Captcha(2, 9, 3, 1)
        assertEquals("NINE - 1", captcha.toString())
    }
}
