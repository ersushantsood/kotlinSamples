
fun main() {
    var top = 0
    val a = 4
    val b = 5

    if (b > a) top = b


    if (a > b) {
        top = a
    }

    else {
        top = b
    }

    //if statements can return values

    // returns a or b
    val topreturn = if (a > b) a else b

// With blocks
// returns a or 5
    var topreturna= if (a > 5) {
        println("a is greater than 5")
        a
    } else {
        println("5 is greater than a")
        5
    }
}

