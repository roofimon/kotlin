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
class TestCreateLeft {
    @Test fun testFirstPatternLeftShouldBeIntegerOperand() {
        assertTrue(createLeft(1, 1) is IntegerOperand)
    }
    @Test fun testSecondPatternLeftShouldBeStringOperand() {
        assertTrue(createLeft(2, 1) is StringOperand)
    }
}
class TestCreateRight {
    @Test fun testFirstPatternLeftShouldBeStringOperand() {
        assertTrue(createRight(1, 1) is StringOperand)
    }
    @Test fun testSecondPatternRightShouldBeIntegerOperand() {
        assertTrue(createRight(2, 2) is IntegerOperand)
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
