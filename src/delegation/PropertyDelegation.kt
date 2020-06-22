package delegation

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

// lazy()
/*
Lazy je lambda funkcija koja uzima property kao input i vraća instancu Lazy<T> gdje je <T> bazično tip property-ja koji se koristi
 */
val myVar: String by lazy {
    "Hello"
}

fun main(args: Array<String>) {
    println(myVar + " My dear friend")

    val user = User()
    user.name = "first"
    user.name = "second"

}

// observable
/*
Observable uzima dva argumenta za inicijalizaciju objekta i isti vraća u pozvanu funkciju
 */
class User {
    var name: String by Delegates.observable("Welcome to TutorialsPoint.com") {
        prop, old, new ->
        println("$old -> $new")
    }
}

// **************************************************
class Example {
    var p: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '{$property.name}' in $thisRef")
    }
}