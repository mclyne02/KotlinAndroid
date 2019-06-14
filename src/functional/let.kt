package functional

import java.io.File

fun main() {
    // Let() function

    // Example 1: Scoping
    // Example with variable created
    /*
    File("example.txt").bufferedReader().let { reader ->
        if(reader.ready()) {
            println(reader.readLine())
        }
    }
    */

    // Example with implicit it operator
    // Note, using this let makes the reader only available inside this let block
    File("example.txt").bufferedReader().let {
        if(it.ready()) {
            println(it.readLine())
        }
    }
    // Reader should not be visible

    // Example 2: Working with nullables
    val str: String? = "Kotlin for Android"
    // Doing it this way will underline the statement inside the if with an error
    // You can stop this by using the unSafe call operator: str!!.isNotEmpty()
    /*
    if(str?.isNotEmpty()) {
        str?.toLowerCase()
    }
    // unSafe operator
    if(str!!.isNotEmpty()) {
        str?.toLowerCase()
    }
    */
    // Or use let instead
    // This will only execute if str is not null, if the variable str is null the block will just be skipped entirely
    str?.let {
        // Note, you do not need the safe call operator '?' anymore either since you know it cant be null here
        if(str.isNotEmpty()) {
            str.toLowerCase()
        }
    }
}