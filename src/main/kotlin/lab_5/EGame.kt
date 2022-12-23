package lab_5

class EGame(state: EAbstractState) {

    private val states = StateList(state)
    private var indexState = 0

    init {
        if (indexState == 0) states.add(state)
    }

//    private val state: EAbstractState
//        get() {
//            return states[indexState].copyState()
//        }

    val gameOver: Boolean
        get() {
            return states.state.gameResult != null
        }


    fun step(step: Step) {
        states.add(states.state.copyState())
        states.state.step(step)
        indexState++
//        val s = state.step(step0)
//        return if (s != null) {
//            states.add(s.copyState())
//            indexState++
//            true
//        } else false
    }

    fun takeBack(shift: Int) {
//        try {
//            states.move(shift)
        if (shift in 0 .. indexState) {
            indexState -= shift
            while (states.array.lastIndex != indexState) {
                states.array.removeAt(states.array.lastIndex)
            }
        } else
//        } catch (e: GameException) {
            throw WrongCommandException("Введена неправильная команда!")
//        }
    }

    fun newGame(){
        indexState = 0
        while (states.array.lastIndex != 0) {
            states.array.removeAt(states.array.lastIndex)
        }
    }

    override fun toString(): String {
        return if (!gameOver)
            "Ход: $indexState\n" + states.state//.toString()
        else
            states.state.toString()
    }
}