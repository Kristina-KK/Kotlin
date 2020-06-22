package functions

fun main(args: Array<String>) {
    println(MyFunction("tutorialsPoint.com"))

    // lambda funkcija
    /*
    bazična lambda funkcija
     */
    val myLambda: (String) -> Unit = {s: String -> println(s)}
    val v: String = "BASIC - TutorialsPoint.com"

    myLambda(v) // poziv bazične lambda funkcije

    val v2: String = "lambda kao parametar"
    myFun(v2, myLambda) // prosljeđivanje lambda funkcije kao parametra

}

fun MyFunction(x: String) : String {
    var c: String = "Hey!! Welcome To --- "
    return (c+x)
}

// inline funkcija
/*
inline funkcija omogućava da se lambda funkcija proslijedi kao parametar nekoj drugoj funkciji
 */
fun myFun(a: String, action: (String) -> Unit) {
    println("Heyyy!!!")
    action(a)
}