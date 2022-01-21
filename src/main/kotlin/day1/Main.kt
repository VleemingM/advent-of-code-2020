package day1

import java.io.File


fun main(args: Array<String>) {
    val numbers = readFile()
    numbers.forEach { firstNumber ->
        numbers.forEach { secondNumber ->
            if (firstNumber + secondNumber == 2020){
                println(firstNumber * secondNumber)
            }
        }
    }

}

fun readFile() :List<Int>{
    val numbers = mutableListOf<Int>()
    File("src/main/resources/day1/input.txt").forEachLine {

        numbers.add( Integer.parseInt(it)) }
    return numbers
}