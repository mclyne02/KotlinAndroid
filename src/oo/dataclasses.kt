package oo

// Normal Class
// class Address(val street: String, val number: Int, val postCode: String, val city: String)

// Data Class
// simply add the 'data' in front of the class
// Generates hashCode(). equals(), toString(), copy(), destructuring operator
data class Address(val street: String, val number: Int, val postCode: String, val city: String) {
    // Note, you can add methods or anything else in here
    // fun myMethod()
    // But in many cases you want to have a data class just to store some properties together or make a more readable return type
}

fun main() {
    val residence = Address("Main Street", 42, "1234", "New York")
    val residence2 = Address("Main Street", 42, "1234", "New York")

    println(residence)

    // Note, three equal signs '===' check for referential equality
    // === in kotlin is the == in java
    println(residence === residence2)
    // Note, two equal signs '==' check for structural equality
    // == in kotlin is the = in java, equals()
    println(residence == residence2)

    // copy()
    // without and parameters, it will make a copy where all the attributes are the same
    val neighbor = residence.copy()

    // Note, you can provide any properties you want to make this one more unique
    val neighborCustom = residence.copy(number = 43)

    println(neighbor)
    println(neighborCustom)

    // Destructuring operator
    // street
    residence.component1()
    println(residence.component1())
    // number
    residence.component2()
    // postcode
    residence.component3()
    //city
    residence.component4()

    // Normal way to use these components
    val (street, number, postCode, city) = residence
    println("$street $number, $postCode $city")

    // Note, if you are not interested in say the postCode, just use an underscore '_' in stead
    // val (street, number, _, city) = residence

}