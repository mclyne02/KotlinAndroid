package functional

import java.io.FileReader

fun main() {
    // use()
    // use is the equivalent of javas try-with-resources
    // helps with common programming mistake of something like forgetting to close a database connection, socket or a file

    // Note, use is available for all types that implement the Closeable interface
    // To see the types, type Ctrl+N in intelliJ | then you can use Ctrl+H to show the hierarchy
    // this will show you all the classes that implement the interface you are searching for
    // Note, the Closeable interface has a close() function that you can call
    FileReader("mayexist.txt").use {
        val str = it.readText()
        println(str)
        // use() will call this line at the end of the block in case you forget to call it
        // it.close()
    }
}