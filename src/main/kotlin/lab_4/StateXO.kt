package lab_4

class StateXO(board: Board = Board(Array(3) { Array(3) { ' ' } }), private var turn: Char = '0') : AbstractState(board) {

    // возвращение следующего состояния
    override fun nextState(step: Step): AbstractState {
        turn = if (turn == 'X') '0' else 'X' // смена игроков
        return StateXO(board.setAndCopy(step.point, turn), turn)
    }

    // копирование состояния
    override fun copyState(): AbstractState {
        return StateXO(Board(board), turn)
    }

    // проверка выигрышной позиции
    private fun checkWin(): Char {
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

    // результат игры
    override val gameResult: String?
        get() {
            return if (checkWin() == ' ' && !board.isFill)
                null
            else
                "Игра окончена!\n"
        }

    // возможел ли ход на клетку
    override fun checkStep(step: Step): Boolean {
        return (step.x in 0 until Board.size && step.y in 0 until Board.size
                && (board.getOrNull(Point(step.x, step.y)) != null))
    }
   
    // поле / результат игры
    override fun toString(): String {
        return if (gameResult != null) {
            if (checkWin() == ' ') "Ничья!\n"
            else "Победил Игрок_$turn!\n$gameResult"
        }
        else
            board.toString()
    }
}
