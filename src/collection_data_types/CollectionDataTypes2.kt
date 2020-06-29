package collection_data_types

import functions.sayHello2

fun sayHello(greeting: String, itemsToGreet: List<String>) {
    itemsToGreet.forEach{ itemToGreet ->
        println("$greeting $itemToGreet")
    }
}

fun sayHello(greeting: String, vararg itemsToGreet: List<String>) { // ako je dodana ključna riječ vararg tada je to overloadana metoda
    itemsToGreet.forEach{ itemToGreet ->
        println("$greeting $itemToGreet")
    }
    if (itemsToGreet == null) { println("== null -> samo 1 param -> $greeting") }
    if (itemsToGreet.isEmpty()) { println("isEmpty() -> samo 1 param -> $greeting") }
}

fun sayHello2(greeting: String, vararg itemsToGreet: String) {
    itemsToGreet.forEach{ itemToGreet ->     // zbog vararg parametra iteriramo vrijednosti
        println("$greeting $itemToGreet")
    }
}

fun main() {
    val interestingThings = listOf("Kotlin", "Programming", "Comic Books")
    sayHello("Hi", interestingThings)
    sayHello("Hi", listOf()) // prazna lista mora biti kao parametar ako se želi proslijediti samo jedan parametar - bez oznake "vararg" (ključna riječ u Kotlinu)
    println("------------")
    sayHello("Hi") // prazna lista mora biti kao parametar ako se želi proslijediti samo jedan parametar - bez oznake "vararg"
    println("------------")
    sayHello2("Hello", "Kotlin", "Programming", "Comic Books")
    sayHello2("Hello", "Kotlin")
    println("------------")
    val interestingThingsArray = arrayOf("Kotlin", "Programming", "Comic Books")
    sayHello2("Hi", *interestingThingsArray) // spread operator - znak * - kada želimo proslijedititi podatke iz array-a kao String-ove jedan po jedan
                                                    // s time da metoda mora imati parametar "vararg" u tom slučaju
}