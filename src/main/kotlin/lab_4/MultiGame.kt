package lab_4

// класс, который отвечает за действия игры, а не за отдельнее ее элементы
// алгоритм проведения игры не зависит от того, какая это игра
class MultiGame(state: AbstractState) {

    private val states = ArrayList<AbstractState>() // история ходов
    private var indexState = 0 // номер хода

    init {
        if (indexState == 0) states.add(state) // в самом начале игры, записывается пустое поле
    }

    private val state: AbstractState
        get() {
            return states[indexState].copyState() // возвращается текущее поле
        }

    // проверяет закончилась ли игра
    val gameOver: Boolean
        get() {
            return state.gameResult != null
        }

    // ход игры
    fun step(step0: Step): Boolean { // возвращает true, если ход прошел
        val s = state.step(step0) // если ход возможен s = состояние, иначе null
        return if (s != null) {
            states.add(s.copyState()) // если ход прошел, то записывает в историю ходов
            indexState++ 
            true
        } else false
    }

    // отмена хода
    fun takeBack(shift: Int): Boolean { // если вернулись на "н-ый" ход - true
        // если отмена возможна
        return if (shift in 0 until indexState) {
            indexState = shift
            while (states.lastIndex != indexState) { // удаляем все прошлые состояния
                states.removeAt(states.lastIndex)
            }
            true
        } else false
    }

    // поле
    override fun toString(): String {
        return if (!gameOver)
            "Ход: $indexState\n" + states[indexState]
        else
            state.toString()
    }
}
