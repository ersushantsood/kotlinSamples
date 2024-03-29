fun main() {
    //defining constant using val keyword
    val constantVal = 3
    print("I am constant:   "+constantVal)

    //defining variable using var keyword, this is dynamically typed variable
    var number = 20
    print("\nI am variable number and i store :"+number)

    //Normally, properties declared as having a non-null type must be initialized in the constructor.
    // However, fairly often this is not convenient. For example, properties can be initialized through
    // dependency injection, or in the setup method of a unit test. In this case, you cannot supply a non-null
    // initializer in the constructor,
    lateinit var testLateInit: String


    //statically typed variable
    var number_staticTyped: Int = 24
    print("\nI am variable number and i store :"+number_staticTyped)

    //Dynamically typed variables cannot be assigned other type data
    var dynamic_var = 3

   /*BELOW will be ERROR*/
    // dynamic_var = "strings"

    //One cannot assign null value to a variable
    var text : String = "Testing null"

    //trying to assign null
    //text =  null

    //There is a way to assign null to a variable by adding ? to type to indicate nullable to compiler
    var nullableText : String? = null

}

fun tell(who: String,what: String ): String {
    return "$who is $what"
}