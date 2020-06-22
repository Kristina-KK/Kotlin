package generics

fun main (args: Array<String>) {
    val integer: Int = 1
    val number: Number = integer  // Int je subklasa od Number
    println(number)

    val obj = genericsExample<String>("JAVA")
    val obj2 = genericsExample<Int>(10)

    val obj3 = genericsExample2<Int>(10)
    val obj4 = genericsExample2<Double>(10.0)

    println(obj3)
    println(obj4)

    val obj5 = genericsExample3<Number>(10)
    val obj6 = genericsExample3<Number>(10.0)

}

class genericsExample<T> (input: T) {
    init {
        println("I am getting called with the value " + input)
    }
}

class genericsExample2<out T> (input: T) {
    init {
        println("Input " + input)
    }
}

class genericsExample3<in T> (input: T) {
    init {
        println("Input " + input)
    }
}