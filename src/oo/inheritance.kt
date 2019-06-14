package oo

// Just create some parent class that you would like to make a child class from
// Note, remember that you do not need curly braces if the class has nothing inside it
// Minimum Example, just to see syntax
// Note, the 'open' keyword allows the class to be extended and inherited from
open class Base
// The Java way
// class Child extends Base

// In Kotlin, you use the ':' operator to act as extends and also implements, so there is no distinction
// Note, in Kotlin, types or classes are by default final, this means you cannot inherit from a class unless you specifically say so
// To make a class able to be inherited from you have to add the "open" keyword
// Note, in Java, all classes are open so you can inherit from them, whereas in Kotlin, all classes are closed so cannot inherit from them unless you specify it
// Note, you also have to supply the 'open' keyword for any methods inside your class that you want to be available
class Child : Base()

// Real world example
open class Shape1(val name: String) {
    open fun area() = 0.0
}

// Calling the Shape(name) is calling the parent classes constructor, it is equivalent to calling super in java
// This Circle consturctor is just taking in a name, and passing it to the parent class constructor to inherit the name property
class Circle1(name: String, val radius: Double) : Shape(name) {
    // Note, the override keyword is used in kotlin, and it is not an annotation like in java
    override fun area() = Math.PI * Math.pow(radius, 2.0)
}

fun main() {
    val smallCircle = Circle("Small Circle", 2.0)
    println(smallCircle.name)
    println(smallCircle.radius)
    println(smallCircle.area())
}

// Note, anytime you want to use the override keyword to override something in the child class, you will have to specify the parent classes variable/method/anything to be 'open'