package oo

// With Extension functions, you can extend the api or the interface of any class without needing access to the source code
// You just need access to the binaries, and you can add a new function to any class you like
// This allows you to get rid of any utilities classes you may be familiar with from Java like:
// StringUtils, DataUtils
// and also collection classes, which are just utils too
// This allows us to create our own extension function on an existing class rather than make some utils class to hold the functions we need

// Example, lets say that we want to extend the Int class
// and add a new method called isEven()
// With the return type explicitly defined
// fun Int.isEmpty(): Boolean = (this % 2 == 0)

// Without the return type define
fun Int.isEven() = (this % 2 == 0)

// Lets Extend one of our own classes
fun City.isLarge() = (population > 1_000__000)

fun main() {
    println(5.isEven())

    val naturals = listOf(2, 5, 11, 3, 8, 2)
    println(naturals.filter { it.isEven() })

    val austin = City()
    austin.population = 950_000
    println(austin.isLarge())
}