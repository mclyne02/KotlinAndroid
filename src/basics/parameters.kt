package basics

fun main() {
    // You dont have to specify the value of a parameter that has a default value:
    val togetherDefault = concat(listOf("Kotlin", "Java", "Scala"))

    // Or you can send it as usual
    val together = concat(listOf("Kotlin", "Java", "Scala"), " : ")

    // You can explicity name the value of the parameter you want to set in the function call
    val together2 = concat(listOf("Kotlin", "Java", "Scala"), separator = " + ")
    // or even change the order as long as you define the parameter name
    val together3 = concat(separator = " | ", texts = listOf("Kotlin", "Java", "Scala"))
    println(togetherDefault)
    println(together)
    println(together2)
    println(together3)
}

fun concat(texts: List<String>, separator: String = ", ") = texts.joinToString(separator)