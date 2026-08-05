data class ItemData(
    val originalPos: Int,
    val originalValue: Any?,
    val type: ElementType,
    val info: String
)

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
    val listaMutable = mutableListOf(1,2,3,4,5)
    return null
}