package oo

// To see this smart cast change, lets make an extension function to the Bicycle class
fun Bicycle.replaceWheel() {
    println("Replacing Wheel")
}

fun Boat.startEngine(): Boolean {
    println("Starting Engine")
    return true
}

fun main() {
    val vehicle: Drivable = Bicycle()
    // At this point in the compilier, it will be of type Drivable, even though it is actually the more conrete Bicycle object

    vehicle.drive()

    // instanceof (java) <-> is (kotlin)
    if (vehicle is Bicycle) {
        // Note, if you where doing this in java, you would need to cast the object as the type you are checking for:
        // val b = (Bicycle) vehicle
        // But in kotlin, you dont need to do this
        vehicle.replaceWheel()
        // Note, this green highlight of the object denotes that the object has been smart cast
    } else if (vehicle is Boat) {
        // In this case, the vehicle has been smart cast to be a Boat
        vehicle.startEngine()
    }

    // Note, here you can see that the vehicle in the second condition is already smart cast
    // This is because just like in Java, the second condition will only be evaluated if the first condition is true
    if (vehicle is Boat && vehicle.startEngine()) {
        // do something
    }

    // You can see here that again, the vehicle is smart cast already
    if (vehicle !is Boat || vehicle.startEngine()) {
        // do something
    }

    if (vehicle !is Bicycle) {
        return
    }
    // The reason this replaceWheel can be called here, and the fact that vehicle is smart cast to bicycle is because...
    // if the vehicle had been of type bicycle, it would have return in the if right above this line
    vehicle.replaceWheel()
}