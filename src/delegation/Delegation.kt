package delegation

interface Base {
    fun printMe() // abstract metoda
}

class BaseImpl(val x: Int) : Base {
    override fun printMe() {      // implementacija metode
        println(x)
    }
}

class Derived(b: Base) : Base by b // primjer delegiranja public metode na objekt b koji je u primary konstruktoru Derived klase

fun main(args: Array<String>) {

    val b = BaseImpl(10)
    Derived(b).printMe() // ispisuje 10 - pristup printMe() metodi

    val a = BaseImpl(5)
    Derived(a).printMe()

}
