package coroutines.channels

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Channel is similar to BlockingQueue which transfers data between co-routines.
//Only difference is that instead of blocking PUT and TAKE operation ,
// there are SEND and RECEIVE suspending functions
fun main () = runBlocking {
    val channel = Channel<Int>()
    launch {
        for (x in 1..5) {
            channel.send(x * x)
        }
            //Unlike a queue, a channel can be closed to indicate that no more elements are coming.
            // On the receiver side it is convenient to use a regular for loop to receive elements from the channel.
            //Conceptually, a close is like sending a special close token to the channel.
            // The iteration stops as soon as this close token is received,
            // so there is a guarantee that all previously sent elements before the close are received
            channel.close()

    }

    repeat(4)
    {
    //receive() works fine if channel is not closed explicitly
       println(channel.receive())

        //one can use iterator on channel
        //for(value in channel) {
            //println(value)
        //}
    }

    println("Done!!")

}

