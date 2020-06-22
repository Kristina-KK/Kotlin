package inheritance

/*
ključna riječ open koristi se da bi se omogučilo nasljeđivanje klasa jer je defaultno u Kotlinu class bez te oznake automatski final
 */
open class ABC {
    open fun think() { // da bi metoda mogla biti override također mora biti označena s open
        println("Hey!! I am think")
    }
}

class BCD : ABC() { // inheritance se događa s defaultnim konstruktorom
    override fun think() {
        print("I Am from Child")
    }
}

fun main (args: Array<String>) {
    var a = BCD()
    a.think()
}