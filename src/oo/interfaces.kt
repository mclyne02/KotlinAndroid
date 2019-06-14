package oo

// Note, all you really need for the interface is this one method
// Also, it is common to use the 'able' suffix when they define something you can do with the class
// Note, interfaces never have a constructor
// Note, you can have abstract properties however
// Note, all functions and elements in an interface are open since they have to be overwritten anyway
interface Drivable {
    // Below is an abstract value that all child classes will have to override
    // Note the lack of the abstract keyword, since it is redundant, you can omit it entirely
    // val a: Int

    // Note, similar to Java 8, you cant define default implementations; however, it is best to avoid this
    // Try to avoid default impl's in interfaces
    /*
    fun drive() {
        println("Driving something")
    }
    */
    fun drive() {
        println("Driving (from interface)")
    }
}

// Note, the interface does not have a constructor (unlike classes) so no need to add ()
class Bicycle : Drivable {
    // Note, you can override the getter or...
    /*
    override val a: Int
        get() = 42
    */
    // simply define the number
    // override val a = 42
    override fun drive() {
        println("Driving Bicycle")
    }
    fun a() = 1
}

class Boat : Drivable {
    // override val a = 53
    override fun drive() {
        println("Driving Boat")
    }
}

fun main() {
    // We can make a type here of type Drivable, but instantiate it as the type Bicycle
    // this can be done because since Bicycle implements the Drivable interface, you know it will have the methods from Drivable
    // At runtime, this object will be a Bicycle, but since it is of type Drivable, it could also be a Boat
    val drivable: Drivable = Bicycle()
    drivable.drive()

    // If you have methods in other child classes that are specific to those classes then you would need to define your type as those classes
    // for example, for accessing just the 'a()' method in the Bicycle class you would have to define your type as Bicycle not Drivable
    val drivable2: Bicycle = Bicycle()
    drivable2.a()

    // Note, it is best practice to use the most abstract interface that has the methods you need
}