package coroutines

import kotlinx.coroutines.*
import kotlin.concurrent.thread

//Essentially, co-routines are light-weight threads. They are launched with launch co-routine builder in a context of some Co-routine Scope.
//Here we are launching a new co-routine in the GlobalScope, meaning that the lifetime of the new co-routine is limited only by the lifetime of the whole application.

fun main(){

    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }

    println("As delay function is non blocking so , Main method execution is not blocked and I am PRINTED!!!, but Thread.sleep is blocking")
    //Replace globalScope.launch with Thread {}
    thread {
        //That is because delay is a special suspending function that does not block a thread, but suspends co-routine and it can be only used from a co-routine.
        // delay(1000L)
        Thread.sleep(3000L)
        println("World!")
    }

    println("Hello,")
    //Thread.sleep(2000L) //Thread.sleep is blocking the main method execution

    //Making non-blocking function as blocking explicitly.The result is the same, but this code uses only non-blocking delay.
    //The main thread invoking runBlocking blocks until the coroutine inside runBlocking completes.
    runBlocking { // but this expression blocks the main thread
        println("Running non-blocking delay function as blocking ,so making behavior of delay as blocking")
        delay(2000L)
    }

}


//You can achieve the same result replacing GlobalScope.launch { ... } with thread { ... } and delay(...) with Thread.sleep(...). Try it.
