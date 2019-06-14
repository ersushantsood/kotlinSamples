//Delaying for a time while another coroutine is working is not a good approach.
// Let's explicitly wait (in a non-blocking way) until the background Job that we have launched is complete
package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


//Here runBlocking<Unit> { ... } works as an adaptor that is used to start the top-level main coroutine.
// We explicitly specify its Unit return type, because a well-formed main function in Kotlin has to return Unit.
fun main() = runBlocking<Unit>{

    val job = GlobalScope.launch {
        delay(1000L)
        println("Country!!!")
    }

    println("HI,")
    job.join()
}

