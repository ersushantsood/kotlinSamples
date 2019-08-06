package coroutines.channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {

    for(x in 1..10) send(x*2)
}

fun main() = runBlocking {

    val receiveChannel = produceSquares()
   //param it is the lambda argument passed to consumeEach
    receiveChannel.consumeEach {
        println(it)
    }
}
