package basics

fun main() {
    // Map and Flat Map

    // map
    val list = (1..100).toList()

    // Just like in javascript, it will apply whatever function you specify to the elements of the list
    val doubled = list.map { element -> element * 2 }

    // Gives the same result
    list.map { it * 2 }

    println(doubled)

    // Using other functions to perform operations on the list
    val average = list.average()
    val shifted = list.map { it - average }

    println(shifted)

    // flatMap
    // Similar to map, but its also going to flatten any nested collections
    val nestedList = listOf(
        (1..10).toList(),
        (11..20).toList(),
        (21..30).toList()
    )

    val notFlattened = nestedList.map { it.sortedDescending() }

    val flattened = nestedList.flatMap { it.sortedDescending() }

    // This will print out the lists as a list of three lists with the elements inside the list sorted in descending order
    println(notFlattened)
    // This will print out just one list with the lists in descending order. Note, it will order the nested lists first, then just place them in one list
    println(flattened)

    // Note, this can also be done by calling .flatten() on the map function
    val mapWithFlattenAdded = nestedList.map { it.sortedDescending() }.flatten()
    println(mapWithFlattenAdded)

}