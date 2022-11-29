//import java.io.BufferedReader
//import java.io.InputStream
//import java.io.PrintStream
//
//val outputConsole: PrintStream = PrintStream(System.out, true, "UTF-8")
////val outputBuffer = ByteArrayOutputStream()
////val output = PrintStream(outputBuffer)
//
//fun main(){
//    game()
//}
//
//fun printBoard(board: Array<Array<Char>>, out: PrintStream = outputConsole) {
////    out.print(board)
//    out.print("  012\n")
//    for (i in 0..2) {
//        out.print("$i ")
//        for (j in 0..2) {
//            out.print(board[i][j])
//        }
//        out.print("\n")
//    }
//}
//
//fun checkWin(board: Array<Array<Char>>): Char {
//    val winLines = arrayOf(
//        arrayOf(arrayOf(0, 0), arrayOf(0, 1), arrayOf(0, 2)),
//        arrayOf(arrayOf(1, 0), arrayOf(1, 1), arrayOf(1, 2)),
//        arrayOf(arrayOf(2, 0), arrayOf(2, 1), arrayOf(2, 2)),
//        arrayOf(arrayOf(0, 0), arrayOf(1, 0), arrayOf(2, 0)),
//        arrayOf(arrayOf(0, 1), arrayOf(1, 1), arrayOf(2, 1)),
//        arrayOf(arrayOf(0, 2), arrayOf(1, 2), arrayOf(2, 2)),
//        arrayOf(arrayOf(0, 0), arrayOf(1, 1), arrayOf(2, 2)),
//        arrayOf(arrayOf(0, 2), arrayOf(1, 1), arrayOf(2, 0))
//    )
//    for (i in 0..7){
//        if (board[winLines[i][0][0]][winLines[i][0][1]] == board[winLines[i][1][0]][winLines[i][1][1]] && board[winLines[i][2][0]][winLines[i][2][1]] == board[winLines[i][1][0]][winLines[i][1][1]]){
//            return board[winLines[i][0][0]][winLines[i][0][1]]
//        }
//    }
//    return 'N'
//}
//
//// имеются ли свободные клетки
//fun isFill(board: Array<Array<Char>>): Boolean{
//    for (i in 0..2) {
//        for (j in 0..2) {
//            if (board[i][j] == ' ')
//                return true
//        }
//    }
//    return false
//}
//
//// int-ование координат
//fun pointFromString(string: String): Array<Int>{
//    val str = string.split(' ')
//    val x = str[0].toIntOrNull() ?: return arrayOf(-1, -1)
//    val y = str[1].toIntOrNull() ?: return arrayOf(-1, -1)
//    return arrayOf(x, y)
//}
//
//// возможно ли движение на конкретную координату
//fun isRightMove(board: Array<Array<Char>>, point: Array<Int>): Boolean{
//    return ((point[0] in 0..2) && (point[1] in 0..2) && board[point[1]][point[0]] == ' ')
// }
//
//fun game(input: InputStream = System.`in`, out: PrintStream = outputConsole){
//    val reader = BufferedReader(input.reader())
//    var board = arrayOf(
//        arrayOf(' ',' ',' '),
//        arrayOf(' ',' ',' '),
//        arrayOf(' ',' ',' '))
//    val symbols = arrayOf('X','0')
//    var v = 0 // номер игрока
//    var point: Array<Int>
//        do{
//            print("Игрок_${symbols[v]}, введите координаты\n")
//            point = pointFromString(reader.readLine())
//            if (isRightMove(board, point)) {
//                board[point[1]][point[0]] = symbols[v]
//                printBoard(board)
//                v = if (v == 0) 1 else 0
//            }
//            else {
//                out.print("Введены не верные координаты!\n")
//                print("Попробуйте еще раз.\n")
//            }
//        }while (!(checkWin(board) == 'X' || checkWin(board) == '0') && isFill(board))
//    if (checkWin(board) == 'N'){
//        out.print("Ничья!")
//    }
//    else {
//        out.print("Игрок_${checkWin(board)} - победитель!")
//    }
//}
