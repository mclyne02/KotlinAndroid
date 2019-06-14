package oo
// Properties
// Note, unlike Java, you only have properties and not fields
class City {
    // How do you override the getter and setters that kotlin makes automatically?
    // In Kotlin, every property has a 'backing' field which you can directly access with getters and setters
    var name: String = ""
        get() = field
        set(value) {
            if (value.isNotBlank()) {
                field = value
            }
        }
    var population: Int = 0
}

fun main() {
    val berlin = City()
    // Note, that when we are accessing the property of the class with the dot notation, kotlin is implicitly calling the getter and setter for the property
    berlin.name = "Berlin"
    // When we add the if check in the setter, and pass this blank string, we can see that it does not update the field since the value being passed ic blank
    berlin.name = "  "
    berlin.population = 3_500_000

    println(berlin.name)
    println(berlin.population)
}