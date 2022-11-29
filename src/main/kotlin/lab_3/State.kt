package lab_3

class State(val board: Board = Board(Array(3) { Array(3) { ' ' } }), var turn: Char = '0') {

    fun copyState(state: State): State {
        return State(Board(Array(3) { i -> Array(3) { j -> state.board.cells[i][j] } }), turn)
    }

    fun checkWin(): Char {
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
            if ((board.cells[winLines[i][0][0]][winLines[i][0][1]] != ' ') &&
                (board.cells[winLines[i][0][0]][winLines[i][0][1]] == board.cells[winLines[i][1][0]][winLines[i][1][1]]) &&
                (board.cells[winLines[i][2][0]][winLines[i][2][1]] == board.cells[winLines[i][1][0]][winLines[i][1][1]])
            ) {
                return board.cells[winLines[i][0][0]][winLines[i][0][1]]
            }
        }
        return ' '
    }

    val gameResult: String?
        get() {
            return if (checkWin() == ' ' && !board.isFill)
                null
            else
                "Игра окончена!\n"
        }

    /*Данная функцию проверяет, можно ли сделать ход в переданную ей point.
     Если нет – возвращает null.
     Если да – возвращает новое состояние игры (с новой доской и новым символ для хода).*/
    // проверка на корректность
    fun step(point: Point): State? { // записывает в доску символ
        return if (board.getOrNull(point) != null) {
//            turn = if (turn == 'X') '0' else 'X'
            State(board.setAndCopy(point, turn), turn)
        } else null
    }

    /*если игра закончилась, возвращает строку информацию о победителе или о ничье,
     а остальных случаях возвращает строку с текущим положением на доске и информации о том, чья очередь хода*/
    override fun toString(): String {
        return if (gameResult != null)
            "Победил Игрок_$turn!\n$gameResult"
        else {
//            board.toString()

            return Array(3) { Array(3) { ' ' } }.toString()
        } //+ "Игрок_$turn, введите координаты или команду\n"
    }
}