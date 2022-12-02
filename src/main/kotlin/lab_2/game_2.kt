import java.io.BufferedReader
import java.io.InputStream
import java.io.PrintStream

val outputConsole: PrintStream = PrintStream(System.out, true, "UTF-8")
val boardSize = 3
var board = Array(boardSize) { arrayOf(' ', ' ', ' ') }
var currentIndex = 0
val game = ArrayList<Array<Array<Char>>>()

fun main() {
    game()
}

fun Array<Array<Char>>.print(out: PrintStream = outputConsole) {
    out.print("  012\n")
    for (i in 0..2) {
        out.print("$i ")
        for (j in 0..2) {
            out.print(this[i][j])
        }
        out.print("\n")
    }
}

fun Array<Array<Char>>.checkWin(): Char {
    val winLines = arrayOf(
        arrayOf(arrayOf(0, 0), arrayOf(0, 1), arrayOf(0, 2)),
        arrayOf(arrayOf(1, 0), arrayOf(1, 1), arrayOf(1, 2)),
        arrayOf(arrayOf(2, 0), arrayOf(2, 1), arrayOf(2, 2)),
        arrayOf(arrayOf(0, 0), arrayOf(1, 0), arrayOf(2, 0)),
        arrayOf(arrayOf(0, 1), arrayOf(1, 1), arrayOf(2, 1)),
        arrayOf(arrayOf(0, 2), arrayOf(1, 2), arrayOf(2, 2)),
        arrayOf(arrayOf(0, 0), arrayOf(1, 1), arrayOf(2, 2)),
        arrayOf(arrayOf(0, 2), arrayOf(1, 1), arrayOf(2, 0))
    )
    for (i in 0..7) {
        if (this[winLines[i][0][0]][winLines[i][0][1]] != ' ' && this[winLines[i][0][0]][winLines[i][0][1]] == this[winLines[i][1][0]][winLines[i][1][1]] && this[winLines[i][2][0]][winLines[i][2][1]] == this[winLines[i][1][0]][winLines[i][1][1]]) {
            return this[winLines[i][0][0]][winLines[i][0][1]]
        }
    }
    return 'N'
}

fun Array<Array<Char>>.isFill(): Boolean {
    for (i in 0..2) {
        for (j in 0..2) {
            if (this[i][j] == ' ')
                return true
        }
    }
    return false
}

fun String.pointFromString(): Pair<Int, Int>? {
    val arr = this.split(' ')
    if (arr.size == 1) {
        val z = arr[0].toIntOrNull() ?: return null
        return Pair(-1, z)
    } else {
        val x = arr[0].toIntOrNull() ?: return null
        val y = arr[1].toIntOrNull() ?: return null
        return Pair(x, y)
    }
}

fun Array<Array<Char>>.isRightMove(point: Pair<Int, Int>): Boolean {
    return ((point.first in 0..2) && (point.second in 0..2) && this[point.second][point.first] == ' ')
}

fun Array<Array<Char>>.get(point: Pair<Int, Int>): Char {
    return this[point.second][point.first]
}

fun Array<Array<Char>>.get(point: Array<Int>): Char {
    return this[point[1]][point[0]]
}

fun Array<Array<Char>>.set(point: Pair<Int, Int>, char: Char) {
    this[point.second][point.first] = char
}

fun Array<Array<Char>>.copy(): Array<Array<Char>> {
    return Array(3) { i -> Array(3) { j -> this[i][j] } }
    //      ящик                корзина             яблоки
    // a.copy() - текущее поле
    // game: ArrayList<Array<Array<Char>>>
    // game.add(a.copy()) - история полей
    // game.add(a) - запись адреса "а"
    // + clone - массив адресов элементов а
    // board = game[i]
}

fun Pair<Int, Int>.isCommand(): Boolean {
    return (this.first == -1 && (this.second in 0 until currentIndex || this.second == -2))
}

//fun Array<Array<Char>>.a(){
//    for (i in 0..2)
//        for (j in 0..2)
//            if (this[i][j] == ' ')
//                println("$j,$i")
//}

fun game(input: InputStream = System.`in`, out: PrintStream = outputConsole) {

    val reader = BufferedReader(input.reader())
    val symbols = arrayOf('X', '0')

    game.add(board.copy())
    var point: Pair<Int, Int>
    while (board.isFill() && board.checkWin() == 'N') {
        print("Ход: $currentIndex\n")
        // a = ArrayList<Array<Array<Char>>>
        // a.add(<Array<Array<Char>>> = b)
        // a.add(b.copy())
        // copy { f <- b }
//        val f1 = board.get(point) // первая
//        val f2 = board.get(arrayOf(0, 1)) // вторая
//        val f3 = board.get(arrayOf(point.first, point.second)) // вторая
        var tf = true
        do {
            if (!tf) {
                out.print("Введены не верные координаты!\n")
                print("Попробуйте еще раз.\n")
            }
            print("Игрок_${symbols[(currentIndex) % 2]}, введите координаты или команду\n")
            point = reader.readLine().pointFromString()!!
//            if (point.first == -2 && point.second == null) break
            tf = false
        } while (!(point.isCommand() || board.isRightMove(point)))

//        if (point.first == -1 && point.second == -2) //board.a()
//        else {
        if (point.first == -1) {
            if (point.second == -2) {
//                point.second = 0
                board = game[0]
                currentIndex = 0
            } else {
                board = game[point.second]
                currentIndex = point.second
            }
        } else {
            board.set(point, symbols[(currentIndex) % 2])
            currentIndex++
        }
        board.print()
//        board.a()
        if ((game.size - 1) > currentIndex)
            game[currentIndex] = board.copy()
        else
            game.add(board.copy())
//        }
    }
    if (board.checkWin() == 'N')
        out.print("Ничья!")
    else
        out.print("Игрок_${board.checkWin()} - победитель!")
}
