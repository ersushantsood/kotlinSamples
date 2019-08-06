package coroutines.coroutine_cancellation

//Now we are making Computation in co-routine cancellable , so cancellation is non-cooperative

import kotlinx.coroutines.*

fun main() = runBlocking {

        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            try {
                var instant = startTime
                var i = 0
                //isActive is checking if cancel is called , isActive makes computation co-operative to cancellation
                while (isActive) {
                    if (System.currentTimeMillis() >= instant) {
                        println("job: I am sleeping , so no Taekwondo ${i++}")
                        instant += 500L
                    }
                }
            }
            finally {
                println("I will definitely run before MAIN is completed as Cancel and Join always worry about me")
            }
        }



    delay(1500L)
    println("Lets Do some Taekwondo and stop sleeping")
    //Coroutine cancellation is cooperative. A coroutine code has to cooperate to be cancellable.
    // All the suspending functions in kotlinx.coroutines are cancellable. They check for cancellation of coroutine
    // and throw CancellationException when cancelled.
    // However, if a coroutine is working in a computation and does not check for cancellation,
    // then it cannot be cancelled, like the following example shows:
    job.cancelAndJoin()
    println("I am starting Taekwondo and getting ready for home as well")


    //Tt continues to print ""job: I am sleeping , so no Taekwondo"  even after cancellation until the job completes by itself
    // after five iterations.
}