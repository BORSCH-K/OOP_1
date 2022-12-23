package lab_5

class EStateBalda(
        board: Board,
        private val turn: Int = 1,
        private val words1: ArrayList<String> = ArrayList(),
        private val words2: ArrayList<String> = ArrayList()
) : EAbstractState(board) {
    // при начале игры (startWord)
    constructor(str: String) : this(Board("          $str          "))

    override fun copyState(): EAbstractState {
        return EStateBalda(Board(board), turn, words1, words2)
    }

    override fun checkStep(step: Step) {
        if (!(step.x in 0 until Board.size
                        && step.y in 0 until Board.size
                        && board[step.point] == ' '
//                && board.getOrNull(step.point) != null
                        && step.param[0].length == 1))
            throw WrongStepException("Вы нарушили правила игры!")
    }

    override fun nextState(step: Step): EAbstractState {
        if (turn == 1) words1.add(step.param[1]) else words2.add(step.param[1])
        return EStateBalda(
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