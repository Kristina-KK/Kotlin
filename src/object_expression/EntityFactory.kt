package object_expression

class Entity2 (val id: String) // ovakav primary konstruktor može biti označen kao private constructor

interface IdProvider {
    fun getId() : String
}

class Entity private constructor(val id: String) {
//    companion object {
//        fun create() = Entity("id")
//    }

    /*
    PRAVILO: samo jedan companion objekt može biti u klasi
     */

    companion object Factory : IdProvider {  // companion object može implementirati interface kao bilokoja druga klasa

        const val id = "id"   // moguće je dodati property-je u companion objekt

//        fun create() = Entity(id)
        fun create() = Entity(getId())

        override fun getId(): String {
            return "123"
        }
    }

}

fun main() {
//    val entity1 = Entity.Companion.create()   // kreiranje instance klase Entity -> kada companion objekt nema svoj naziv kao "Factory"
    val entity = Entity.create()   // isto kao linija iznad samo kraći način zapisa
    val entity2 = Entity.Factory.create()

    Entity.id // property companion objekta moguće je pozvati kao static u Javi

}