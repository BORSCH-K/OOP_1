package lab_4

// не имеет объекта
// примеры: круг, квадрат - это фигура, но фигуры, как фигуры, не существует!

// тоже набор свойств и методов - то, что общее

abstract class AbstractState(val board: Board) {
    
    // результат игры
    abstract val gameResult: String?
    // копирование состояния
    abstract fun copyState() : AbstractState

    // проверка правильности хода и сам ход
    fun step(step: Step): AbstractState?{ // в других файлах не встречается, так как метод уже определен и переопределения не трубует
        if (checkStep(step)) {
            return nextState(step)
        }
        return null
    }

    // проверка возможности хода, переопределена в других файлах
    open fun checkStep(step: Step):Boolean{
        return (step.x in 0  until  Board.size && step.y in 0  until Board.size) 
    }

    // если ход правильный с помощью checkStep, то вызываем nextState и возвращаем новое состояние
    abstract fun nextState(step: Step):AbstractState
}
