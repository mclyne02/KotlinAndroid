package basics

import kotlin.system.measureTimeMillis

fun main() {
    // Note, appending the 'L' creates the long datatype
    val veryLongList = (1..999999L).toList()

    // Note, that in this example, you should call take as soon as possible
    val sum = veryLongList
        .filter { it > 50 }
        .map { it * 2 }
        .take(1000)
        .sum()

    println(sum)

    // Done using Lazy Sequences
    // When you add the asSequence all the subsequent calls are called on the sequence object and not on the list
    // this means that they will be evaluated lazy-ily (this means that only those function calls which are necassary are executed)
    // Note, for this example, that means that it will run the functions on only the first 1000 elements instead of all the elements
    // Note, sometimes making it a sequence can improve performance, sometimes it can add unnecessary overhead
    val sumSeq = veryLongList
        .asSequence()
        .filter { it > 50 }
        .map { it * 2 }
        .take(1000)
        .sum()

    println(sumSeq)

    // Creating an infinite sequence
    // Note, the lambda is moved outside the parenthesis since it is the last argument to the function generateSequence
    val seq = generateSequence(1) {it + 1}
    println(seq.take(10).toList())

    // Case study to compare the difference between collections and sequences
    var sumCaseStudy = 0L
    var lazySumCaseStudy = 0L

    val msNonLazy = measureTimeMillis {
        sumCaseStudy = veryLongList
                .filter { it > 50 }
                .map { it * 2 }
                .take(1000)
                .sum()
    }

    val msLazy = measureTimeMillis {
        lazySumCaseStudy = veryLongList
                .asSequence()
                .filter { it > 50 }
                .map { it * 2 }
                .take(1000)
                .sum()
    }

    println("Non Lazy: $msNonLazy ms, Result: $sumCaseStudy")
    println("Lazy: $msLazy ms, Result: $lazySumCaseStudy")
    // Note, this comparison shows that the lazy version was faster:
    // Non Lazy: 77 ms, Result: 1101000
    // Lazy: 4 ms, Result: 1101000
    // However, keep in mind we are still making the intentional mistake of using filter too late in the functional chaining

    // Lets run it again with a correct placement of take

    var sumCaseStudyFixed = 0L
    var lazySumCaseStudyFixed = 0L

    val msNonLazyFixed = measureTimeMillis {
        sumCaseStudyFixed = veryLongList
            .filter { it > 50 }
            .take(1000)
            .map { it * 2 }
            .sum()
    }

    val msLazyFixed = measureTimeMillis {
        lazySumCaseStudyFixed = veryLongList
            .asSequence()
            .filter { it > 50 }
            .take(1000)
            .map { it * 2 }
            .sum()
    }

    println("Non Lazy Fixed: $msNonLazyFixed ms, Result: $sumCaseStudyFixed")
    println("Lazy Fixed: $msLazyFixed ms, Result: $lazySumCaseStudyFixed")
    // Note that the time came down slightly
    // Non Lazy Fixed: 61 ms, Result: 1101000
    // Lazy Fixed: 4 ms, Result: 1101000
    // Note, the more elements you preform the operations on, the more likely the sequence is to be better, for example, if we change 1000 elements to 10,000 in our take function

    // Below is an example of doing the computations on more elements and doing more computations, and moving take back to a bad spot
    var sumCaseStudyLarge = 0L
    var lazySumCaseStudyLarge = 0L

    val msNonLazyLarge = measureTimeMillis {
        sumCaseStudyLarge = veryLongList
            .filter { it > 50 }
            .map { it * 2 }
            .map { it / 3 }
            .map { it + 17 }
            .take(10000)
            .sum()
    }

    val msLazyLarge = measureTimeMillis {
        lazySumCaseStudyLarge = veryLongList
            .asSequence()
            .filter { it > 50 }
            .map { it * 2 }
            .map { it / 3 }
            .map { it + 17 }
            .take(10000)
            .sum()
    }

    println("Non Lazy Large: $msNonLazyLarge ms, Result: $sumCaseStudyLarge")
    println("Lazy Large: $msLazyLarge ms, Result: $lazySumCaseStudyLarge")
}