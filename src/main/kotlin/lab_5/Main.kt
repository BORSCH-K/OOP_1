package lab_5

import java.io.BufferedReader
import java.io.InputStream
import java.io.PrintStream

var outputConsole: PrintStream = PrintStream(System.out, true, "UTF-8")
fun main() {
//    Board.size = 5 // балда
    game()
}

fun game(inputStream: InputStream = System.`in`, out: PrintStream = outputConsole) {
    val reader = BufferedReader(inputStream.reader())
//    val startWord = "balda"                     // балда
//    val game = EGame(EStateBalda(startWord)) // балда
    val game = EGame(EStateXO(turn = Turn.O)) // "крестики-нолики"
//    val game = MultiGame(StateXOTemp(turn = '0')) // проигрыш
    out.print(game)
    while (!game.gameOver) {
        try {
            when (val i = Input.parse(reader.readLine())) {
                is Exit -> {
//                    out.print("Exit\n")
                    throw GameException("Exit")
                }

                is Step -> game.step(i)
                is TakeBack -> game.takeBack(i.shift)
                is NewGame -> game.newGame()
                else -> {}
            }
        } catch (e: GameException) {
            out.print(e.message+"\n")
        }

        out.print(game) // ***
    }
}

