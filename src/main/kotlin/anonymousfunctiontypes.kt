//anonymous function types
//funVar can hold any function that has the corresponding signature. That is to say any function that accepts a String as argument and returns Unit (i.e., no value).

//var funVar : (String) -> Unit

//For example, you could assign directly a function using a callable reference to that particular element.
// The syntax is name_of_the_class::name_of_the_function. In the previous example tell is a top-level function so the class is absent.
// If you wanted to reference a functon like toDouble of the String class, you would use String::toDouble

fun tell(text: String){
    println(text)
}


fun main(args: Array<String>){

    //function type
    var funVar: (String) -> Unit

    funVar = ::tell

    //calling anonymous
    wisdom()
}


//Unit return type can be omitted in normal functions but not in FUNCTION types

//When you define a function type you always have to explicitly indicate the return type.
// When declaring normal functions that return Unit you can omit the return type, but not with function types.
// Also, you have to put the parentheses for the parameters, even when the function type does not accept any parameter.

val wisdom : () -> Unit = {
    println("This function type has Unit Return type and null arg")
}

//if there are no args and return type is Unit , then one can skip type completely
val wisdom_skip = {
    println("This function skipped the function type declaration ")
}

