package basics

import kotlin.random.Random
import kotlin.random.nextInt

val PI = 3.1415

fun main(args: Array<String>) {
    // var name: String? = null ?: "Michael"
    // println(name)

    // val strLength = name?.length
    // println(strLength)

    // START READLINE EXAMPLE
    /*
    println("Please enter your name.")
    var name = readLine()
    if (name.isNullOrBlank())
        name = "Michael"
    when(name) {
        "Michael" -> println("$name? Sick name bro!")
        "Evan" -> println("$name? That is literally the best name i have ever heard")
        else -> println("Do you even have a name bro?")
    }
    // END READLINE EXAMPLE
    */

    /*if(readLine().isNullOrBlank()) {
        yourName = "Michael"
    } else {
        yourName = readLine()
    }*/
    /*if(strLength <= 0) {
        println("You didnt enter anything")
    } else {
        println("Sick name brah")
    }*/
    //println(name)

    /*if(readLine().isNullOrEmpty()) {
        println("Name is null or empty")
    } else {
        println("Cool name brah")
    }*/
    /*name = readLine()

    println("Your name is $name")*/

    // START COLLECTION AND LOOP EXAMPLE
    val list: MutableList<Int> = mutableListOf()
    for(i in 1..100) {
        // Random.nextInt()
        val rand = Random.nextInt(0..100)
        list.add(rand)
        // println(rand)
    }
    println(list)
    var i = 0
    // println(list[i])

    do {
        println(list[i])
        i++
    } while (list[i] <= 10)
    // END COLLECTION AND LOOP EXAMPLE
}