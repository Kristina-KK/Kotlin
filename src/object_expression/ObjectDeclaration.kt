package object_expression

/*
Umjesto dodavanja comanion objekta u klasu Entity_ObjDecl moguće je ovako kreirati taj isti objekt
 */
object EntityFactory {
    fun create() = Entity_ObjDecl("id", "name") // za ovakvu impl treba maknuti private constructor oznaku
}

class Entity_ObjDecl(val id: String, val name: String) {

//    companion object Factory {
//        fun create() = Entity_ObjDecl("id")
//    }

    override fun toString(): String {
        return "id: $id name: $name"
    }

}

fun main() {

    val entity = EntityFactory.create() // poziva se kao statička metoda u Javi samo nad objektom - deklarirano object
    println(entity)

}