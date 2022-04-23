import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class YahtzeeTest {

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun `test score of roll with 1, 2, 3, 5, 6 should return 17`() {
        val expected = 17
        val actual = Yahtzee().calculate(intArrayOf(1, 2, 3, 5, 6), Combination.CHANCE)
        assertEquals(expected, actual)
    }

    @Test
    fun `test score of roll with 1, 2, 3, 4, 6 should return 30`() {
        val expected = 30
        val actual = Yahtzee().calculate(intArrayOf(1, 2, 3, 4, 6), Combination.SMALL_STRAIGHT)
        assertEquals(expected, actual)
    }

    @Test
    fun `test score of roll with 2, 3, 4, 5, 5  should return 30`() {
        val expected = 30
        val actual = Yahtzee().calculate(intArrayOf(2, 3, 4, 5, 5), Combination.SMALL_STRAIGHT)
        assertEquals(expected, actual)
    }

    @Test
    fun `test score of roll with 1, 2, 3, 4, 2 should return 0`() {
        val expected = 30
        val actual = Yahtzee().calculate(intArrayOf(1, 2, 3, 4, 2), Combination.SMALL_STRAIGHT)
        assertEquals(expected, actual)
    }

    @Test
    fun `test score of roll with 1, 2, 3, 4, 5 should return 40`() {
        val expected = 40
        val actual = Yahtzee().calculate(intArrayOf(1, 2, 3, 4, 5), Combination.LARGE_STRAIGHT)
        assertEquals(expected, actual)
    }

    @Test
    fun `test score of roll with 1, 2, 3, 4, 5 should return 1`() {
        val expected = 1
        val actual = Yahtzee().calculate(intArrayOf(1, 2, 3, 4, 5), Combination.ONES)
        assertEquals(expected, actual)
    }

    @Test
    fun `test score of roll with 2, 2, 3, 4, 5 should return 0`() {
        val expected = 0
        val actual = Yahtzee().calculate(intArrayOf(2, 2, 3, 4, 5), Combination.ONES)
        assertEquals(expected, actual)
    }

    @Test
    fun `test score of roll with 1, 1, 3, 1, 5 should return 3`() {
        val expected = 0
        val actual = Yahtzee().calculate(intArrayOf(2, 2, 3, 4, 5), Combination.ONES)
        assertEquals(expected, actual)
    }
}