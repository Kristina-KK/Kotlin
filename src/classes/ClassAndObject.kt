package classes

class myClass {  // class Header
    // class Body

    private var name: String = "Tutorials.point"

    // member function
    fun printMe() {
        println("You are at the best Learning website Named- $name")
    }

}

fun main(args: Array<String>) {
    val obj = myClass() // create obj object of classes.myClass class
    obj.printMe()
}