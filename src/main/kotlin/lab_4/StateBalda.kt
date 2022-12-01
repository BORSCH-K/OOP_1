package lab_4

class StateBalda(
    board: Board,
    val turn: Int = 1,
    val words1: List<String> = ArrayList(),
    val words2: List<String> = ArrayList()
) : AbstractState(board) {

    // при начале игры (startWord)
    constructor(str: String) : this(Board("          $str          "))
    // это поле?
    // скорее это поле + данные доски, поле записывается внутри
    override fun nextState(step: Step): AbstractState? {
        // -> Board
    }

    // 1 или 2?

//    override fun checkStep(step: Step): Boolean{}


}
