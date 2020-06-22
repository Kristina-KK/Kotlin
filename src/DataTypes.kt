fun main (args: Array<String>) {

    val finalVariable = 20
//    finalVariable = 10  // compile error - Val cannot be reassigned
    var variable = 30
    variable = 40


    // BROJEVI
    val a: Int = 1000
    val d: Double = 100.00
    val f: Float = 100.00f
    val l: Long = 1000000000000
    val s: Short = 10
    val b: Byte = 1

    println("Your Int Value is "+a);
    println("Your Double  Value is "+d);
    println("Your Float Value is "+f);
    println("Your Long Value is "+l);
    println("Your Short Value is "+s);
    println("Your Byte Value is "+b);

    // CHAR
    val letter : Char // definicija varijable
    letter = 'A'
    println("$letter")
    println(letter) // ispis moguć na više načina - vidi liniju iznad

    // BOOLEAN
    val isLetter : Boolean
    isLetter = true
    println("Character value is " + "$isLetter")
    println("Character value is " + isLetter)

    // STRINGS
    /*
    Stringovi su character arrays. Kao u Javi oni su immutable.
    U Koltinu postoje 2 verzije string-ova - raw String i escaped String
     */

    var rawString :String  = "I am Raw String!"
    val escapedString : String  = "I am escaped String!\n"

    println("Hello!"+escapedString)
    println("Hey!!"+rawString)

    // ARRAYS
    /*
    Primitivni tipovi arrays: ByteArray,  ShortArray, IntArray
    */
    val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)
    println("Hey!! I am array Example " + numbers[2])

}