package basics

import java.io.IOException

fun main() {
    // In Kotlin, the try catch block is an expression so you can assign a val or var to it
    val input = try {
        getExternalInput()
    } catch (e: IOException) {
        e.printStackTrace()
        ""
    } finally {
        println("Finished trying to read external input")
    }

    println(input)
}

fun getExternalInput(): String {
    throw IOException("Could not run external input")
}