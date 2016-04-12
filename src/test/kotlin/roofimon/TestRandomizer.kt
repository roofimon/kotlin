package roofimon

import com.nhaarman.mockito_kotlin.atLeastOnce
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
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
    @Test fun testRandomPattern() {
        doReturn(2).`when`(stubRandom).nextInt()
        val randomizer = Randomizer(stubRandom)
        assertEquals(2, randomizer.randomPattern())
        verify(stubRandom, atLeastOnce()).setSeed(2)
    }
    @Test fun testRandomOperand() {
        doReturn(9).`when`(stubRandom).nextInt()
        val randomizer = Randomizer(stubRandom)
        assertEquals(9, randomizer.randomOperand())
        verify(stubRandom, atLeastOnce()).setSeed(9)
    }

    @Test fun testRandomOperator() {
        doReturn(1).`when`(stubRandom).nextInt()
        val randomizer = Randomizer(stubRandom)
        assertEquals(1, randomizer.randomOperator())
        verify(stubRandom, atLeastOnce()).setSeed(3)
    }
}
