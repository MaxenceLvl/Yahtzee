class Yahtzee {

    fun Calculate(roll: IntArray, combination: Combination? = null): Int {
        if (combination == Combination.SMALL_STRAIGHT) {
            return calculateSmallStraight(roll)
        } else if (combination == Combination.LARGE_STRAIGHT) {
            return calculateLargeStraight(roll)
        }
        return roll.reduce(Int::plus)
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