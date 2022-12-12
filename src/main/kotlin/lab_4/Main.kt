package lab_4

import java.io.BufferedReader
import java.io.InputStream
import java.io.PrintStream

var outputConsole: PrintStream = PrintStream(System.out, true, "UTF-8")
fun main() {
    Board.size = 5 // балда
    game()
}

/*Код для балды, чтобы переключить на "крестики-нолики", требуется
закомментить балду (// балда) и раскомменчить крестики-нолики (// "крестики-нолики")*/

fun game(inputStream: InputStream = System.`in`, out: PrintStream = outputConsole) {
    val reader = BufferedReader(inputStream.reader())
    val startWord = "balda"                     // балда
    val game = MultiGame(StateBalda(startWord)) // балда
//    val game = MultiGame(StateXO(turn = '0')) // "крестики-нолики"
    out.print(game)
    while (!game.gameOver) {
        when (val i = Input.parse(reader.readLine())) {
            is Exit -> {
                out.print("Exit\n")
                break
            }

            is Step -> {
                if (game.step(i)) print("")
                else {
                    out.print("Error\n")
                    continue
                }
            }

            is TakeBack -> {
                if (game.takeBack(i.shift)) out.print("RETURN:\n")
                else out.print("Error\n")
            }
        }
        out.print(game)
    }
    if (game.gameOver) out.print("Игра окончена!\n")
}
