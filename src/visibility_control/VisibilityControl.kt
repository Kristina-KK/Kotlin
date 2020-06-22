package visibility_control

// PRIVATE
private class PrivateExample {
    private val i = 1
    private fun doSomething() {
    }
}

// PROTECTED - isto kao private + subklase (u Javi je subklase + u istom paketu u kojem je protected klasa)
open class A() {     // klasa A mora biti označena "open" kako bi mogla biti nasljeđena - inače se gleda kao da je "final"
    protected val i = 1
}

class B : A() {
    fun getValue() : Int {
        return i
    }
}

// INTERNAL - novi Kotlinov modifier - vidljivo unutar istog modula
class InternalExample {
    internal val i = 1
    internal fun doSomething() {
    }
}

// PUBLIC - za razliku od Jave gdje se bez modifiera gleda kao package, u Koltinu je to public
class PublicExample {
    val i = 1
    fun doSomething() {}
}