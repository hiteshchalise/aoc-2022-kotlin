fun main() {
    fun part1(input: List<String>): String {
        val splitIndex = input.indexOfFirst { it.isEmpty() }
        val stackInput = input.subList(0, splitIndex - 1)
        val instructionInput = input.subList(splitIndex + 1, input.size)

        val sanitizedStackInput = stackInput.map { line -> line.windowed(3, 4) }
        val stacksOfCrate = List<ArrayDeque<Char>>(sanitizedStackInput.maxOf { it.size }) { ArrayDeque() }
        for (line in sanitizedStackInput) {
            line.forEachIndexed { index, crate ->
                if (crate.isNotBlank()) stacksOfCrate[index].add(crate[1])
            }
        }

        instructionInput.forEach { line ->
            val (amount, from, to) = line.split(" ").filter { it.toIntOrNull() != null }.map { it.toInt() }
            for(index in 0 until amount) {
                stacksOfCrate[to - 1].addFirst(stacksOfCrate[from - 1].removeFirst())
            }
        }

        return stacksOfCrate.map { it.first() }.joinToString("")
    }

    fun part2(input: List<String>): String {
        val splitIndex = input.indexOfFirst { it.isEmpty() }
        val stackInput = input.subList(0, splitIndex - 1)
        val instructionInput = input.subList(splitIndex + 1, input.size)

        val sanitizedStackInput = stackInput.map { line -> line.windowed(3, 4) }
        val stacksOfCrate = List<ArrayDeque<Char>>(sanitizedStackInput.maxOf { it.size }) { ArrayDeque() }
        for (line in sanitizedStackInput) {
            line.forEachIndexed { index, crate ->
                if (crate.isNotBlank()) stacksOfCrate[index].add(crate[1])
            }
        }

        instructionInput.forEach { line ->
            val (amount, from, to) = line.split(" ").filter { it.toIntOrNull() != null }.map { it.toInt() }
            val removedItem = mutableListOf<Char>()
            for(index in 0 until amount) {
                removedItem.add(stacksOfCrate[from - 1].removeFirst())
            }
            stacksOfCrate[to - 1].addAll(0, removedItem)
        }

        return stacksOfCrate.map { it.first() }.joinToString("")
    }

//     test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))

}
