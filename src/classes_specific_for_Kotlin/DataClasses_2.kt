package classes_specific_for_Kotlin

fun main(args: Array<String>) {

    val dataClass : DataClass = DataClass() // ako je u data klasi u primary konstruktoru defaultno postavljena varijabla tada se klasa može instancirati ovako DataClass()
    println(dataClass)  // ispisati će se samo ono što je u primary konstruktoru

    println(dataClass.var2) // ugrađena toString() metoda ispisuje samo ono što je u postavljeno kroz primary konstruktor

    val dataClass2 = DataClass_2(15) // nije postavljena defaultna vrijednost
    println(dataClass2)

    val dataClass3 = DataClass_3() // defaultna vrijednost je postavljena pa se može ovako koristiti
    println(dataClass3)

}



data class DataClass(val test: String? = null, val test2: String = "defaultna vrijednost") {
    var var1: Boolean? = null
    var var2: String? = "Primjer data klase"
}

data class DataClass_2(val test: Int)

data class DataClass_3(val test: Int = 10)




