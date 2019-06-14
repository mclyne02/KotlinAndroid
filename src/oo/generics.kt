package oo

import java.util.*

// Generic class allows you to write classes in a more generic way so that they can be used more often in different situations

// Here in this example, the List class is a generic type that then gets its definition of the types inside the list from whats inside the angle brackets
// So you can have List's of ints, doubles, strings, other objects, whatever
val list : List<Int> = listOf(1,2,3)

// Now, lets make a generic class by ourselves
// This class will store data that will also be tagged with a date
// Note: the 'E' is just a place holder for a generic type parameter. These can be something like 'E' for element of 'T' for type.
// Just remember that they define the type of elements that will be stored in the class
class TimeSeries<E> {
    val date2Data: MutableMap<Date, E> = mutableMapOf()

    fun add(element: E) {
        date2Data.put(Date(), element)
    }

    fun addAll(elements: Collection<E>) {
        elements.forEach {add(it)}
    }

    // This will return an element of type 'E'
    fun getLatest(): E {
        return date2Data.values.last()
    }
}

// Generic function example
// This function will work the same way as listOf and will allows us to make Timeline objects more easily
// Note, the type of elements that are sent in, the vararg in this case, can be of type Any, but the return type still needs a type Parameter
// You define this type parameter similar to the generic class by using the angle brackets, but you place the bracket before the method name
fun <E> timeSeriesOf(vararg elements: E) : TimeSeries<E> {
    val result = TimeSeries<E>()

    // Loop through the elements that we receive and add them
    for (element in elements) {
        result.add(element)
    }
    return result
}

fun main() {
    val timeline: TimeSeries<Int> = TimeSeries()
    timeline.add(2)
    val latest = timeline.getLatest()
    println(latest)

    // Example of how to use the generic functions
    val timeline2 = timeSeriesOf(1,2,3)
    // Explicitly defining the type for the list of ints
    val timeline3: TimeSeries<Int> = timeSeriesOf(1,2,3)

    // Timeline of strings
    val timeline4 = timeSeriesOf("", "", "")
    // Explicitly defined
    val timeline5: TimeSeries<String> = timeSeriesOf("", "", "")
}