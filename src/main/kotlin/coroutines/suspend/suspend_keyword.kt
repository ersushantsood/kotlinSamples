package coroutines.suspend

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        executeTaekwondo()
        println("Ayeeeeyaaaa!!!")
    }
}

//uspending functions can be used inside coroutines just like regular functions, but their additional feature is that they can, in turn, use other suspending functions,
// like delay in this example, to suspend execution of a coroutine.
suspend fun executeTaekwondo(){
  delay(1000L)

    coroutineScope {
        launch {
            delay(500L)
            println("coroutine scope in the suspend function")
        }
    }
    println("Taekwondo")
}