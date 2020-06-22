package destructing_declarations

fun main(args: Array<String>) {
    val s = Student("Tutorial", "Kotlin")
    val (name, subject) = s

//    val (ispis1, ispis2) = s // ime varijabli u zagradama nije povezano s imenima u objektu Student - može biti i ovako

    println("You are learning " + subject + " from " + name)

//    println("You are learning " + s.subject + " from " + s.name) // da nema linije koda val (name, subject) = s tada bi se trebalo pozivati ovako npr s.subject
//    println("You are learning " + s.a + " from " + s.b) // da nema u {} Studenta subject i name - tada poziv ide ovako
}

data class Student(val a: String, val b: String) {
    // ovaj dio ovdje je opcionalan - ne utječe na -> val (name, test) = s
    var name: String = a
    var subject: String = b
}