package lab_5

// interface, как предварительный договор, содержит условия, которые будут в классе,
// но могут быть изменены

// сделать его закрытым!
// sealed? почему именно он?

sealed interface Input {
    companion object {
        fun parse(string: String): Input {
            val str: List<String> = string.split(" ")
            // распределение по функциям, по следуюющим признакам
            return when {
                str.size == 4 && Board.size == 5 && str[2].length == 1 -> // для балды
                    Step(str[0].toInt(), str[1].toInt(),listOf(str[2], str[3]))
                str.size == 2 && str[0] == "-1" -> TakeBack(str[1].toInt())
                str.size == 2 && Board.size == 3 -> Step(str[0].toInt(), str[1].toInt()) // для ХО
                str.size == 1 && str[0] == "0" -> NewGame
                else -> Exit
            }
        }
    }
}