package lab_5

open class GameException(message: String): Exception(message)

// выбрасывается, если пользователь ввел неправильную команду
class WrongCommandException(message: String): GameException(message)

// выбрасываться, если пользователь сделал ход не по правилам игры
class WrongStepException(message: String): GameException(message)

// выбрасывается, если пользователь
// ввел координаты поля, которого нет на игровой доске
class NoCellException(message: String): GameException(message)