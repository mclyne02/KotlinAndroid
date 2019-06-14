package basics

fun main() {
    val list = listOf("Hi", "there", "Kotlin", "fans")
    val containsT = listOf(false, true, true, false)

    // zip function will take two collections and put them together in a zipper like fashion
    // going to create pairs:
    // Pair<String, Boolean>
    // Below all the values are being explicitly defined, but of course Kotlin can infer these
    var zipped: List<Pair<String, Boolean>> = list.zip(containsT)

    println(zipped)

    // Note, this is useful to combine different data sets that actually belong together and zip them into pairs

    val mapping = list.zip(list.map { it.contains("t") })

    println(mapping)
}