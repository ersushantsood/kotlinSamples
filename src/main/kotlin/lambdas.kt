fun main() {
    //lambda
    var funVar:(String) -> Unit = {text: String -> println(text)}
        //var  //type             //lambda

    funVar("Hello Mam")


    //Calling lambdas right away while defining
    println({x:Int -> x*3}(5))


    //Lambda are so useful that Kotlin has a couple of interesting conventions to simplify their use.
    //The first one is the implicit parameter it.

    //If both these conditions are true:

    //the compiler already knows the signature of the lambda, or can figure it out
    //the lambda has only one argument

    //Then you can omit declaring the parameter of the lambda and use the implicit parameter it.

    var simpleFun: (Int) -> Int = { it + 2 }
    // this is equivalent to the following declaration
    // var simpleFun: (Int) -> Int = {i: Int -> i + 2 }

    println(simpleFun(2))


    //Another form of passing lambdas when lambda is last parameter in function like defined in double method
    //The SECOND CONVENTION applies only if a lambda is passed as argument of the last parameter of a function.
    // In such cases you can write the lambda outside the function parentheses.
    // If the lambda is the only argument of the function, you can omit the parentheses altogether.

    //case 1
      var result_1 = doubleNumber (5){
      it*2   //special parameter it for lambdas
    }

    //case 2
    var result_2 = doubleNumber {
        it*3
    }

    //In the first case, we supply to double both an argument for number (i.e., 5) and a lambda for calculation.
    // For the second one, we just supply a lambda because we take advantage of the default argument of number.
    // In both cases we write the lambda outside the parentheses, in the second case we can omit the parentheses altogether.

    println(result_1)
    println(result_2)
}


//The function double has as parameters an Int and a function.
// The parameter Int has a default value of 1. The function has one parameter of type Int and return a value of type Int.
// The function double returns whatever is returned by the lambda calculation multiplied by 2

fun doubleNumber(num: Int = 1, calculate:(Int)-> Int):Int {

    return calculate(num) * 2
}

fun triple(num:Int, triplify:(Int)-> Int):Int {
    return triplify(num) * 3
}