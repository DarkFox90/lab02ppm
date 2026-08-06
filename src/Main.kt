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
    val resultList: List<Any?> = listOf(30, false, "Carlos", true, null, 35.4)

    val result = processList(resultList)

    if (result != null) {
        for (element in result) {
            println(element)
        }
    }
}

fun processList(inputList: List<Any?>?): MutableList<ItemData>? {
    if (inputList == null) {
        return null
    } else if (inputList.isEmpty()) {
        return mutableListOf()
    }

    val resultList = mutableListOf<ItemData>()
    for ((index, item) in inputList.withIndex()) {
        if (item == null) {
            continue
        }
        val type: ElementType
        val info: String

        if (item is Int) {
            type = ElementType.ENTERO
            info =  if (item % 10 == 0 ) {
                "M10"
            } else if (item % 5 == 0) {
                "M5"
            } else if (item % 2 == 0) {
                "M2"
            } else {
                "-"
            }
        } else if (item is String) {
            type = ElementType.CADENA
            info = "L${item.length}"
        } else if (item is Boolean) {
            type = ElementType.BOOLEANO
            info = if (item) {
                "verdadero"
            } else {
                "falso"
            }
        } else {
            type = ElementType.DESCONOCIDO
            info = "desconocido"
        }
        resultList.add(ItemData(originalPos = index, originalValue = item, type = type, info = info))
    }
    return resultList
}