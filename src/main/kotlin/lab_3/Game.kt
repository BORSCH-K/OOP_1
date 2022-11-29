package lab_3

class Game(state: State = State()) {

    val states = ArrayList<State>()
    var indexState = 0
//    val startState: State = State(Board(Array(3) { Array(3) { ' ' } }))

    //    init {
    init { // доразобраться
        if (indexState == 0) states.add(State())
//        print(states[0])
//        else state = states[indexState]
    }

    val state: State
        get() {
            return /*if (indexState == 0)
                State()
//            println("aaaaaaaaa")
             else */states[indexState] // <<<---- ошибка тут !!! (передается ссылка, будет смещение)
        }
//    var state: State

    val gameOver: Boolean
        // игра закончилась?
        get() {
//            println("----")
            return state.gameResult != null
//            field = value
//            println(gameOver)
        }

    /*Она должна проверить корректность хода в точку point (если нет – вернуть false),
    вычислить новое состояние и обновить массив состояний и индекс текущего состояний и вернуть true.*/
    fun step(point: Point): Boolean {
        state.turn = if (indexState % 2 == 0) 'X' else '0'
        if (!gameOver && state.step(point) != null) {
//            print(state)
//            println("AAAAAAAAAAAAA")
//            println("1) ${state.turn}")
            // лучше поменять
            // обычный случай
//            if (indexState-1 == states.size) {
            states.add(state.copyState(state/*s[indexState]*/))
//            } // state.step(point) - состояние с ходом
            // перепись?
//            else
            // тут будет проблема с занписью симпола!!!
//                states[indexState] = state.step(point)!!
//            println("2) ${state.turn}")
//            state.turn = if (state.turn == 'X') '0' else 'X'
//            println("3) ${state.turn}")
            indexState++
            return true
        }
        return false
    }

    fun takeBack(shift: Int): Boolean {
        return if (shift in 0 until indexState) {
//            println("SIZE "+states.size)
//            println("shift $shift")
            while (states.size != shift) {
//                println(states.lastIndex)
//                println("DELETED")
//                indexState --
                states.removeAt(states.lastIndex)
            }
//            indexState = 7
//            shift = 5
//            0 .. 1
////            i.end = 7 6 5 .4.
//            for (i in 0 ..(indexState - shift)) {
//                states.removeAt(states.lastIndex)
//            }
            indexState = shift - 1 //+1
//            println("lastInd "+states.lastIndex)
//            println("ind "+ indexState)
//            state.board = states[indexState].board
////            state.turn = if (indexState %2 == 0) 'X' else '0'
//            // разобраться!!!
//            while (states.lastIndex != indexState-1) {
//                states.removeAt(states.lastIndex)
//            }
//
//            for (i in 0 ..(indexState - shift)) {
//                states.removeAt(states.lastIndex)
//            }
//            state = states[indexState]
//                print(states[indexState].toString())
            true
        } else false
    }

    /*Если игра закончилась, то функция override fun toString(): String возвращает результата игры,
    иначе она возвращает номер хода и текущее состояние*/
    override fun toString(): String {
        return if (!gameOver)
            "Ход: $indexState\n" + states[indexState].board.toString()
        else
            state.toString()
    }
}