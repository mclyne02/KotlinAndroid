package oo

open class Being
open class Person : Being()
open class Student: Person()

fun main() {
    // Covariance = we can use a "more derived" type (a subtype)

    val people: MutableList<Person> = mutableListOf(Person(), Person())
    // Note, adding this Student here is an example of covariance since Student is a type of Person, so it should be able to be added
    people.add(Student())

    // Note: This will not work because Being is not a "more derived" type it is actually a "less derived" type
    // Also, this wont work because Being doesn't fulfill the contract or class Person
    // people.add(Being())

    // Note, this is always expected to be a person
    people[0]
    // Lets say you want to access a method of type person, like speakEnglish(), this would not exist on the type Being since it is a super class ot Person
    // people[0].speakEnglish()

    // This is another example of covariance since Person is a "more derived" type of the most abstract class Any
    val p: Any = Person()

    val p2: Person = Student()

    // Another example of covariance with a list of Students
    // This is ok
    // Read-only collections are covariant
    val students: List<Person> = listOf<Student>()

    // This is NOT ok
    // Mutable collections are NOT covariant
    // val students2: MutableList<Person> = mutableListOf<Student>()
    // This is not ok when you try to do something like this
    // This is not possible because you have defined the list as being of type Person but the elements need to be of type Student since the list is mutable
    // students2.add(Person())

    // Kotlin vs Java covariance Example
    // Kotlin
    val events: TimeSeries<Person> = timeSeriesOf()
    val students3: List<Student> = listOf(Student(), Student())
    // Note that the compilier does not complain here
    events.addAll(students3) // covariance

    // This type of thing in Java the addAll method would not be possible since there is no clear distinction between mutable and immutable lists in java
}