fun main() {
    fun part1(input: List<String>): Int {
        val score = input.fold(0) { acc, round ->
            val (opponentMove, yourMove) = round.split(" ")
            val score: Int = when(opponentMove) {
                "A" -> {
                    when (yourMove) {
                        "X" -> 1 + 3
                        "Y" -> 2 + 6
                        else -> 3 + 0
                    }
                }
                "B" -> {
                    when (yourMove) {
                        "X" -> 1 + 0
                        "Y" -> 2 + 3
                        else -> 3 + 6
                    }
                }
                "C" -> {
                    when (yourMove) {
                        "X" -> 1 + 6
                        "Y" -> 2 + 0
                        else -> 3 + 3
                    }
                }
                else -> {
                    throw(Error("Illegal State Exception"))
                }
            }
            (acc + score)
        }
        return score
    }

    fun part2(input: List<String>): Int {
        val score = input.fold(0) { acc, round ->
            val (opponentMove, target) = round.split(" ")
            val score: Int = when(opponentMove) {
                "A" -> {
                    when (target) {
                        "X" -> 3 + 0
                        "Y" -> 1 + 3
                        else -> 2 + 6
                    }
                }
                "B" -> {
                    when (target) {
                        "X" -> 1 + 0
                        "Y" -> 2 + 3
                        else -> 3 + 6
                    }
                }
                "C" -> {
                    when (target) {
                        "X" -> 2 + 0
                        "Y" -> 3 + 3
                        else -> 1 + 6
                    }
                }
                else -> {
                    throw(Error("Illegal State Exception"))
                }
            }
            (acc + score)
        }
        return score
    }

//     test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
