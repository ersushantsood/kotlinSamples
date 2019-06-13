//Frequently the best way to group semantically connected data is to create a class to hold it.
// For such a class, you need a a few utility functions to access the data and manipulate it (e.g., to copy an object).
// Kotlin includes a specific type of class just for this scope: a data class.

//Kotlin gives all that you typically need automatically, simply by using the data keyword in front of the class definition.

//That is all you need. Now you get for free:

//1.getters and setters (these only for variable references) to read and write all properties
//2.component1() .. componentN() for all properties in the order of their declaration. These are used for destructuring declarations (we are going to see them later)
//3.equals(), hashCode() and copy() to manage objects (ie. compare and copy them)
//4.toString() to output an object in the human readable form Name_of_the_class(Name_of_the_variable=Value_of_the_variable, [..])"


data class User(var name: String , var password: String , var age: Int) {

}

fun main(){
    val user = User("Sushant","test", 33)

    println("Printing Component1 of object: ${user.component1()}")

    val (name,password,age) = user

    println("destructured Name "+name)
    println("destructured Age "+age )
}