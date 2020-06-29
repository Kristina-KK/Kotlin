package `interface`

import visibility_control.Person

interface PersonInfo  // validna impl interface-a u Kotlinu, može biti impl kao npr marker interface

interface PersonInfoProvider {

    // moguće je također dodati property-je u interface - property = varijabla / field
//    val providerInfo: String = "Default" // ovo je compiler error jer se ne može toj varijabli na ovaj način dodijeliti vrijednost
                                            // vrijednost se dodjeljuje na isti način na koji se inicijalizira metoda
    val providerInfo: String

    fun printInfo(person: Person)

    // primjer default metode u interfaceu
    fun printInfoDefault(person: Person) {
        println(providerInfo) // enkapsulacija prpperty-ja
        person.printInfo()
    }
}

interface SessionInfoProvider {
    fun getSessionId(): String
}

abstract class BasicInfo: PersonInfoProvider  // abstract klasa ne mora sadržavati implementaciju abstract metoda interface-a, normalna klasa mora

open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider { // open - ključna riječ - klase koje se mogu naslijediti moraju biti ovako označene

    override val providerInfo: String
        get() = "BasicInfoProvider"

    protected open val sessionIdPrefix = "Session"  // ključna riječ open na property-ju - oznaka da se može override-ati u klasi koja nasljeđuje ovu
                                                    // protected - u Koltinu je taj property vidljiv samo u klasama u kojima se nalazi i u onima koje nasljeđuju tu klasu

    /*
    za razliku od Jave (annotacija @Override), u Kotlinu je obavezan modifier override za metode koje su nasljeđene iz interface-a
     */
    override fun printInfo(person: Person) {
        println("basicInfoProvider")
        person.printInfo()
    }

    /*
    defaultnu metodu iz interface-a je moguće override-ati
     */
    override fun printInfoDefault(person: Person) {
        super.printInfoDefault(person)
        println("additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }

}

fun main() {
    val provider = BasicInfoProvider()
//    provider.printInfo(Person())

    provider.printInfoDefault(Person())
    provider.getSessionId()

//    provider.sessionIdPrefix    // zbog protected modifiera nije vidljivo ovdje jer je izvan klase

    checkTypes(provider)

}

fun checkTypes(infoProvider: PersonInfoProvider) {
    if(infoProvider !is SessionInfoProvider) {
        println("not a session info provider")
    } else {
        println("is a session info provider")
        (infoProvider as SessionInfoProvider).getSessionId()  // as je ključna riječ za cast
        infoProvider.getSessionId()                     // Kotlin kompajler ima ugrađen smart cast, pa ako je provjeren tip podatka nije potrebno eksplicitno cast-ati
    }
//    infoProvider.getSessionId() // npr ovo gdje nema provjere "is" javiti će compile error
}