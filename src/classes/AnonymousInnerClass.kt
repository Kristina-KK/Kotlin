package classes

import java.io.File

fun main (args: Array<String>) {
    var programmer : Human = object: Human { // kreiranje instance interface-a
        override fun think() { // override metode definirane u interface-u
            print("I am an example of Anonymous Inner Class")
        }
    }

    programmer.think();

}

interface Human {
    fun think()
}


// TYPE ALIASES
/*
neasted & type aliases - ne kompajlira se unutar metode i klase

koristi se za kompleksne tipove podataka
 */
fun typeAliases() {
//    typealias FileTable<K> = MutableMap<K, MutableList<File>>  // !!!
}

typealias NodeSet = Set<File>
typealias FileTable<K> = MutableMap<K, MutableList<File>>