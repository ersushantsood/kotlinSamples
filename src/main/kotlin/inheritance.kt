//In Kotlin, a class can only inherits from one other base class.
//A derived class must call a constructor of the base class. This call can happen in different ways and it is reflected in the syntax of a class.


//The difference depends on whether the derived class has a primary constructor or not. If the derived class has no primary constructor,
// it needs to call a constructor of the base class in its secondary constructors, otherwise it can call it directly in its primary constructor.


// it implicitly inherits from Any .Class Any has only few methods like equals and toString. I
class Basic {

}

open class Base {

}

//SYNTAX :  The syntax to make a class derive from another requires to add, after the name of the derived class, a colon and a reference to the base class.
// This reference can be either the name of the class or a constructor of the base class.
//DERIVED CLASS HAS NOT PRIMARY CONSTRUCTOR.
class Derived : Base {

    constructor(p: Int) : super(){

    }

}

// the derived class has a primary constructor
class Derived_With_Prim_Con(var p:Int) : Base() {

}



//You cannot use super (used to call the base constructor) inside the code of the constructor. In other words, super is not a normal expression or function.

//Notice that if the derived class has a primary constructor you must call the constructor of the base class there. You cannot call it later in a secondary constructor.
// So, there are two alternatives, but there is no choice: you have to use one or the other depending on the context.