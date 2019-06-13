class generics<T>(t: T) {
    var value = t
}

fun main(){
    var genericObj = generics<Int>(5)

    println("VALUE IN GENERICS Object:: "+genericObj.value)

    val item = genericfunction("text")
}


//Generics can also be used in functions .
fun <T> genericfunction(obj: T) : List<T> {
    return listOf(obj)
}


//You can limit a generic type to a specific class or one of its subclasses
//T also accepts the subtype of Number
//fun <T: Number> doubleNums(value: T) : Double {
    // accepts T of type Number or its subclasses
   // return value.toDouble() * 2
// }