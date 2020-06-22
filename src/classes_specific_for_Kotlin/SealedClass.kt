package classes_specific_for_Kotlin

sealed class MyExample {

    class OP1 : MyExample()
    class OP2 : MyExample()

}

fun main (args: Array<String>) {

    val obj: MyExample = MyExample.OP2()

    val output = when(obj) {
        is MyExample.OP1 -> "Option One has been chosen"
        is MyExample.OP2 -> "Option Two has been chosen"
    }

    println(output)

}