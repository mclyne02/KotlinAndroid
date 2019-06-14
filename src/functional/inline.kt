package functional

// Inline functions, when you write a function as an inline function it will simply replace the call to the function with just the body of the function

// Note, by adding the second parameter as this function called "operation" we have made the modifyString function a higherorder function
// Note, the function is a function of String to Unit
// Unit means its just a void function that performs some kind of operation on a String
/*
fun modifyString(str: String, operation: (String) -> Unit): String {
    return str.toUpperCase()
}
*/

// Note, this function returns the type as String so that we can define the function properly
// Note, writing the function this way means that there will be an anonymous function created for every invocation of this function
/*
fun modifyString(str: String, operation: (String) -> String): String {
    // This says, return the operation on the given str
    return operation(str)
}
*/

// To write this as an inline function simply add inline to the front
// Note, this only makes sense when used with higher order functions
// Note, if you have multiple inlines that you dont want to be inline you can use the noinline property in front of the lambda
/*
inline fun modifyString(str: String, noinline operation: (String) -> String): String {
    // This says, return the operation on the given str
    return operation(str)
}
*/

inline fun modifyString(str: String, operation: (String) -> String): String {
    // This says, return the operation on the given str
    return operation(str)
}

fun main() {
    modifyString("Kotlin is amazing") { it.toUpperCase() }
}