package roofimon

import com.nhaarman.mockito_kotlin.*
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

/**
 * Created by roofimon on 4/7/2016 AD.
 */
class Randomizer(val random: Random) {
    fun randomOperator(): Int {
        random.setSeed(3)
        return random.nextInt()
    }

    fun randomOperand(): Int {
        random.setSeed(9)
        return random.nextInt()
    }

    fun randomPattern(): Int {
        random.setSeed(2)
        return random.nextInt()
    }
}
class TestRandomizer {
    val stubRandom: Random = mock()
    var randomizer:Randomizer? = null

    fun initial(expectedValue:Int) {
        doReturn(expectedValue).`when`(stubRandom).nextInt()
        randomizer = Randomizer(stubRandom)
    }

    @Test fun testRandomPattern() {
        this.initial(2)
        assertEquals(2, randomizer?.randomPattern())
        verify(stubRandom, atMost(1)).setSeed(2)
    }
    @Test fun testRandomOperand() {
        this.initial(9)
        assertEquals(9, randomizer?.randomOperand())
        verify(stubRandom, atMost(1)).setSeed(9)
    }

    @Test fun testRandomOperator() {
        this.initial(1)
        assertEquals(1, randomizer?.randomOperator())
        verify(stubRandom, atMost(1)).setSeed(3)
    }
}
