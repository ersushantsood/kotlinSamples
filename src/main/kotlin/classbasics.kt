class Info {

    /*You cannot declare fields directly inside a class, instead you declare properties*/

    var description = "This is Martial Arts Class"

    /*These properties look and behave suspiciously like simple fields: you can assign values to them and access their values just like any other simple variable.*/

    /*However, behind the scenes the compiler converts them to properties with a hidden backing field. I.e.,
     each property has a backing field that is accessible through a getter and a setter. When you assign a
     value to a property the compiler calls the setter. and when you read its value the compiler calls a getter to obtain it.
     In fact, you can alter the default behavior of a property and create a custom getter and/or setter.
     */

    /*Inside these custom accessors you can access the BACKING FIELD using the identifier field.
    You can access the value passed to the setter using the identifier value.
    You cannot use these identifiers outside the custom accessors.*/
    var name : String = ""
        get() = "\"$field\""
        set(value) {
            field = value.capitalize()
        }

}

fun main(){
    val info = Info()
    println(info.description)

    info.description =  "Rambo is learning well"

    println(info.description)

    //accessing custom accessors
    info.name = "Rambo Sood"

    println("Custom Accessors where Name is capitalized: "+info.name)


}