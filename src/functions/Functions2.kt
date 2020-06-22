package functions

fun main(args: Array<String>) {
    printSum(1, 2)
}

fun printSum(a: Int, b: Int): Unit {  // Unit je isto što i void u Javi - to je opcionalna oznaka return tipa u Kotlinu
    println("sum of $a and $b is ${a + b}")
}