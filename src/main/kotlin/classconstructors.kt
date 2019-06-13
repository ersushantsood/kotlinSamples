//declaration of  parameterized constructors

class ata (var name: String, var age : Int, var school: String ) {


    /*You cannot include any code inside the primary constructor. Instead, if you need to do any initialization, you can use initializer blocks.
     There can be many initializer blocks; they are executed in the order in which they are written. This means that they are not all executed
     before the initialization of the object, but right where they appear.*/

    init {
        println("Hello!! This is $school")
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