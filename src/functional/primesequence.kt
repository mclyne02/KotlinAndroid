package functional

fun main() {
    val possiblePrimesAfter2 = generateSequence(3) {
        it + 2
    }
    val primes = generateSequence(2 to possiblePrimesAfter2) {
        // Next prime number
        val p = it.second.first()

        // Filter out all the elements that are divisible by p
        val possiblePrimesAfterP = it.second.filter { item -> item % p != 0 }

        // Return the next element in the sequence
        p to possiblePrimesAfterP
        // Note, this return values above is the same as having a Pair defined like below
        // Pair(p, possiblePrimesAfterP)
    }.map { it.first }

    println(primes.take(10).toList())
}