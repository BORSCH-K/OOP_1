package lab_4

// класс для игры балда
// наследует абстрактный класс
class StateBalda( 
        board: Board,
        private val turn: Int = 1,
        private val words1: ArrayList<String> = ArrayList(),
        private val words2: ArrayList<String> = ArrayList()
) : AbstractState(board) {

    // при начале игры (startWord)
    constructor(str: String) : this(Board("          $str          "))

    // копирование состояния
    override fun copyState(): AbstractState {
        return StateBalda(Board(board), turn, words1, words2)
    }

   // проверка возможности хода
    override fun checkStep(step: Step): Boolean {
        return (step.x in 0 until Board.size // если х и у в диапозоне от 0 до размера доски
                && step.y in 0 until Board.size
                && board.getOrNull(step.point) != null // если клетка пуста
                && step.param[0].length == 1)  // если юзер передал один символ
    }

    // возвращает следующее состояние
    override fun nextState(step: Step): AbstractState {
        if (turn == 1) words1.add(step.param[1]) else words2.add(step.param[1]) // в зависимости от игрока добавляет слово 
        return StateBalda(
            board.setAndCopy(step.point, step.param[0][0]), // измененная ддоска
            if (turn == 1) 2 else 1, // номер игрока
            words1, // слова первого игрока
            words2 // второго
        )
    }

    // проверяет окончание игры: если на доске еще есть пустые поля - игра продолжается
    override val gameResult: String?
        get() {
            return if (!board.isFill) // если на доске еще есть пустые поля
                null
            else 
                "Игра окончена!\n"
        }
    
    // возвращение доски
    override fun toString(): String {
        return board.toString()
    }
}
