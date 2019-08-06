package coroutines.coroutine_cancellation

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
   val job =  GlobalScope.launch {
        repeat(1000) { i ->
            println("I am in sleep mood, dont wanna try Taekwondo, $i")
            delay(1000L)
        }
    }

    delay(1300L)
    println("I am now cancelling it , I want to do some Taekwondo")
    job.cancel()
    job.join()
    println("Its time to go home")

}