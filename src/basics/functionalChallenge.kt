package basics

fun main() {
    val data = mapOf(
        "users1.csv" to listOf(32, 45, 17, -1, 34),
        "users2.csv" to listOf(19, -1, 67, 22),
        "users3.csv" to listOf(),
        "users4.csv" to listOf(56, 32, 18, 44)
    )

    println(data)

    // val users1 = data.getValue("users1.csv")

    // println(users1)

    // CODING CHALLENGE PART 1 - AVERAGE AGE
    val ages = listOf(
        data.getValue("users1.csv")
            .filter { age -> age > 0 },
        data.getValue("users2.csv")
            .filter { age -> age > 0 },
        data.getValue("users3.csv")
            .filter { age -> age > 0 },
        data.getValue("users4.csv")
            .filter { age -> age > 0 }
    )
    println(ages)

    val agesFlat = ages.flatten()
    println(agesFlat)

    val averageAge = agesFlat.average()
    println(averageAge)

    // CODING CHALLENGE PART 2 - EXTRACT NAMES THAT CONTAIN FAULT DATA
    println(data.getValue("users1.csv"))

    // data.forEach { t, u -> println("$t = $u") }
    data.forEach { t, u -> println("$t") }

    val filteredKeys = data.filterKeys { it.contains('1') }
    println("Filtered Keys: $filteredKeys")

    val agesArray = data.getValue("users1.csv")
    println(agesArray)
    println(agesArray.all { it < 0 })

    /*val filteredMap = data.forEach {
            t, u -> u.all { it > 0 }
    }*/

    // println(filteredMap)

    val filteredValues = data.filterValues { it.any { item -> item < 0 } || it.isEmpty() }
    println(filteredValues)
    val faultyData = filteredValues.keys
    println(faultyData)

    // CODING CHALLENGE PART 3 - COUNT THE TOTAL NUMBER OF FAULTY ENTRIES ACROSS ALL INPUT FILES
    val faultyEntriesFlattened = data.values.flatten()
    println("Faulty Entries Flattened $faultyEntriesFlattened")
    val faultyEntries = data.values.flatten().filter { it < 0 }.count()
    println("Faulty Entries $faultyEntries")
}