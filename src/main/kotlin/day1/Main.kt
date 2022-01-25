package day1

import java.io.File


fun main(args: Array<String>) {
    val numbers = readFile()
    val triple =numbers.findTripleOfSum()
    println(triple?.let { (x, y, z) -> x * y * z} )
}
fun List<Int>.findPairOfSum(sum: Int): Pair<Int, Int>? {
    // Map: sum - x -> x
    val complements = associateBy { sum - it }
    return firstNotNullOfOrNull { number ->
        val complement = complements[number]
        if (complement != null) Pair(number, complement) else null
    }
}

fun List<Int>.findTripleOfSum(): Triple<Int, Int, Int>? =
    firstNotNullOfOrNull { x ->
        findPairOfSum(2020 - x)?.let { pair ->
            Triple(x, pair.first, pair.second)
        }
    }

fun readFile() :List<Int>{
    val numbers = mutableListOf<Int>()
    File("src/main/resources/day1/input.txt").forEachLine {

        numbers.add( Integer.parseInt(it)) }
    return numbers
}