package lab_4

class StateXOTemp( // наследует StateXO
    board: Board = Board(Array(3) { Array(3) { ' ' } }),
    private var turn: Char = '0'
) : StateXO(board) {

    // важно переопределить функции (если таковы имеются), возвращающие класс, так как в следующей итерации программа будет видеть объект родителя, а не наследника
    override fun nextState(step: Step): AbstractState {
        turn = if (turn == 'X') '0' else 'X'
        return StateXOTemp(board.setAndCopy(step.point, turn), turn)
    }
    
    override fun copyState(): AbstractState {
        return StateXOTemp(Board(board), turn)
    }
    
    // тот же toString, только вместо "выиграл" "проиграл"
    override fun toString(): String {
        return if (gameResult != null) {
            if (checkWin() == ' ') "Ничья!\n"
            else "Проиграл Игрок_$turn!\n$gameResult"
        } else
            board.toString()
    }
}
