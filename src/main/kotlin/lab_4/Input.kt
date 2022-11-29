package lab_4

// interface, как предварительный договор, содержит условия, которые будут в классе,
// но могут быть изменены

// сделать его закрытым!

// sealed? почему именно он?
sealed interface Input {
    companion object {
        fun parse(string: String): Input {
            val str: List<String> = string.split(" ")
            // распределение по функциям, по следуюющим действиям
            return when {
                /*ДОДЕЛАТЬ!*/
                str.size == 4 -> Step(str)
                str.size == 2 && str[0] == "-1" -> TakeBack()
                else -> Exit()
            }
        }
    }
}