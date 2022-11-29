package new_lab_3

class State(val board: Board = Board(Array(3) { Array(3) { ' ' } }), var turn: Char = 'X') {

    // возвращает копию state
    fun copyState(state: State, turn: Char): State {
        return State(Board(Array(3) { i -> Array(3) { j -> state.board.cells[i][j] } }), turn)
    }


    // проверка на выигрышную позицию, в случае ее отсутствия ' '
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

    // null - игра идет
    val gameResult: String?
        get() {
            return if (!board.isFill && checkWin() == ' ') // если есть свободные клетки и поле ' '
                null
            else { // в случае конца игры, выводятся ее результаты
                if (checkWin() == ' ')
                    "Ничья!"
                else
                    "Победил Игрок_${checkWin()}!"
            }
        }

    // возвращает новую доску, если ход возможен
    fun step(point: Point): State? {
        // добавить изменение turn
        return if (board.getOrNull(point) != null) { // если ход возможен
            State(board.setAndCopy(point, turn), turn)
        } else null
    }

    // возвращает доску при продолжении игры
    override fun toString(): String {
        return if (gameResult != null)
            "Игра окончена!\n$gameResult\n"
        else board.toString()
    }
}