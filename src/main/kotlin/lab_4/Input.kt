package lab_4

// sealed - интерфейс запечатан (нужно по заданию)
sealed interface Input { // нужен для определения действий после ввода юзера
    
    companion object {
        // функция распределения
        fun parse(string: String): Input {
            val str: List<String> = string.split(" ") // из строки создает листинг "слов"
            // распределение по классам по следуюющим признакам
            return when { // вернуть когда 
                // размер листнга = 4, размер доски = 5, 3й строка - один символ -> класс, хранящий данные об игре
                str.size == 4 && Board.size == 5 && str[2].length == 1 -> Step(str[0].toInt(), str[1].toInt(),listOf(str[2], str[3])) // для балды
                // размер листнга = 2, первый символ = "-1" -> класс для возвращения хода
                str.size == 2 && str[0] == "-1" -> TakeBack(str[1].toInt())
                // размер листнга = 2, размер доски = 3 -> класс, хранящий данные об игре
                str.size == 2 && Board.size == 3 -> Step(str[0].toInt(), str[1].toInt()) // для ХО
                // если ничего не подходит
                else -> Exit
            }
        }
    }
}
