package lab_5

// не имеет объекта
// примеры: круг, квадрат - это фигура, но фигуры, как фигуры, не существует!

// тоже набор свойств и методов - то, что общее

abstract class EAbstractState(val board: Board) {
    abstract val gameResult: String?
    abstract fun copyState(): EAbstractState

    // проверка правильности хода и сам ход
    fun step(step: Step): EAbstractState {
        checkStep(step)
        return nextState(step)
    }

    // проверка правильности хода игры
    open fun checkStep(step: Step) {
        when {
            !(step.x in 0 until Board.size &&
                    step.y in 0 until Board.size) ->
                throw NoCellException("Выход за пределы доски")

            (step.x in 0 until Board.size &&
                    step.y in 0 until Board.size &&
                    board[step.point] != ' ') ->
                throw WrongStepException("Вы нарушили правила игры!")
        }
    }

    //    open fun checkStep(step: Step): Boolean {
//        return (step.x in 0 until Board.size && step.y in 0 until Board.size)
//    }

    // если ход правильный с помощью checkStep, то вызываем nextState и возвращаем новое состояние
    abstract fun nextState(step: Step): EAbstractState
}