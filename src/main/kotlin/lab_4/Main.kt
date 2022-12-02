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
    val startWord = "balda"
    val game = MultiGame(StateBalda(startWord)) // ?????
    print(game)

    while (!game.gameOver) {
        val reader = BufferedReader(inputStream.reader()).readLine()
        when (val G = Input.parse(reader)){
            is Exit -> print("Exit\n")
            is Step -> if (game.step(G)) print("") else print("Error\n")
            is TakeBack -> game.takeBack(G.shift)
        }
        print(game)
    }
}
