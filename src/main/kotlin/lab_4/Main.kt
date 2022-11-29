package lab_4

import java.io.BufferedReader
import java.io.InputStream
import java.io.PrintStream

val outputConsole: PrintStream = PrintStream(System.out, true, "UTF-8")

fun main() {
    Board.size = 5
    game()
}

fun game(inputStream: InputStream = System.`in`, out: PrintStream = outputConsole) {

    // для балды
//    if (Board.size == 5) {
    val game = MultiGame(StateBalda("12345")) // ?????
//    }
//    else {
//        val game = MultiGame(StateXO())
//    }

//        print("Введиет начальное слово: ")
//        val reader = BufferedReader(inputStream.reader())
    // вызвать функцию для начального ввода слова!!! (функция: _____)


    while (!game.gameOver) {
        val reader = BufferedReader(inputStream.reader()).readLine()
        Input.parse(reader)

        // вызов функции для установки параметров

        // ввод коодинат, буквы, слова
        // провекра |^|
        // новое состояние поля
        // проверка на выигрыш

    }
}
