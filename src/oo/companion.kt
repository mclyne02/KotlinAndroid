package oo

interface HouseFactory {
    fun createHouse(): House
}

class House(val numberOfRooms: Int, val price: Double) {
    // Companion classes are like using the static keyword in Java
    // Note, the signature has the default name "Companion" but you can rename it to whatever you want
    // companion object Companion { }

    // Example with the companion object given a specific name, in this cae "Factory" but the name can be whatever you want
    /*
    companion object Factory {
        // Note, the parameters to the object, in this case, numberOfRooms, and price are not available in the companion object
        // val HOUSES_FOR_SALE = numberOfRooms

        // Defining it this way makes this a constant in this companion object
        val HOUSES_FOR_SALE = 10

        // These are the equivalent of static methods in Java
        fun getNormalHouse() = House(6, 199_999.0)
        fun getLuxuryHouse() = House(42, 7_000_000.0)
    }*/

    // Companion classes can also inherit, so you can have something like this
    // Note, the "HouseFactory" is an interface you define
    // Example
    companion object : HouseFactory {
        val HOUSES_FOR_SALE = 10

        fun getNormalHouse() = House(6, 199_999.0)
        fun getLuxuryHouse() = House(42, 7_000_000.0)
        override fun createHouse() = getNormalHouse()
    }
}

fun main() {
    // The way to use this is to call it as such
    House.HOUSES_FOR_SALE
    House.getNormalHouse()
    House.getLuxuryHouse()

    // Important note, when you access this companion class, you don't need to create an instance of it
    // Yet you can still access the object, and it is important to remember that at this time there is no numberOfRooms and there is no price

    // Or you can also call the "companion" default name; however, this is redundant
    /*
    House.Companion.HOUSES_FOR_SALE
    House.Companion.getNormalHouse()
    House.Companion.getLuxuryHouse()
    */

    // However, if you do define a name for your companion object, you have to use it
    /*
    House.Factory.HOUSES_FOR_SALE
    House.Factory.getNormalHouse()
    House.Factory.getLuxuryHouse()
    */

    val normalHouse = House.getNormalHouse()
    println(normalHouse.numberOfRooms)
    println(normalHouse.price)

    // Note, you can also just access the companion object directly from the class
    println(House.HOUSES_FOR_SALE)
}