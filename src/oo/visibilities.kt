package oo

// Visibilities allow you to restrict access to a class or methods or properties
// This concept is known as information hiding, which is all about restricting access to class internals to whats outside
// This means only giving access to the internals that you want exposed

// private - same as in Java (inside the class, all properties or methods (class members)  will only be visible inside the class)
// protected - same as in Java (only visible to the class and the sub classes)
// internal - does not exist in Java (this one means it is visible inside the same module)
// Note: the term module here refers to a set of kotlin files compiled together
// Also, if you are only using on module in your project, then internal is the same as public
// The default visibility is public
// public - same as in Java

// Example of top level properties with these visibility values
private val i = 42

// public fun a() = 17
// Note, here the public keyword is gray since it is the default and it is redundant
fun a() = 17

// Example
open class Car(val brand: String, private val model: String) {
    // Note, without anyhting in front, it is just public, but if you add say internal, it will be only visible in the module, but since we are only using one module, it is the same as public for us here
    internal fun tellMeYourModel() = model

    // making a function protected
    protected fun tellMeYouModelProtected() = model
}

// Protected example of a child class inheriting a method from a parent
class SpecificCar(): Car("", "") {
    fun someFunction() {
        tellMeYouModelProtected()
    }
}

fun main() {
    val someCar = Car("BRAND", "MODEL")
    someCar.brand
    // Note here that you cannot access model because it is private
    // someCar.model
    // Now that we added the function tellMeYouModel, you can get the model
    someCar.tellMeYourModel()
    println(i)
}