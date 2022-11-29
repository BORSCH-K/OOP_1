package lab_4

class StateBalda(
    board: String,
    val turn: Int = 1,
    val words1: List<String> = ArrayList(),
    val words2: List<String> = ArrayList()
) : AbstractState(board) {


    // 1 или 2?
//constructor(srt:String): this{}

    // а надо ли ее переопределять? надо!
//    override fun checkStep(step: Step): Boolean{}


}