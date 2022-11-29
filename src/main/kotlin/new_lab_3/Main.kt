package new_lab_3

import java.io.BufferedReader
import java.io.InputStream
import java.io.PrintStream

val outputConsole: PrintStream = PrintStream(System.out, true, "UTF-8")

fun main() {
    game()
}

fun game(inputStream: InputStream = System.`in`, out: PrintStream = outputConsole) {
    val reader = BufferedReader(inputStream.reader())
    val game = Game()
    var finish = false
    out.print(game) // вывод доски
    do {
        out.print("Ваш ход или команда\n")
        val arr = reader.readLine().split(" ")
        if (arr.size != 2) // проверка на размер входных данных
            finish = true
        else {
            val x = arr[0].toIntOrNull()
            val y = arr[1].toIntOrNull()
            if (x == null || y == null) // проверка правильности хода
                out.print("Неверные координаты или команда\n")
            else {
                if (x == -1) // если это команда
                    // ввод команды: -1 "номер хода"
                    if (game.takeBack(y)) // возвращение на этот номер
                        out.print(game) // вывод доски
                    else
                        out.print("Неправильная команда\n")
                else // обычный ход
                    if (game.step(Point(x, y))) // если ход верен (по правилам игры)
                        out.print(game) // вывод доски
            }
        }
    } while (!finish && !game.gameOver) // пока игра идет - игра идет
}
