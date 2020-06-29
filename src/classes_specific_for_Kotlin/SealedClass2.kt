package classes_specific_for_Kotlin

import enum_classes.Entity2
import java.util.*

/*
SEALED CLASS
omogućava definiranje 1 klase koja je kao super klasa ostalim klasama
 */

enum class EntityType {
    HELP, EASY, MEDIUM, HARD;  // enum klasa mora imati , i ; na kraju zadnje enum prije deklaracije metode -> isto kao u Javi

    fun getFormattedName() = name.toLowerCase().capitalize()  // name - defaultno ugrađena varijabla za ime enum u Kotlin-u
}

object EntityFactory {
    fun create(type: EntityType): EntitySealedClass {
        val id = UUID.randomUUID().toString()
        val name = when (type) {
            EntityType.EASY -> type.name
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.getFormattedName()
        }
        return when(type) {
            EntityType.EASY -> EntitySealedClass.Easy(id, name)
            EntityType.MEDIUM -> EntitySealedClass.Medium(id, name)
            EntityType.HARD -> EntitySealedClass.Hard(id, name, 2f)
            EntityType.HELP -> EntitySealedClass.Help    // PRAVILO: ovo se neće kompajlirati ako nije Help objekt ne nasljeđuje klasu EntitySealedClass()
        }
    }
}

// SEALED CLASS
sealed class EntitySealedClass() {    // definicija tog tipa klase mora biti označena ključnom riječi sealed

    object Help : EntitySealedClass() {  // ovaj objekt mora nasljeđivati klasu EntitySealedClass() da bi se mogao koristiti kao EntitySealedClass.Help
        val name = "Help"
    }

    data class Easy(val id: String, val name: String) : EntitySealedClass()
    data class Medium(val id: String, val name: String) : EntitySealedClass()
    data class Hard(val id: String, val name: String, val multiplier: Float) : EntitySealedClass()

}

fun main() {
    val entity : EntitySealedClass = EntityFactory.create(EntityType.HELP)
    val msg = when(entity) {
        EntitySealedClass.Help -> "help class"
        is EntitySealedClass.Easy -> "easy class"
        is EntitySealedClass.Medium -> "medium class"
        is EntitySealedClass.Hard -> "hard class"
    }

    println(msg)

}