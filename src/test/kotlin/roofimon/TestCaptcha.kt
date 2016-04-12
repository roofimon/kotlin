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

class TestSomething {
    @Test fun testOperatorPlus() {
        val captcha = Captcha(1, 1, 1, 1)
        assertEquals("+", captcha.operator.string())
    }
    @Test fun secondPatternLeftShouldBeONE() {
        val captcha = Captcha(2, 1, 1, 1)
        assertEquals("ONE", captcha.left.string())
    }
    @Test fun firstPatternLeftShouldBe1() {
        val captcha = Captcha(1, 1, 1, 1)
        assertEquals("1", captcha.left.string())
    }
    @Test fun firstPatternLeftShouldBe2() {
        val captcha = Captcha(1, 9, 1, 1)
        assertEquals("9", captcha.left.string())
    }
    @Test fun firstPatternRightShouldBeONE() {
        val captcha = Captcha(1, 1, 1, 1)
        assertEquals("ONE", captcha.right.string())
    }
    @Test fun firstPatternRightShouldBeNINE() {
        val captcha = Captcha(1, 1, 1, 9)
        assertEquals("NINE", captcha.right.string())
    }
}
