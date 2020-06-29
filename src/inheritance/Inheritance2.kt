package inheritance

import `interface`.BasicInfoProvider
import visibility_control.Person

// klase su u Kotilnu defaultno final
open class BasicInfo { // da bi se klasa mogla naslijediti mora imati ključnu riječ open
}

class FancyInfoProvider : BasicInfoProvider() {

    // ovaj property je iz klase BasicInfoProvider i tamo mora biti označen ključnom riječi open
    override val sessionIdPrefix: String
        get() = "Fancy Session"

    // override-an property iz interface-a -> vidi u klasi BasicInfoProvider on nema oznaku open -> klasa BasicInfoProvider ga je override-ala iz interface-a PersonInfoProvider
    override val providerInfo: String
        get() = "Fancy Info Provider"

    // override-an metoda iz superklase
    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Fancy info")
    }

}

fun main() {

    val provider = FancyInfoProvider()
    provider.printInfo(Person())
    provider.getSessionId()
//    provider.sessionIdPrefix      // zbog protected modifiera nije vidljivo ovdje jer je ova funkcija izvan FancyInfoProvider klase
                                    // a property je definiran protected u BasicInfoProvider klasi



}