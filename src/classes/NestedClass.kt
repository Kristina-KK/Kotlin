package classes

fun main(args: Array<String>) {

    //  nested class is by default static
    val demo = Outer1.Nested().foo() // calling nested class method
    print(demo)

}

//  nested class is by default static
class Outer1 {

    private val welcomeMessage: String = "Welcome to the TutorialsPoint.com"

    class Nested {

        fun foo() = "Welcome to The TutorialsPoint.com"

    }

}
