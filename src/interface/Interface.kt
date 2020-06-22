package `interface`

/*
interface u Kotlinu je isti kao u Javi 8
što znači da može sadržavati implementaciju metode kao default metodu
 */
interface ExampleInterface {

    var myVar: Int // abstract property
    fun absMethod(): String // abstract method
    fun sayHello() = "Hello there" // method with default implementation
    fun hello() {
        println("Hello there, Welcome to TutorialsPoint.Com!")
    }

}

class InterfaceImpl : ExampleInterface { // klasa nije abstract pa mora sadržavati implementaciju metode absMethod()

    override var myVar: Int = 25
    override fun absMethod() = "Happy Learning"

}

abstract class InterfaceImpl2 : ExampleInterface { // abstract klasa ne mora override-ati abstract metode iz interface-a

}

fun main(args: Array<String>) {

    val obj = InterfaceImpl()
    println("My Variable Value is = ${obj.myVar}")
    println("Calling hello(): ")
    obj.hello()

    println("Message from the Website-- ")
    println(obj.absMethod())

}