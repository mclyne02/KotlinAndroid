package oo

// Must use the 'enum' keyword and the 'class' keyword, similar to the 'data class' structure
// Standard way to make enum
/*
enum class Direction {
    NORTH, EAST, SOUTH, WEST
}
*/

// Or you can pass some value in the enum and set it in the constructor for each enum
enum class Direction(degree: Double) {
    NORTH(0.0), EAST(90.0), SOUTH(180.0), WEST(270.0)
}

// Another enum example for say suits
enum class Suits {
    HEARTS, SPADES, DIAMONDS, CLUBS
}

fun main() {
    val suit = Suits.SPADES

    // Note, if you use all the different types of your enum then the kotlin compiler will know this and wont throw an error
    // however, if you dont use all the values of your enum, then you will have to have an else block in your with()
    val color = when(suit) {
        Suits.HEARTS, Suits.DIAMONDS -> "red"
        Suits.SPADES, Suits.CLUBS -> "black"
    }

    // Example of not all enum values being checked and the need for an else block
    val color2 = when(suit) {
        Suits.HEARTS, Suits.DIAMONDS -> "red"
        else -> "black"
    }

    println(color)
    println(color2)
}