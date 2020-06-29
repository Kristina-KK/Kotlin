package collection_data_types

fun main() {

//    arrayExamples()
//    listExamples()
    mapExamples()

}

fun mapExamples() {
//    val map = mapOf(1 to "a", 2 to "b", 3 to "c") // immutable map
    val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c") // mutable map
    map.put(4, "d")

    map.forEach { key, value -> println("$key -> $value") }

}

fun arrayExamples() {

    val interestingThings = arrayOf("Kotlin", "Programming", "Comic Books")

    println(interestingThings.size)
    println(interestingThings[0])
    println(interestingThings.get(0))
    println("----------")

    for(interestingThing in interestingThings) {
        println(interestingThing)
    }
    println("----------")

    // for petlja na funkcionalan način
    interestingThings.forEach {
        println(it)
    }
    println("----------")

    interestingThings.forEach { interestingThing -> // moguće je preimenovati parameter it
        println(interestingThing)
    }
    println("----------")

    interestingThings.forEachIndexed { index, interestingThing ->
        println("$interestingThing is at index $index")
    }

}

fun listExamples() {

//    val interestingThings = listOf("Kotlin", "Programming", "Comic Books") // immutable list
    val interestingThings = mutableListOf("Kotlin", "Programming", "Comic Books") // mutable list
    interestingThings.add("Dogs")

    interestingThings.forEach {
        println(it)
    }

}