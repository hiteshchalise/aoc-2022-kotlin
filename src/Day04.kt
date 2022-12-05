fun main() {
    fun part1(input: List<String>): Int {
        val fullyOverlappingRangeList = input.filter { line ->
            val (first, second) = line.split(",")
            val firstRange = first.split('-').map { it.toInt() }
            val secondRange = second.split('-').map { it.toInt() }
            // Checking if secondRange is fully overlapped by firstRange
            if (firstRange.first() <= secondRange.first()
                && firstRange.last() >= secondRange.last()
            ) true
            // Checking if firstRange is fully overlapped by secondRange
            else firstRange.first() >= secondRange.first()
                    && firstRange.last() <= secondRange.last()
        }
        return fullyOverlappingRangeList.size
    }

    fun part2(input: List<String>): Int {
        val partialOverlappingRangeList = input.filter { line ->
            val (first, second) = line.split(",")
            val firstRange = first.split('-').map { it.toInt() }
            val secondRange = second.split('-').map { it.toInt() }
            if (firstRange.first() <= secondRange.first()
                && firstRange.last() >= secondRange.first()
            ) true
            else firstRange.first() >= secondRange.first()
                    && firstRange.first() <= secondRange.last()
        }
        return partialOverlappingRangeList.size
    }

//     test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))

}
