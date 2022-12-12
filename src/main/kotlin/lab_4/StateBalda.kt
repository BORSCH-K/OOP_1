package lab_4

class StateBalda(
        board: Board,
        private val turn: Int = 1,
        private val words1: ArrayList<String> = ArrayList(),
        private val words2: ArrayList<String> = ArrayList()
) : AbstractState(board) {

    // при начале игры (startWord)
    constructor(str: String) : this(Board("          $str          "))

    /*  fun step(step: Step): AbstractState?{
            if (checkStep(step)) {
                return nextState(step)
            }
            return null
        }
    */

    // Подумать еще***
    override fun copyState(): AbstractState {
        return StateBalda(Board(board), turn, words1, words2)
    }

    // скорее это поле + данные доски, поле записывается внутри
    override fun checkStep(step: Step): Boolean {
        return (step.x in 0 until Board.size
                && step.y in 0 until Board.size
                && board.getOrNull(step.point) != null
                && step.param[0].length == 1) // add параметры
    }

    override fun nextState(step: Step): AbstractState {
        if (turn == 1) words1.add(step.param[1]) else words2.add(step.param[1])
        return StateBalda(
            board.setAndCopy(step.point, step.param[0][0]),
            if (turn == 1) 2 else 1,
            words1,
            words2
        )
    }

    override val gameResult: String?
        get() {
            return if (!board.isFill)
                null
            else
                "Игра окончена!\n"
        }
    //В текущем классе следует выполнить проверку количества параметров
// хода в переменной step.param и корректно вызвать функцию checkStep
// суперкласса.

    override fun toString(): String {
        return board.toString()
    }

    // почему-то не вызывается с мейна
//     val endGame: String
//        get() {
//            var s1 = ""
//            var s2 = ""
////        val s0: Int = words1.size
//            for (i in 0..words1.size) {
//                s1 += words1[i] + "\n"
//            }
//            for (i in 0..words2.size) {
//                s2 += words2[i] + "\n"
//            }
//            return "Слова 1 игрока:\n" + s1 + "Слова 1 игрока:\n" + s2
//        }
}
