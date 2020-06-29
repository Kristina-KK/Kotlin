package classes_specific_for_Kotlin

import java.util.*

/*
DATA CLASS

data klase omogućavaju kreiranje konciznih/sažetih imutabilnih tipova podataka
automatski se kreiraju metode equals, hashCode, toString
kao i getter i setter metode ovisno o tome da li se proslijeđuju val ili var kroz konstruktor
val - generirati će se samo getter (val je kao final u Javi)
var - generirati će se i getter i setter

== - usporedba da li su vrijednosti varijabli objekta jednaki
=== - usporedba referenci

 */

enum class EntityType2 {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

object EntityFactory2 {
    fun create(type: EntityType2): EntitySealedClass2 {
        val id = UUID.randomUUID().toString()
        val name = when (type) {
            EntityType2.EASY -> type.name
            EntityType2.MEDIUM -> type.getFormattedName()
            EntityType2.HARD -> "Hard"
            EntityType2.HELP -> type.getFormattedName()
        }
        return when(type) {
            EntityType2.EASY -> EntitySealedClass2.Easy(id, name)
            EntityType2.MEDIUM -> EntitySealedClass2.Medium(id, name)
            EntityType2.HARD -> EntitySealedClass2.Hard(id, name, 2f)
            EntityType2.HELP -> EntitySealedClass2.Help
        }
    }
}

// SEALED CLASS
sealed class EntitySealedClass2() {

    object Help : EntitySealedClass2() {
        val name = "Help"
    }

    // moguće je override-ati npr equals i hashCode
    data class Easy(val id: String, val name: String) : EntitySealedClass2() {

        override fun equals(other: Any?): Boolean {
            return super.equals(other)
        }

        override fun hashCode(): Int {
            return super.hashCode()
        }

    }


    data class Medium(val id: String, val name: String) : EntitySealedClass2()
    data class Hard(val id: String, val name: String, val multiplier: Float) : EntitySealedClass2()

}

fun main() {
    val entity1 = EntityFactory2.create(EntityType2.EASY)
    val entity2 = EntityFactory2.create(EntityType2.EASY)

    if(entity1 == entity2) {  // == usporedba da li su objekti jednaki, tj da li varijable objekata imaju iste vrijednosti
        println("they are equal")
    } else {
        println("they are not equal")
    }

    val entity1_1 = EntitySealedClass2.Easy("id", "name")
//    val entity1_2 = EntitySealedClass2.Easy("id", "name")
    val entity1_2 = entity1_1.copy()   // moguće koristiti za kopiranje objekta umjesto da se kreira isti takav novi objekt
//    val entity1_2 = entity1_1.copy(name = "New name")

    if(entity1_1 === entity1_2) {     // === usporedba referenci - neće biti jednako jer su to dva različita objekta u memoriji
        println("they are equal")
    } else {
        println("they are not equal")
    }

}