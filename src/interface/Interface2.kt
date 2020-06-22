package `interface`

interface A {
    fun printMe() {
        println(" method of interface A ")
    }
}

interface B {
    fun printMeToo() {
        println("I am another Method from interface B")
    }
}

// implements two interfaces A and B
class MultipleInterfaceExample: A, B

fun main(args: Array<String>) {

    val obj = MultipleInterfaceExample()
    obj.printMe()
    obj.printMeToo()

}

