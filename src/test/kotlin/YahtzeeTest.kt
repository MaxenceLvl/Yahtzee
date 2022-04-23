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
        val actual = Yahtzee().Calculate(intArrayOf(1, 2, 3, 5, 6), 0)
        assertEquals(expected, actual)
    }


}