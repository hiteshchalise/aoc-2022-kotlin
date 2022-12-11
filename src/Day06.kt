fun main() {
    fun part1(input: List<String>): Int {
        val windowSize = 4
        val signal = input[0]
        val windowsOfFourSignals = signal.windowed(windowSize, 1, false)

        val indexOfFirst = windowsOfFourSignals.indexOfFirst {
            val setOfCharacter = it.toCharArray().toSet()
            setOfCharacter.size == it.length
        }
        return indexOfFirst + windowSize
    }

    fun part2(input: List<String>): Int {
        val windowSize = 14
        val signal = input[0]
        val windowsOfFourSignals = signal.windowed(windowSize, 1, false)

        val indexOfFirst = windowsOfFourSignals.indexOfFirst {
            val setOfCharacter = it.toCharArray().toSet()
            setOfCharacter.size == it.length
        }
        return indexOfFirst + windowSize
    }

//     test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 10)
    check(part2(testInput) == 29)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))

}
