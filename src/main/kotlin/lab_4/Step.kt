package lab_4

// данные о ходе
class Step(val x: Int, val y: Int, // координаты
    // буква и образуемое слово
    val param: List<String> = listOf()
) : Input {
    val point: Point = Point(x, y)
}
