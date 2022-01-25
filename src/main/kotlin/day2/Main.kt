package day2

import java.io.File


fun main(args: Array<String>) {
    val data = readFile()
    println(data)

    partOne(data)
    partTwo(data)


}

fun partOne(data: List<PasswordValidity>) {
    val validPasswords = data.count {
        it.password.count { s -> s == it.requiredLetter }.let { numberOfRequiredLetters ->
            numberOfRequiredLetters >= it.minNumber && numberOfRequiredLetters <= it.maxNumber
        }
    }
    println(validPasswords)
}

fun partTwo(data: List<PasswordValidity>) {
    println(data.count {
        val firstIsValid = it.password[it.minNumber - 1] == it.requiredLetter
        val secondIsValid = it.password[it.maxNumber - 1] == it.requiredLetter
        if (firstIsValid) {
            !secondIsValid
        } else {
            secondIsValid
        }
    })
}

fun readFile(): List<PasswordValidity> {
    val data = mutableListOf<PasswordValidity>()
    File("src/main/resources/day2/input.txt").forEachLine {

        val minNumber = it.split(":", " ", "-")

        data.add(
            PasswordValidity(
                Integer.parseInt(minNumber[0]),
                Integer.parseInt(minNumber[1]),
                minNumber[2].first(),
                minNumber[4]
            )
        )
    }
    return data
}

data class PasswordValidity(
    val minNumber: Int,
    val maxNumber: Int,
    val requiredLetter: Char,
    val password: String,
)