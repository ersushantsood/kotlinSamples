fun main() {



  for (a in 1..4) {
      println("$a")
  }

    var s = 3
    if (s in 1..4) {
        println("s comes in the checked range")
    }


    //descending range
    for (t in 4 downTo 1) {
        println("$t")
    }


    //Step and Until
    println("2 steps at a time")

    for (r in 4 downTo 1 step 2) {

        println("$r")
    }

    println("Run loop until 50")

    for(u in 1 until 50) {
        println("$u")
    }
}