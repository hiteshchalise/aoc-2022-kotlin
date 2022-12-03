fun main() {
    fun part1(input: List<String>): Int {
        val priorityList = input.map { rucksack ->
            val firstCompartment = rucksack.subSequence(0, rucksack.length / 2)
            val secondCompartment = rucksack.subSequence(rucksack.length / 2, rucksack.length)
            val matchingItem = firstCompartment.first { item ->
                secondCompartment.contains(item)
            }
            priorityOfAlphabet(matchingItem)
        }
        return priorityList.sum()
    }

    fun part2(input: List<String>): Int {
        val badgeItemPriorityList = input.windowed(3, 3, false).map { (first, second, third) ->
            val matchingItem = first.filter { item ->
                second.contains(item)
            }
            val badgeItem = matchingItem.first { item ->
                third.contains(item)
            }
            priorityOfAlphabet(badgeItem)
        }
        return badgeItemPriorityList.sum()
    }

//     test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))

}
