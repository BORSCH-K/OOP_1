package lab_4

class MultiGame(state: AbstractState) {

    val states = ArrayList<AbstractState>()
    var indexState = 0

    init {
        if (indexState == 0) states.add(AbstractState/*st.copyState(st)*/)
    }

    val state: AbstractState
        get() {
            return states[indexState].copyState(states[indexState], /*if (indexState % 2 == 0) 'X' else '0'*/)
        }

    val gameOver: Boolean
        get() {
            return state.gameResult != null
        }

    fun step(point: Point): Boolean {
        val s = state.step(point)
        return if (s != null) {
            states.add(state.copyState(s, /*if (indexState % 2 == 0) 'X' else '0')*/)
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
            "Ход: $indexState\n" + states[indexState]
        else
            state.toString()
    }
}