fun main() {
    val li = listOf<Int>(1,2,3,4)
    println(li.filter({i:Int -> i%2 ==0}))

    //Map operation
    println (li.map { it * 2  })

    val lstNumbers = listOf<Number>(Number("one",1),Number("two",2),Number("three",3))

    println("Numbers:"+lstNumbers.map { it.name })


    //Find and groupBy

    val list = listOf(1,2,3,4)
    //The function find returns the first element of the collection that satisfies the condition set in the lambda.
    // It is the same function as firstOrNull, which is a longer but also clearer name
    println("Finding the first match as per the lambda condition: "+list.find { it % 2 ==0 })
    println("Finding the last match as per the lambda condition: "+list.findLast { it % 2 == 0 })



    val animal_collection = listOf(Animal("Lion","carnivore"),Animal("Tiger","carnivore"),
        Animal("Elephant","herbivore"),Animal("Rabbit","herbivore"))

    val animal_groups = animal_collection.groupBy { it.type }

    println("Group of Herbivores and Carnivores:"+animal_groups)

    //Fold Operation
    //In the previous example, the first time we start with 0 and added all elements until the end.
    // In the second case, with start with 15 and subtracted alle elements.
    // Basically, the provided value is used as argument for start in the first cycle, then start becomes the value returned by the previous cycle.

    var items_list = listOf<Int>(5,10,25)
    println("Folding the collection:"+items_list.fold(0, {start,element -> element+start}))
    println("Folding the collection by Subtracting the items: "+items_list.fold(25,{start,element -> start-element}))

    //So, in the first case the function behaves like this:
    //
    //start = 0, element = 5 -> result 5
    //start = 5, element = 10 -> result 15
    //start = 15, element = 25 -> result 40


    //flatten operation  : The function flatten creates one collection from a supplied list of collections.
    var lists = listOf<List<Int>>(listOf(1,2), listOf(4,5))

    var flattened_list = lists.flatten()

    println("Flattened List: "+flattened_list)

    //Flatmap operation : flatMap use the provided lambda to map each element of the initial collection to a new collection,
    // then it merges all the collections into one collection.

    val lists_numbers = listOf<Number>(Number("one",1),Number("two",2),Number("three",3))

    println(lists_numbers.flatMap { listOf(it.value) })

    //In this example, we create one list with all the values of the property value of each element of type Number. These are the steps to arrive to this result:
    //
    //each element is mapped to a new collection, with these three new lists
    //listOf(1)
    //listOf(2)
    //listOf(3)
    //then the these three lists are merged in one list, listOf(3,3,5)
    //Notice that the initial collection does not affect the kind of collection that is returned. That is to say, even if you start with a set you end up with a generic collection
}


data class Number(val name: String, val value : Int)

data class Animal(val name: String, val type: String)


