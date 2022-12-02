package lab_4

// не имеет объекта
// примеры: круг, квадрат - это фигура, но фигуры, как фигуры, не существует!

// тоже набор свойств и методов - то, что общее

abstract class AbstractState(val board: Board) {
    abstract val gameResult: String?
    abstract fun copyState() : AbstractState//????

    // проверка правильности хода и сам ход
    fun step(step: Step): AbstractState?{
        if (checkStep(step)) {
            return nextState(step)
        }
        return null
    }

    // проверка правильности хода игры + пустое поле или нет?
    open fun checkStep(step: Step):Boolean{
        return (step.x in 0  until  Board.size && step.y in 0  until Board.size) // add параметры
    }

    // если ход правильный с помощью checkStep, то вызываем nextState и возвращаем новое состояние
    abstract fun nextState(step: Step):AbstractState
}
