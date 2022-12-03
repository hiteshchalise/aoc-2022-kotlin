import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt")
    .readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

fun priorityOfAlphabet(character: Char) = when (character.code) {
    in 97..122 -> character.code - 97 + 1
    in 65..90 -> character.code - 65 + 26 + 1
    else -> throw (Error("Illegal State"))
}