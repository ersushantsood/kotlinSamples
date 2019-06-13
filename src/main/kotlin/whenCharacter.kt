
//WHEN IS A REPLACEMNT OF SWITCH statement , when can offer much more than that:
//
//can be used as an expression or a statement (i.e., it can return a value or not)
//has a better and safer design
//can have arbitrary condition expressions
//can be used without an argument


//The compiler solves the ambiguity by looking at the order in which you write the branches.
// The construct when can have branches that overlap, in case of multiple matches the first branch is chosen.
// Which means that is important to pay attention to the order in which you write the branches

fun main(){

    var number : Int = 3

    when(number) {

        0 -> println("invalid number")
        1,2 -> println("number is too low")
        3 -> println("This is number 3")
        4 -> println("This is number 4 ")
        else ->
            println("Number does not exist")
    }


    var test : Int = 2

    var result = when(test) {

        2 -> "This is number 2"
        3 -> "This is number 3"
        4 -> "This is number 4"
        else -> "I dont have your number"
    }

    println("I got : $result")


    //Arbitrary Conditional branches

    var arbitrary = 9
    when(arbitrary) {

        0 -> println("invalid number")
        1,2 -> println("number is too low")
        3 -> println("This is number 3")
        4 -> println("This is number 4 ")
        in 3..10 -> println("Number lies within the range")
        !in 100..Int.MAX_VALUE -> println("Number too high")

        else ->
            println("Number does not exist")
    }


    fun specialType(x: Any) {

    }

    //The range expressions are not the only complex conditions that you can use. The when construct can also use functions, is expressions, etc. as conditions.
    fun isValid(x: Any) = when(x) {

        is String -> println("I am string")
        specialType(x) -> println("Its an acceptable type")
        else -> false
    }

    //What you cannot do, is using conditions that return incompatible types. In a condition, you can use a function that accepts any argument,
    // but it must return a type compatible with the type of the argument of the when construct.


    //In this case, the false condition is an example of an invalid condition, that you cannot use with an argument of type Int.
    var results = when(number) {

        0 -> "Invalid Nmber"
        //Check if method returns int
        //check(number) -> "Valid Number"

        //checkString(text) -> "Valid Number"

       // false -> "invalid Condition"  //this will be error as boolean is not compatible with when argument type which is INT
        else -> "Number too large"
    }


    //Using when Without an Argument
           // The last interesting feature of when is that you can use it without an argument.
    // In such case it acts as a nicer if-else chain: the conditions are Boolean expressions.
    // As always, the first branch that matches is chosen.
    // Given that these are boolean expression, it means that the first condition that results True is chosen.

    var text = "hello"
    //number = 6
    when {
        number > 5 -> println("Number is greater than 5")
        text == "hello" -> println("number is less than 5 , but you can say hello")
    }

}