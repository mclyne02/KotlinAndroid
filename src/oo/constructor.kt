package oo
// Note, you can define the properties in the constructor between the parenthesis
class Country(val name: String, val areaSqKm: Int) {
    // Java way
    /*
    val name: String
    val area: Int

    // How do we define what is going to happen in the constructor?
    // Use the init block
    // This block will be executed whenever a new class is created (when the constructor is called)
    init {
        // Do it the java way
        this.name = name
        this.area = areaSqKm
    }
    */

    // For Kotlin however, you can do something a little differemt and not use the init block for this:
    // You can use the constructor parameters directly in the property declaration
    /*
    val name: String = name
    val area: Int = areaSqKm
    */

    // Note, you can have multiple constructors just like in Java
    // you can define any number of secondary constructors by using the 'constructor' keyword
    // Note, you always have to delegate to the primary constructor if you have one
    constructor(name: String) : this(name, 0) {
        println("Constructor called")
    }

    // Note, you can take this one step further by adding these to the constructor
    // This will simply add the 'val' keyword to the constructor for the parameters
    // When you add the 'val' keyword, you are upgrading your constructor parameters to properties
    // Now you can access them inside your class
    fun print() = "$name, $areaSqKm km^2"
}

fun main() {
    val australia = Country("Australia", 7_700_000)
    // Note, since you are using val here instead or var you cannot do something like this:
    // australia.name = "New Zealand"

    println(australia.name)
    println(australia.areaSqKm)

    val myCountry = australia.print()
    println(myCountry)

    val spain = Country("Spain")
    println(spain.name)
    println(spain.areaSqKm)
}