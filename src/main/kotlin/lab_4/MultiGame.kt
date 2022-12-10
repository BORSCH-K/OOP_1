package lab_4

class MultiGame(state: AbstractState) {

    val states = ArrayList<AbstractState>()
    var indexState = 0

    init {
        if (indexState == 0) states.add(state)
    }

    val state: AbstractState
        get() {
            return states[indexState].copyState()
        }

    val gameOver: Boolean
        get() {
            return state.gameResult != null
        }

    fun step(step_: Step): Boolean {
        val s = state.step(step_)
        return if (s != null) {
            states.add(s.copyState())
            indexState++
            true
        } else false
    }

    fun takeBack(shift: Int): Boolean {
        return if (shift in 0 until indexState) {
            indexState = shift
            while (states.lastIndex != indexState) {
                states.removeAt(states.lastIndex)
            }
            true
        } else false
    }

    override fun toString(): String {
        return if (!gameOver)
            "Ход: $indexState\n" + "Игрок: ${indexState%2+1}\n" + states[indexState]
        else
            state.toString()
    }
}
