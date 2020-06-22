package extensions

class Alien {

    var skills: String = "null"

    fun printMySkills() {
        print(skills)
    }

}

fun main (args: Array<String>) {

    var a1 = Alien()
    a1.skills  = "JAVA"

    var a2 = Alien()
    a2.skills = "SQL"

    var a3 = Alien()
    a3.skills = a1.addMySkills(a2)
    a3.printMySkills()

}

// EKSTENZIJA FUNKCIJE - može biti definirana bilogdje u file-u, ne mora biti unutar Alien metode
fun Alien.addMySkills(a: Alien) : String {
    var a4 = Alien()
    a4.skills = this.skills + " " + a.skills
    return a4.skills
}