package lab_4

// данные о ходе
class Step(s: List<String>) : Input {
    val x: Int = s[0].toInt()// сделать через сеттер

    val y: Int = s[1].toInt()

    // буква и образуемое слово
    val param: List<String> = listOf(s[2], s[3])

    val point: Point = Point(x, y)
}