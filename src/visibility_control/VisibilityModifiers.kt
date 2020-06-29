package visibility_control

public class Person3         // public - nepotreban modifier jer je class defultno public
internal class Person1      // internal - vidljivo u istom modulu
private class Person2      // private - dostupno u istom file-u u kojem je implementirana ta klasa



class Person(val firstName: String = "Kristina", val lastName: String = "KK") {

    private var var1: String? = null    // vidljivo samo u ovoj klasi
    internal var var2: String? = null   // vidljivo u istom modulu
    protected var var3: String? = null  // vidljivo u ovoj klasi i u klasama koje nasljeđuju ovu klasu - nije vidljivo čak ni u ovom file-u u drugoj metodi

    var nickName: String? = null
        set(value) {
            field = value
            println("the new nickname is $value")
        }
        get() {
            println("the returned value is $field")
            return field
        }

    fun printInfo() {
        val nickNameToPrint = nickName ?: "no nickname"     // Elvis operator
        println("$firstName ($nickNameToPrint) $lastName")
    }

}

fun main () {
    var person = Person3()
}

