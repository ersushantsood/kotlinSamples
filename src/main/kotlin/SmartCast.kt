//Kotlin is a language that takes into account both safety and the productivity,
// we have already seen an example of this attitude when looking at the when expression.
// Another good example of this approach are smart casts: the compiler automatically inserts safe casts if they are needed,
// when using an is expression. This saves you from the effort of putting them yourself or continually using the safe call operator (?.).


//NOTE : The important thing to remember is that you cannot use smart casts with variable properties.
// That is because the compiler cannot guarantee that they were not modified somewhere else in the code. You can use them with normal variables.

fun main() {
    val x = ""
    when(x) {
        //is Int -> println(x+1)
        is String -> println(x.length + 1)

    }

    //Smart casts works also on the right side of an and (&amp;&amp;) or or (||) operator.
    //// x is automatically cast to string for x.length > 0
    if( x is String && x.length > 0) {

    }
}
