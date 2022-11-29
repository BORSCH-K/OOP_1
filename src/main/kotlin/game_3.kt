package lab_3

import java.io.BufferedReader
import java.io.InputStream
import java.io.PrintStream

val outputConsole: PrintStream = PrintStream(System.out, true, "UTF-8")

fun Array<Array<Char>>.copy(): Array<Array<Char>> {
    return Array(3) { i -> Array(3) { j -> this[i][j] } }
}
fun game(inputStream: InputStream = System.`in`, output: PrintStream = outputConsole) {
    val reader = BufferedReader(inputStream.reader())

    val game = Game()

    var finish = false
    output.print(game) // выведет override game
//    println(game.state.turn)
    do {
        output.print("Ваш ход или команда\n")
//        print(game.states[0])
        val arr = reader.readLine().split(" ")
//        println(arr.size)
        if (arr.size !=2 )
            finish = true
        else {
            val x = arr[0].toIntOrNull()
            val y = arr[1].toIntOrNull()
            if (x == null || y == null)
                output.print("Неверные координаты или команда\n")
            else {
                // команда
                if (x == -1) {
                    if (game.takeBack(y)) { // возвращение
//                        game.indexState++
                        output.print(game) // вывод поля?


                    }
                    else
                    output.print("Неправильная команда\n")
                }
                // обычный ход
                else {
//                    println("aaaaaaaaaa")
//                        println("old i: "+game.indexState)
                    if (game.step(Point(x, y))) {
                        output.print(game)
//                        println("new i: "+game.indexState)
                    } else
                        println("Клетка занята!")
                }
            }
            for (i in 0 .. game.indexState)
            print("i = $i\n"+game.states[i].board)
        }
    } while (!finish && !game.gameOver)
//    println("bbbbbbbb")
//    print(game.states[0])
//    print(game.states[1])
//    print(game.states[2])
}

fun main() {
    game()
}