package constructors

/*
Kotlin ima 2 tipa konstruktora
1. primary constructor
2. secondary constructor

Jedna Kotlin klasa može imati 1 primary constructor i jedan ili više secondary constructor
secondary konstruktor ima oznaku --> constructor
koja je obavezna kada se želi kreirati više od jednog konstruktora ili kada se treba dodati
više logike u primarni konstruktor, a to nije moguće jer on može biti pozvan u nekoj drugoj klasi

moguće je kreirati neograničen broj secondary konstruktora, kakogod, svaki od tih konstruktora moraju
pozvati primarni konstruktor direktno ili indirektno

 */

// deklaracija primary konstruktora je unutar zagrada
class Person (val firstName: String, var age: Int) {
    // class body

}

fun main (args: Array<String>) {
    // klasa koja ima samo ---> primary constructor
    val person1 = Person("TutorialsPoint.com", 15)
    println("First Name = ${person1.firstName}")
    println("Age = ${person1.age}")

    // klasa koja ima ---> secondary constructor
    val human = Human("TutorialsPoint.com",25)
    println("${human.message} ${human.firstName}" +
        "Welcome to the example of Secondary constructor, Your Age is - ${human.age}")
}

class Human(val firstName: String, var age: Int) {
    val message: String = "Hey!!!"

    constructor(name: String, age: Int, message: String): this(name, age) {

    }

}