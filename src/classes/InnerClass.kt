package classes

fun main(args: Array<String>) {

    val demo = Outer().Nested().foo()
    print(demo)

}

class Outer {

    private val welcomeMessage: String = "Welcome to the TutorialsPoint.com"

    // inner class - nije defaultno statička klasa kao bez te oznake
    //
    inner class Nested {
        fun foo() = welcomeMessage
    }

}

// https://www.tutorialspoint.com/kotlin/kotlin_quick_guide.htm

