//The concept of variance refers to the relation between generic types with/on the basis of argument types that are related.
// For instance, given that Double is a subclass of Number, is List<Double> a subclass of List<Number>

fun read(list: List<Number>)
{
    println(list.last())
}

fun main(){
    val doubles : MutableList<Double> = mutableListOf(4.5,3.2)
    val ints : MutableList<Int> = mutableListOf(2,3)
    val numbers : MutableList<Any> = mutableListOf(3,2.3)

    //read(doubles)
   // read(ints)
   // read(numbers)

  //  add(doubles) // this is an error
  //  add(ints) // this is an error
  //  add(numbers) // this works fine


}


fun add(list: MutableList<Number>) {
 //  list.add(3.2)
}

//We cannot safely add elements to a list which has a type argument of a subtype because we do not know the actual type of the elements of the list.
// In short, the issue is that we could have a list of Double and we cannot add Int to this list, or vice versa.
// That is because this would break type safety and we would have a list with argument of types different from the one we expect.



//COVARIANCE : A generic class is covariant if it is a generic class for which it is true that if A is a subclass of B, then Generic<A> is a subclass of Generic<B>.
// That is to say the subtype is preserved.

//Defining a Covariance class : For example, if a List of Int is a subtype of a List of Number then List is covariant .
        //To define a covariant class you use the modifier OUT before the name of the generic type.


//class covariance_class<out T> {
   // fun create(): T
//}


open class Animals
//// T is covariant and also constrained to be a subtype of Animal
class Group<out T : Animals> {

    fun feed(animals : Group<Animals>){

    }
}

class Cat : Animals() {

}

fun feedCats(cats: Group<Cat>) { // <- it is Group<Cat>
   val groups = Group<Animals>()
    groups.feed(cats) // <- if T wasn't covariant this call would be invalid
    // that's because Group<Cat> would not be a subtype of Group<Animal>
}


//Learning from above : This example contains three classes: Animal and Cat are normal classes,
// while Group<T> is a generic class. The covariance is declared for Group<T> and that is what allows its use in functions that use this type.
//We can pass an object of type Group<Cat> to the function feed() only because we have declared T to be covariant. If you omitted the out modifier you would receive an error message about an incompatible type:
// Type mismatch: inferred type is Group<Cat> but Group<Animal> was expected


//Covariance Is Not Free
//Having covariance is useful, but it is not a free lunch. It is a promise that you make that variables of the generic type will be used only in certain ways that guarantees to respect covariance.
//
//In and out position in generics
//In practical terms it means that if you want to declare a type parameter T as covariant you can only use it in out position. So, all the methods that use it, inside the generic class, can only produce elements of that type and not consume it. Of course, this restriction only applies to methods inside that specific generic class. You can use the whole generic class normally as argument of other functions.
//
//For example, the following is valid code.
//
//class Group<out T : Animal> {
//    fun buy() : T {
//        return Animal() as T
//    }
//}
//However, this is not.
//
//class Group<out T : Animal> {
//    // error: you cannot do it if T is covariant
//    fun sell(animal: T) { /* .. */ }
//}

//CONTRAVARIANCE : A generic class is contravariant if it is a generic class for which it is true that if A is a subclass of B,
// then Generic<B> is a subclass of Generic<A>. That is to say the subtype is reversed.

//To define a contravariant class you use the modifier it before the name of the generic type.
//
//class Contravariant<in T> {
//     fun read(e: T)
//}
//As you can imagine, to declare a type parameter as contravariant you need to respect the opposite restriction than the one for a covariant class. You can only use the type in in position for the methods of the class.
//
//Let’s see an example of a contravariant class:
//
//open class Animal
//class Dog : Animal()
//// T is contravariant and constrained to be a subclass of Animal
//class Pack<in T : Animal> {
//    fun sell(animal: T) { // <- notice that is in position
//        /* .. */
//    }
//}
//fun sellDog(dog: Dog) : Pack<Dog> {
//    return Pack<Animal>() // <- if T wasn't contravariant this call would be invalid
//    // that's because Pack<Animal> would not be a subtype of Pack<Dog>
//}
//This example contains three classes: Animal and Dog are normal classes, while Pack<T> is a generic class. The contravariance is declared for Pack<T> and that is what allows its use in functions that use this type.
//
//We can return object of type Pack<Animal> in the function sellDog() only because we have declared T to be contravariant. If you omitted the in modifier you would receive an error message about an incompatible type:
//
//Type mismatch: inferred type is Pack<Animal> but Pack<Dog> was expected