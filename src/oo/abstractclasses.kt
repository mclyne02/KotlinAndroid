package oo

// We want to make the shape class abstract so that no one can make an instance of it, and can only make an instance of the child classes that implement or inherit from this class
// Note that abstract classes are implicitly open as well as abstract methods
abstract class Shape(val name: String) {
    // This is already an improvement because we dont have to supply some default value since the method is abstract
    abstract fun area(): Double
}

class Circle(name: String, val radius: Double) : Shape(name) {
    override fun area() = Math.PI * Math.pow(radius, 2.0)
}

fun main() {
    // Note, cannot do this because Shape is an abstract class
    // val shape = Shape("My Shape")

    val shape = Circle("Large Circle", 17.0)
    println(shape.area())
}