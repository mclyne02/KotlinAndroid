package oo

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
// import something from a companion object
import oo.House.Companion.getNormalHouse as createHouse

// import top level variable
import basics.PI

// This is like creating a singelton object, or an object of which there can be only one instance of
// Note: this class does not have a constructor since a constructor would only be needed when you want to make many different instances of a class
object CountryFactory {
    val a = 4
    fun createCountry() = Country("Australia")
}

// You can inherent as well
object DefaultClickListener : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent?) {
        println("Mouse was clicked")
    }
}

fun main() {
    // You dont create an instance of the class since there is no constructor, but you can access the members of the class directly
    // This acts similar to static methods and variables in Java
    CountryFactory.a
    CountryFactory.createCountry()
    createHouse()
    println(PI)
}