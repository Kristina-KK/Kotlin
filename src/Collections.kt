fun main (args: Array<String>) {

    // COLLECTIONS
    val numbersML: MutableList<Int> = mutableListOf(1, 2, 3) // mutable list
    val readOnlyView: List<Int> = numbersML // immutable list
    println("my mutable list-- " + numbersML)  // print "[1, 2, 3]"
    numbersML.add(4)
    println("my mutable list -- after addition -- " + numbersML)
    println(readOnlyView) // print "[1, 2, 3, 4]"
//    readOnlyView.clear()    // ⇒ does not compile

    /*
    TODO dodaj KOTLIN METODE
    useful Kotlin methods --> first(), last(), filter()
     */

    // https://www.tutorialspoint.com/kotlin/kotlin_quick_guide.htm

    val items = listOf(1, 2, 3, 4)
    println("First Element of our list ---- " + items.first())
    println("Last Element of out list ----" + items.last())
    println("Even Numbers of our list ---- "
        + items.filter { it % 2 == 0 }
    )

    val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
    println(readWriteMap["foo"])

    val strings = hashSetOf("a", "b", "c", "c") // ne podržava duplikate
    println("My Set Values are " + strings)

    // RANGE examples
    val i : Int = 2
    for(j in 1..4)
        print(j)

    if (i in 1..10) {
        println("We found your number -- " + i)
    }


}