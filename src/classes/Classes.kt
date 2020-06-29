package classes

class Person  // Klasa može biti definirana ovako bez {}

class Person1 constructor() // klasa Person je kraća forma ovakvog zapisa
class Person2 () // klasa Person se može definirati i ovako

class Person3(firstName: String, lastName: String) // kada je ovako definirano moraju biti proslijeđene vrijednosti u konstruktor kod instanciranja

class Person4(_firstName: String, _lastName: String) {
    val firstName: String      // PRAVILO - property mora biti abstract ili mora biti inicijaliziran u init bloku, ovdje ne može biti abstract zato što je to non-abstract klasa
    val lastName: String

    init { // init blok pokreće se svaki puta kada je pozvana instanca klase
        firstName = _firstName
        lastName = _lastName
    }

}

// ovakva impl zamjenjuje ovaj iznad init blok
class Person5(__firstName: String, __lastName: String) {
    val firstName: String = __firstName
    val lastName: String = __lastName
}

class Person6(val firstName: String, val lastName: String)

class Person7(val firstName: String, val lastName: String) { // primary konstruktor

    init {
        println("init 1")
    }

    constructor(): this("K", "KK") { // secondary konstruktor
        println("Secondary constructor")
    }

    init {
        println("init 2")
    }

}

// moguće je postaviti defaultne vrijednosti u primary konstruktoru
/*
kompajler automatski generira getter i setter ovisno o tome kako su označene varijable u konstruktoru - sa val ili var
ova klasa nema setter, ali ima getter zato što su joj varijable u primary konstruktoru označene sa val te su one samim time immutable
kada bi varijable bile označene sa var tada bi one imale svoje getter i setter metode
 */
class Person8(val firstName: String = "KK", val lastName: String = "KK") {
    var nickName: String? = null
        set(value) {  // set se koristi kada se želi napraviti dodatna logika za setter il ije korisno kada se želi dodati ispis u svrhu debugiranja
            field = value // filed je ključna riječ
            println("the new nickname is $value")
        }
        get() {
            println("the returned value is $field")
            return field
        }

    fun printInfo() {
        println("$firstName ($nickName) $lastName")

        // bolja impl ispisa
        val nickNameToPrint = if(nickName != null) nickName else "no nickname"
        println("$firstName ($nickNameToPrint) $lastName")

        val nickNameToPrint2 = nickName ?: "no nickname"      // Elvis operator zamjenjuje if-else
        println("$firstName ($nickNameToPrint2) $lastName")

    }
}


fun main() {
    val person = Person()
    val person1 = Person1()
    val person2 = Person2()

    val person3 = Person3("Kristina", "KK")
//    person3.firstName    // ovo se ne kompajlira - da bi se moglo pristupati tim varijablama klase mora se napraviti impl kao Person4/Person5/Person6
//    person3.lastName

    val person3_1 = Person3(firstName = "Kristina", lastName = "KK")

    val person4 = Person4(_firstName = "Kristina", _lastName = "KK")

    val person5 = Person5("Kristina", "KK")
    person5.firstName   // sintaksa za pristup property-ju - nema get i set metoda kao u Javi - automatski impl
    person5.lastName

    val person6 = Person6("Kristina", "KK")
    person6.firstName
    person6.lastName

    println("-------------------")
    val person7 = Person7()  // ne kompajlira se bez secondary konstruktora - ovo u je primjer poziva secondary konstruktora
                            //  kod se izvršava ovim redoslijedom -> 1. svi init blokovi po redoslijedu kako su navedeni 2. poziv secondary konstruktora

    println("-------------------")
    val person7_1 = Person7("KK", "KK2") // poziv primary konstruktora

    val person8 = Person8()
    person8.firstName
    person8.lastName
    person8.nickName = "KIKI"
    person8.nickName = "KIKA"

    println("-------------------")
    val person8_1 = Person8()
    person8_1.printInfo()

}