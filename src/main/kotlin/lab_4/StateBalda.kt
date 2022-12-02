package lab_4

class StateBalda(
    board: Board,
    val turn: Int = 1,
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
        return StateBalda(Board(board.cells, 1), turn, words1, words2)
    }

    // это поле?
    // скорее это поле + данные доски, поле записывается внутри
    override fun checkStep(step: Step): Boolean {
        return (step.x in 0 until Board.size
                && step.y in 0 until Board.size
                && board.getOrNull(step.point) != null
                && step.param[0].length == 1) // add параметры
    }

    override fun nextState(step: Step): AbstractState {
//        val b = board.setAndCopy(step.point, step.param[0])
//        return copyState(b)
        if (turn == 1) words1.add(step.param[1]) else words2.add(step.param[1])
        return StateBalda(
            board.setAndCopy(step.point, step.param[0][0]),
            if (turn == 1) 2 else 1,
            words1,
            words2
        )
        // -> Board
    }


    // ПЕРЕДЕЛАТЬ!!!****
    override val gameResult: String? = null
    //В текущем классе следует выполнить проверку количества параметров
// хода в переменной step.param и корректно вызвать функцию checkStep
// суперкласса.
    // 1 или 2?

//    override fun checkStep(step: Step): Boolean{}


}
