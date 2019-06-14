package oo

// This class will take in some value 't' of type 'T' and return this 't' object when produceT() is called
// Classes like this Source class are called "Producers" because they only ever produce elements of type "T" (or their generic type parameter)
// But they never actually consume them
// Note: if you add the 'out' keyword you can let kotlin know that this class will act as a "Producer"
// Note, if you remove the 'out' keyword then the covariance exhibited on line 16 will no longer work since kotlin cannot infer that this class is a 'Producer'
class Source<out T>(val t: T) {
    fun produceT(): T {
        return t
    }
}

// Example of contravariance (the inverse of variance)
// Classes like this Sink class are called "Consumers" because they only ever consume elements of type "T" (or their generic type parameter)
class Sink<in T> {
    fun consumeT(t: T) {
        // ... consume t
    }
}


fun main() {
    val strSource: Source<String> = Source("Producer")
    // this is another example of covariance
    // Note: out -> covariance
    val anySource: Source<Any> = strSource
    // This will produce a type String, which is valid for the type Any
    anySource.produceT()

    val anySink: Sink<Any> = Sink()
    // this is another example of contravariance
    // Note: in -> contravariance
    val strSink: Sink<String> = anySink
    strSink.consumeT("Consumer")

    // Invariance = neither covariant nor contravariant i.e. when you can only use the exact type that is being looked for
}