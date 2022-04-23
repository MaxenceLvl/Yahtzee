class Yahtzee {

    fun Calculate(roll: IntArray, combination: Int): Int {
        return roll.reduce(Int::plus)
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