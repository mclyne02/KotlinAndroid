package basics

fun main() {

    val list = (1..1000).toList()

    // take = will take the first n elements of a list and only return those
    // drop = is going to drop the first n elements of a collection and only return the rest of the collection

    val first10 = list.take(10)
    val withoutFirst900 = list.drop(900)

    // println(first10)
    // println(withoutFirst900)

    // This list is actually an infinite list, which is only possible because we are only going to calculate the elements needed
    val listSeq = generateSequence(0) { it + 10 }

    val first10Seq = listSeq.take(10)
    val first20Seq = listSeq.take(20)

    println(first10Seq)
    println(first20Seq)

    // The print out for sequences does not have a good toString, so you need to add to it
    val first10SeqToList = listSeq.take(10).toList()
    val first20SeqToList = listSeq.take(20).toList()

    println(first10SeqToList)
    println(first20SeqToList)

    // You can change the Lambda to print out some other pieces too
    val listSeqModified = generateSequence(0) {
        println("Calculating ${it+10}")
        it + 10
    }

    val first10SeqModifiedToList = listSeqModified.take(10).toList()
    val first20SeqModifiedToList = listSeqModified.take(20).toList()

    println(first10SeqModifiedToList)
    println(first20SeqModifiedToList)

    // Note, there are also functions called first and last if you only want those elements
    val firstLastList = (1..10).toList()

    val firstValue = firstLastList.first()
    val lastValue = firstLastList.last()

    println(firstValue)
    println(lastValue)

}