fun main() {

    var obj : Double = 44.0

    if (obj is Double) {
        println(obj+3.0)
    }

   /* if (obj !is String) {
        println(obj)
    }*/


    //Type Casting
    //If you need to cast an object there is the as operator. This operator has two forms: the SAFE and UNSAFE cast.

    //The unsafe version is the plain as. It throws an exception if the cast is not possible.
    val number = 27
   // var unsafe_large = number as Double  //This cast is going to throw exception


    //The safe version as? instead returns null in case the cast fails , but the receiving variable should accept null
    var  safe_large: Double? = number as? Double

    println("Safe Casting : $safe_large")



}