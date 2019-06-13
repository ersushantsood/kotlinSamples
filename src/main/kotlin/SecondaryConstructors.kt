//declaration of  parameterized constructors

class ata_secondaryconstructor (var name: String, var age : Int, var school: String ) {


    /*You cannot include any code inside the primary constructor. Instead, if you need to do any initialization, you can use initializer blocks.
     There can be many initializer blocks; they are executed in the order in which they are written. This means that they are not all executed
     before the initialization of the object, but right where they appear.*/

    init {
        println("Hello!! This is $school")
    }

    //Var on Secondary constructor not allowed
    //constructor(var fees: Int) : this(""){

    //}

    //THIS is SECONDARY CONSTRUCTOR. Secondary constructors must eventually call the primary constructor: they can do that directly or through another secondary constructor.
     //The important difference between secondary and primary constructors is that the parameters of primary constructors can define properties
    // while the parameters of a secondary constructor are always just parameters.
    constructor(fees: String):this("Hitman",23,"WWE"){
        
    }

    var studentname = name
    var studentage = age

    fun studentName(): String {

        return this.studentname
    }

    fun studentAge() : Int {
        return this.studentage
    }
}

fun main(){

    //This will throw an error as you got parameterized constructor
    // var atacampus = ata()

    var ata_paramCons = ata("Rambo", 5, "ata paradise valley")

    println("Student Name is : "+ata_paramCons.studentName())

    println("Student Age is : "+ ata_paramCons.studentAge())
}