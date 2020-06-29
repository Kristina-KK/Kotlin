package advanced_functions

// funkcija prima parametar predicate koji je funkcija koja prima String i vraća Boolean
fun printFilteredStrings(list: List<String>, predicate: (String) -> Boolean) {
    list.forEach {
        if(predicate(it)) {
            println(it)
        }
    }
}

fun printFilteredStrings2(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach {
        if(predicate?.invoke(it) == true) {    // safe invoke call on the predicate function
            println(it)
        }
    }
}

val predicate: (String) -> Boolean = {
    it.startsWith("J")
}

// funkcija koja ima return tip funkciju koja prima String i vraća Boolean
fun getPrintPredicate() : (String) -> Boolean {
    return { it.startsWith("J") }
}

fun main() {

    val list = listOf("Kotlin", "Java", "C++", "Javascript")

    // funkcija je drugi parametar koji se proslijeđuje na način da se specificira lambda
    printFilteredStrings(list, {it.startsWith("K")})

    // lambda se može specificirati i ovako u {} -> vidi kako izgleda forEach implementacija metode u Kotlinu - isti način impl kao i ovaj ovdje
    // specificirana lambda funkcija izvršiti će se nad svakim string podatkom s liste
    printFilteredStrings(list) {
        it.startsWith("K")
    }

    printFilteredStrings2(list, null)  // neće se vratiti niti jedan podatak


    println("------------------------------")

    val list2 = listOf("Kotlin", "Java", "C++", "Javascript", null, null)
    list2
        .filterNotNull()
        .filter {
            it.startsWith("J")    // ako lista sadrži null podatke ovaj dio se neće kompajlirati bez metode iznad
        }
        .map {                // bez funkcije map ispisuju se svi String podaci s liste
            it.length          // s ovom map funkcijom ispisuju se sve duljine String podataka s liste
        }
        .forEach{
            println(it)
        }

    println("------------------------------")

    list2
        .filterNotNull()
        .take(3)      // ispis prvih 3 elementa s liste
        .forEach{
            println(it)
        }

    println("------------------------------")

    list2
        .filterNotNull()
        .takeLast(3)      // ispis zadnja 3 elementa s liste - zbog metode iznad ne uzima u obzir null vrijednosti
        .forEach{
            println(it)
        }

    println("------------------------------")

    list2
        .filterNotNull()
        .associate { it to it.length }      // povezivanje podataka i ispis u obliku mape
        .forEach{
            println("${it.value}, ${it.key}")
        }

    println("------------------------------")

    val map = list2
        .filterNotNull()
        .associate { it to it.length }      // povezivanje podataka i dodavanje u mapu [key to value]

    println(map)

    println("------------------------------")

    val language = list2.first()
    println(language)

    var languageLast = list2.last()
    println(languageLast)

    languageLast = list2.filterNotNull().last()
    println(languageLast)

    println("------------------------------")

    var findSpecific = list2.filterNotNull().find{ it.startsWith("Java") }
    println(findSpecific)

    findSpecific = list2.filterNotNull().find{ it.startsWith("foo") }
    println(findSpecific)

    findSpecific = list2.filterNotNull().find{ it.startsWith("foo") }.orEmpty()   // ako se pozove funkcija orEmpty u slučaju da nema tog podatka na listi
                                                                                        // ispisati će se prazan string
    println(findSpecific)

}