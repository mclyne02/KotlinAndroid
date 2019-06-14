package oo

// An example of when you are inheriting the same kind of method from two different parents
// Another example is that you can override a val with a var, but not the other way around
abstract class Vehicle(open val brand: String = "") {
    open fun drive() {
        println("Driving")
    }
    abstract fun honk()
}

// In this instance, you are inheriting the drive function from both the vehicle abstract class and the Drivable interface
// Here you can say, override the val brand with the var brand here in the child class
// Note, you CANNOT! override if the parent class or interface is a var and you want to make it a val in the child class
class Sedan(override var brand: String = "BRAND") : Vehicle(), Drivable {
    override fun drive() {
        // Written like this, it is ambiguous, and we dont know which parent this super refers to
        // super.drive()

        // To fix this, you can parameterize the super like so:
        // This one will refer to the interface
        super<Drivable>.drive()
        // This one will refer to the abstract class
        // super<Vehicle>.drive()
    }

    // One note here about the honk method. Since the parent class is an abstract class, you must implement all the methods in the parent in this concrete child class
    // unless your child is an abstract class as well, in which case you don't have to implement the methods and can instead delegate them to another child class
    override fun honk() {
        println("Honking!")
    }
}

fun main() {
    val sedan = Sedan()
    sedan.drive()
    sedan.honk()
}

// Short summary about the rules
// 1. You can put the name of the parent class in brackets to define which parent to use
// 2. You can change a val to a var from the parent to the child class implementing it
// 3. You must implement all the abstract methods of your parent class if you are a concrete child class