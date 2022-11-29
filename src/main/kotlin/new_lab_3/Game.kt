package new_lab_3

class Game(state: State = State()) {

    val states = ArrayList<State>() // массив состояний
    var indexState = 0 // индекс текущего хода

    init { // инициализация поля в самом старте
        if (indexState == 0) states.add(State()/*st.copyState(st)*/)
    }

    // инициализация state, каждый раз новый
    val state: State
        get() { // добавляет текущую доску в массив состояний
            return states[indexState].copyState(states[indexState], if (indexState % 2 == 0) 'X' else '0')
        }

    // проверка на конец игры
    val gameOver: Boolean
        get() {
            return state.gameResult != null // если игра закончилась - true
        }

    // функция хода
    fun step(point: Point): Boolean { // если ход был - true, иначе - false
        val s = state.step(point) // создание доска состояния
        return if (s != null) { // проверка на существование этого состояния
            // если оно существует, то записывается это состояние в новую доску
            states.add(state.copyState(s, if (indexState % 2 == 0) 'X' else '0'))
            indexState++ // номер хода++
            true
        } else false
    }

    // возвращение на ход(ы) назад
    fun takeBack(shift: Int): Boolean { // параметр - ход, на который нужно вернуться
        return if (shift in 0 until indexState) { // если он в допустимом диапозоне
            indexState = shift // текущий номер хода = новый номер хода
            while (states.lastIndex != indexState) { // номер последнего индекса массива состояний не совпал с новым номером хода
                states.removeAt(states.lastIndex) // удаление элемента с последним индексом
            }
            true // если вернулся на ход(ы)
        } else false // если новый номер хода не попал в допустимый диапозон
    }

    // переопределение toString()
    override fun toString(): String {
        return if (!gameOver) // вывод номера хода и текущей доски, если игра идет
            "Ход: $indexState\n" + states[indexState]
        else
            state.toString() // вывод результата игры, если она закончилась
    }
}