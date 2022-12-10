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
    val startWord = "balda"
    val game = MultiGame(StateBalda(startWord))
    print(game)
    while (!game.gameOver) {
        val reader = BufferedReader(inputStream.reader()).readLine()
        when (val G = Input.parse(reader)){
            is Exit -> {
                out.print("Exit\n")
                break
            }
            is Step -> if (game.step(G)) print("") else out.print("Error\n")
            is TakeBack -> if (game.takeBack(G.shift)) out.print("RETURN:\n") else out.print("Error\n")
        }
        print(game)
    }
    if (game.gameOver) out.print("Игра окончена!\n")
}
//    out.print("Слова игроков:\n")
//    while (game.state.words1){
//    if (game.gameOver)
//        print(game.state.gameResult)
//    else
//    print(game.state.endGame)
//    }
