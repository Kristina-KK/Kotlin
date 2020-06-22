fun main(args: Array<String>) {
//    ifElseBlock()
//    whenBlock()
//    forLoop()
//    forLoopWithIndex()
//    whileLoop()
//    doWhileLoop()

//    useReturnBreakAndContinue()
    breakAndContinueExample()

}


fun ifElseBlock() {

    val a: Int = 5
    val b: Int = 2
    var max: Int

    if (a > b) {
        max = a
    } else {
        max = b
    }
    println("Maximum of a or b is " + max)

    val max_2 = if (a > b) a else b
    println("Maximum of a or b is " + max_2)

}

// isto kao switch u Javi
fun whenBlock() {
    val x: Int = 5
    when (x) {
        1 -> print("x = = 1")
        2 -> print("x = = 2")
        else -> {
            println("x is neither 1 nor 2")
        }
    }
}

fun forLoop() {
    val items = listOf(1, 2, 3, 4)
    for (i in items)
        println("values of the array " + i)
}

fun forLoopWithIndex() {
    val items = listOf(1, 2, 3, 4)
    for ((index, value) in items.withIndex()) {
        println("the element at $index is $value")
    }

}

fun whileLoop() {
    var x: Int = 11
    println("Example of while loop -- ")

    while (x <= 10) {
        println(x)
        x++
    }

}

/*
za razliku od while kod će se izvršiti barem
jednom i ako uvijet iz while dijela nije zadovoljen
 */
fun doWhileLoop() {
    var x:Int = 70
    do {
        x = x + 10
        println("I am inside Do block --- " + x)
    } while(x <= 50)

}

// ****************************************************************

fun useReturn() {
    var x:Int = 10
    println("The value of X is -- " + doubleMe(x))
}
fun doubleMe(x:Int) : Int {
    return 2*x
}

fun breakAndContinueExample() {
    println("Example of Break and Continue")
    myLabel@ for(x in 1..10) { // appling the custom label
        if(x == 5) {
            println("I am inside if block with value $x \n-- hence it will close the operation")
            break@myLabel //specifing the label
        } else {
            println("I am inside else block with value " + x)
            continue@myLabel
        }
    }
}