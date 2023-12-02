fun main() {
    fun part1(input: List<String>): Int {
        return input.map { it.filter(Char::isDigit) }
            .map { (it.first().toString() + it.last().toString()).toInt() }
            .sum()
    }

    fun part2(input: List<String>): Int {
        val letters = listOf(
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
        )

        val numbers = listOf(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9"
        )

        val map = letters.zip(numbers).toMap() + numbers.zip(letters).toMap()
        val digits = List(input.size) { 0 }.toMutableList();
        for (idx in input.indices) {
            var first = input[idx].findAnyOf(map.keys)?.second
            var second = input[idx].findLastAnyOf(map.keys)?.second
            if (letters.contains(first)) {
                first = map[first]
            }
            if (letters.contains(second)) {
                second = map[second]
            }
            digits[idx] = (first.toString() + second.toString()).toInt()
        }

        return digits.sum()
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
