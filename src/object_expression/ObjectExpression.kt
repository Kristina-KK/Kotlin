package object_expression

import `interface`.PersonInfoProvider
import visibility_control.Person

fun main() {

    // kao anonimne klase u Javi, u Kotlinu se to zove Object Expression -> implementacija interface-a je u vitičastim zagradama
    val provider = object : PersonInfoProvider { // mora se implementirati sve ono što je abstract u PersonInfoProvider interface-u, npr default metoda ne

        override val providerInfo: String
            get() = "New Info Provider"

        override fun printInfo(person: Person) {
           person.printInfo()
        }

        // mogu se dodavati implementacije novih metoda
        fun getSessionIdNewMethod() = "id"

    }

    provider.printInfo(Person())
    provider.getSessionIdNewMethod()

}