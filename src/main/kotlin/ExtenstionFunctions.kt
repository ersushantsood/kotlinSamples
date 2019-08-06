/*
*Kotlin, similar to C# and Gosu, provides the ability to extend a class with new functionality
* without having to inherit from the class or use any type of design pattern such as Decorator.
* This is done via special declarations called extensions. Kotlin supports extension functions
* and extension properties.
* */


//To declare an extension function, we need to prefix its name with a receiver type,
// i.e. the type being extended. The following adds a swap function to MutableList<Int>

fun MutableList<Int>.swap(index1: Int , index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun main(){
    val list_with_extended_fn = mutableListOf<Int>(1,2,4);
    list_with_extended_fn.swap(1,2)
    println(list_with_extended_fn)
}

/*Further Explanation :
* Extensions do not actually modify classes they extend. By defining an extension,
* you do not insert new members into a class, but merely make new functions callable
* with the dot-notation on variables of this type.

We would like to emphasize that extension functions are dispatched statically,
*  i.e. they are not virtual by receiver type. This means that the extension function
*  being called is determined by the type of the expression on which the function is invoked,
* not by the type of the result of evaluating that expression at runtime
* */