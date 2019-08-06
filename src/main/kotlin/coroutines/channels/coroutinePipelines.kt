package coroutines.channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

fun CoroutineScope.indiaScoringRoutine() : ReceiveChannel<Int> = produce {

    var score = 1
    while(true) {
        send(score++) //India is hitting hard to score infinite
    }
}

fun CoroutineScope.evaluateRunRate(receiveChnl: ReceiveChannel<Int>) : ReceiveChannel<Int> =  produce {

    for (sc in receiveChnl){
        send(sc*2)
    }
}

fun main() {
    //var indiaScore = ind
}