package basics

fun main() {
    // Lambda function = just a function without a name
    // Define the input, the type, then an arrow, then the return type
    { x: Int -> x*2 }

    // You can assign a variable to the function
    val timesTwoExample = { x: Int -> x*2 }

    // You can also explicitly define the input and output
    val timesTwoExplicit: (Int) -> Int = { x: Int -> x*2 }

    // Kotlin can infer the input and output type tho, so this is fine
    val timesTwo = { x: Int -> x*2 }

    // You can also create a Lambda with more than one input too
    val add = {x: Int, y: Int -> x + y}

    // Same function explicitly defined
    val addExplicit: (Int, Int) -> Int = {x: Int, y: Int -> x + y}

    // HIGHER ORDER FUNCTION EXAMPLE
    val list = (1..100).toList()

    // More like java way
    println(list.filter { element -> element % 2 == 0 })

    // Since this Lambda only has one input you can get rid of the left hand side and the arrow
    // and use the 'it' keyword
    // 'it' is specifically created by Kotlin, and can be used anytime you only have one parameter in the Lambda
    println(list.filter { it % 2 == 0 })

    // Now use the function you created on the 'it' variable
    println(list.filter { it.even() })

    // You can pass in the name of the function you make as follows
    println(list.filter (::isEven))

    // Note that if a function, like filter in this case, takes in a Lambda as it's last argument, we can move that Lambda expression out of the parenthesis
    // Note, this is what is being done above
}

// You can also write the function this way
fun isEven(i: Int) = i % 2 == 0

// Taking the module function and placing it inside its own function
fun Int.even() = this % 2 == 0