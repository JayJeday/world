package com.globe.i.world

import android.icu.lang.UCharacter

fun main(args: Array<String>) {

    val firstTrip = Trip("puerto rico", 23.22)
    var p = Person("test")

    val lib = Librarian("manage",12.222)
    //destruction
    val (position,salary) = lib.getLibrarian()

    println("do math static" + Trip.doMath())
    firstTrip.lopps()

    var str = "test all might"
    println(str.substring(0..3))

    val test = firstTrip.enterAge(p)

    var result = test ?: "nullable"

    println("enter age length | $test")
}

data class Trip(val name: String, val price: Double) {

    val tripName: String? = name
    var tripPrice = price

    //late init
    internal lateinit var person: Person


    //static methos
    companion object {

        val boxSize: Int = 5


        fun doMath() = boxSize + 3
    }

    //list and arrays and builders and exceptions
    fun called(): String {
        return "the trip $tripName  and the amoount $tripPrice"
    }

    fun enterAge(person: Person): Int? {
        //check nullability
        var sentence = ""

        person.age?.let {
            sentence + "not nullable"
        }

        println(sentence)

        return person.age?.length

        //casting
//         if (object is Car) {
//         }
//         var car = object as Car
//          implicit -> var car = object
//// if object is null
//         var car = object as? Car // var car = object as Car?
    }

    fun lopps() {
        //list
        var lists = listOf(1, 2, 3, 4, 5)
        lists.filter { it > 3 }.forEach { print(it) }



        for (c in 1..10 step 2) {   //until, downTo,
            println("lista: $c")
        }
    }

    fun score(score: Int) {

        var grade = when (score) {
            9, 10 -> "Excellent"
            in 6..8 -> "Good"
            4, 5 -> "OK"
            in 1..3 -> "Fail"
            else -> "Fail"
        }


    }

    fun isExpensive(): String = if (tripPrice > 100) "is espensive" else "is not espensive"

}

enum class Direction constructor(direction: Int) {
    NORTH(1),
    SOUTH(2),
    WEST(3),
    EAST(4);

    //properties
    var direction: Int = 0
        private set

    init {
        this.direction = direction
    }
}


open class Person(val mage: String) {
    val name: String = "test"

    lateinit var social: String
    val age: String = mage;

    open fun status() = "unemployed"

}

class Courutine{

    fun testCourutine(){

    }

}

data class Librarian(val position: String, val salary: Double) : Person("18") {

    val pos = position
    val sal = salary

    //alternative way to do it
//    constructor() : super("4") {
//
//    }
            fun getLibrarian():Librarian{
        return Librarian(pos,sal)
    }
    override fun status() = "From librarian"

    //lambda function
    val add : (Int, Int) -> Int = { a, b -> a + b }

    val addTax : (Double,Double) -> Double = {sal1, sal2 -> sal1 + sal2}
}