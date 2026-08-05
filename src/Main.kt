data class ItemData(
    val originalPos: Int,
    val originalValue: Any?,
    val type: ElementType,
    val info: String
) {
    override fun toString(): String {
        return "'$originalValue' estaba en la posición $originalPos, es de tipo $type e info es $info".lowercase()
    }
}

enum class ElementType {
    CADENA,
    ENTERO,
    BOOLEANO,
    DESCONOCIDO
}

fun main() {
    val result = processList(listOf(1, false))
    println("hola")
}

fun processList(inputList: List<Any?>?): MutableList<ItemData>? {
    if (inputList == null) {
        return null
    } else if (inputList.isEmpty()) {
        return mutableListOf()
    }

    for (item in inputList) {
        if (item is Int) {
            if (item % 10 == 0 ) {
                println("M10")
            } else if (item % 5 == 0) {
                println("M5")
            } else if (item % 2 == 0) {
                println("M2")
            } else {
                println("-")
            }
        } else if (item is String) {
            println("L" + item.length)
        } else if (item is Boolean) {
            if (item == true) {
                println("verdadero")
            } else {
                println("falso")
            }
        } else {
            println("desconocido")
        }

    }
}