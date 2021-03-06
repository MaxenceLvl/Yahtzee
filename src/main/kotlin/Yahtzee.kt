class Yahtzee {

    fun calculate(roll: IntArray, combination: Combination): Int {
        return when (combination) {
            Combination.SMALL_STRAIGHT  -> calculateSmallStraight(roll)
            Combination.LARGE_STRAIGHT  -> calculateLargeStraight(roll)
            Combination.THREE_OF_A_KIND -> calculateXofAKind(roll, 3)
            Combination.FOUR_OF_A_KIND  -> calculateXofAKind(roll, 4)
            Combination.FULL_HOUSE      -> calculateFullHouse(roll)
            Combination.CHANCE          -> calculateChance(roll)
            Combination.YAHTZEE         -> calculateYahtzee(roll)
            else -> calculateCombination(roll, combination.value)
        }
    }

    private fun calculateFullHouse(roll: IntArray): Int {
        val counts = IntArray(6)
        for (i in 0..4) {
            counts[roll[i]]++
        }
        for (i in 0..5) {
            if (counts[i] == 3) {
                for (j in 0..5) {
                    if (counts[j] == 2) {
                        return 40
                    }
                }
            }
        }
        return 0
    }

    private fun calculateYahtzee(roll: IntArray): Int {
        return if (roll.all { it == roll[0] }) {
            50
        } else {
            0
        }
    }

    private fun calculateXofAKind(roll: IntArray, x: Int): Int {
        for (diceValue in 1..6) {
            if (roll.count { it == diceValue } >= x) {
                return roll.sum()
            }
        }
        return 0
    }

    private fun calculateChance(roll: IntArray): Int {
        return roll.reduce(Int::plus)
    }

    private fun calculateCombination(roll: IntArray, diceValue: Int): Int {
        return diceValue * roll.count { it == diceValue }
    }
    private fun calculateSmallStraight(roll: IntArray): Int {
        return if (roll.contains(1) && roll.contains(2) && roll.contains(3) && roll.contains(4)) {
            30
        } else if (roll.contains(2) && roll.contains(3) && roll.contains(4) && roll.contains(5)) {
            30
        } else if (roll.contains(3) && roll.contains(4) && roll.contains(5) && roll.contains(6)) {
            30
        } else {
            0
        }
    }

    private fun calculateLargeStraight(roll: IntArray): Int {
        return if (roll.contains(1) && roll.contains(2) && roll.contains(3) && roll.contains(4) && roll.contains(5)) {
            40
        } else if (roll.contains(2) && roll.contains(3) && roll.contains(4) && roll.contains(5) && roll.contains(6)) {
            40
        } else {
            0
        }
    }
}

enum class Combination(val value: Int) {
    ONES(1),
    TWOS(2),
    THREES(3),
    FOURS(4),
    FIVES(5),
    SIXES(6),
    THREE_OF_A_KIND(0),
    FOUR_OF_A_KIND(0),
    FULL_HOUSE(0),
    SMALL_STRAIGHT(0),
    LARGE_STRAIGHT(0),
    YAHTZEE(0),
    CHANCE(0)
}