package classes_specific_for_Kotlin

fun main (args: Array<String>) {

    val book: Book = Book("Kotlin", "TutorialPoint.com", 5)
    println("Name of the Book is -- " + book.name)
    println("Publisher name is -- " + book.publisher)
    println("Review of the book is -- " + book.reviewScore)

    book.reviewScore = 7
    println("Printing all the info all together -- " + book.toString()) // koristi se ugrađena funkcija u Kotlin - nije potrebno kao u Javi dodavati impl toString()

    println("Example of the hashCode function-- " + book.hashCode())

    val book2: Book2 = Book2("Book2", book)
    println(book2) // toString() ugrađena metoda ispisuje sve objekte

}

data class Book(val name: String, val publisher: String, var reviewScore: Int)

data class Book2(val name: String, val book: Book)

data class Book3(val reviewScore: Int) // data klasa mora imati barem jedan primary konstruktror s barem jednim parametrom