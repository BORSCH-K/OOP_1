package lab_4

class StateXO(board: Board = Board(Array(3) { Array(3) { ' ' } }), var turn: Char = '0') : AbstractState(board) {

    override fun copyState(): StateXO {
        return StateXO(Board(board.cells, 1), turn)
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

    override val gameResult: String?
        get() {
            return if (checkWin() == ' ' && !board.isFill)
                null
            else
                "Игра окончена!\n"
        }

    override fun nextState(step: Step): AbstractState {
//       НА СЧЕТ turn ПОДУМАТЬ!!!
        return StateXO(board.setAndCopy(step.point, turn), turn)
    }
    /*Данная функцию проверяет, можно ли сделать ход в переданную ей point.
     Если нет – возвращает null.
     Если да – возвращает новое состояние игры (с новой доской и новым символ для хода).*/
    // проверка на корректность
//    fun checkStep(point: Point): Boolean = (board.getOrNull(point) != null) /*{
        // записывает в доску символ
//            turn = if (turn == 'X') '0' else 'X'
//        } else null
//    }*/

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
