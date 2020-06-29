package enum_classes

import java.util.*

enum class EntityType {
    EASY, MEDIUM, HARD;  // enum klasa mora imati , i ; na kraju zadnje enum prije deklaracije metode -> isto kao u Javi

    fun getFormattedName() = name.toLowerCase().capitalize()  // name - defaultno ugrađena varijabla za ime enum u Kotlin-u
}

object EntityFactory2 {
    fun create(type: EntityType): Entity2 {
        val id = UUID.randomUUID().toString()
        val name = when (type) {
            EntityType.EASY -> type.name
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
        }
        return Entity2(id, name)
    }
}

class Entity2 (val id: String, val name: String) {
    override fun toString(): String {
        return "id: $id name: $name"
    }
}

fun main() {
    val entity2 = EntityFactory2.create(EntityType.EASY)
    println(entity2)

    val mediumEntity2 = EntityFactory2.create(EntityType.MEDIUM)
    println(mediumEntity2)



}