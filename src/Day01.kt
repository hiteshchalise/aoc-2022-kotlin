fun main() {
    fun part1(input: List<String>): Int {
        val caloriesList = input.map { if (it.isNotEmpty()) it.toInt() else 0 }
        val listOfTotalCalories = mutableListOf<Int>()
        caloriesList.reduce { acc: Int, calories: Int ->
            if (calories > 0) acc + calories
            else {
                listOfTotalCalories.add(acc)
                0
            }
        }
        return listOfTotalCalories.max()
    }

    fun part2(input: List<String>): Int {
        val caloriesList = input.map { if (it.isNotEmpty()) it.toInt() else 0 }
        val listOfTotalCalories = mutableListOf<Int>()
        caloriesList.reduce { acc: Int, calories: Int ->
            if (calories > 0) acc + calories
            else {
                listOfTotalCalories.add(acc)
                0
            }
        }
        return listOfTotalCalories.sortedDescending().subList(0, 3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
