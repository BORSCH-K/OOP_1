package lab_4

class Board(val cells: Array<Array<Char>>) {
    constructor(str: String) : this(Array(size) { i -> stringToArray(str.substring(i * size)) })

    // конструктор для записи доски при отмене хода
    constructor(arr: Array<Array<Char>>, t: Int) : this(Array(size) { i -> Array(size) { j -> arr[i][j] } })

    companion object {
        var size = 5
        fun stringToArray(string: String): Array<Char> {
            return Array(size) { i -> string[i] }
        }

        fun Array<Array<Char>>.copy(): Array<Array<Char>> {
            return Array(size) { i -> Array(size) { j -> this[i][j] } }
        }
    }

    // возвращают символ по координатам
    operator fun get(point: Point): Char = cells[point.y][point.x]
    operator fun get(point: Array<Int>): Char = cells[point[1]][point[0]]

    // возвращает ' ', если ход возможен
    fun getOrNull(point: Point): Char? {
        return if (point.x in 0 until size && point.y in 0 until size && get(point) == ' ') ' '
        else null
    }

    // возвращает переписанную доску
    fun setAndCopy(point: Point, c: Char): Board {
        return Board(cells.apply { this[point.y][point.x] = c }.copy())
    }

    // true - заполнен
    val isFill: Boolean
        get() {
            for (i in 0 until size)
                for (j in 0 until size) {
                    if (cells[i][j] == ' ')
                        return false
                }
            return true
        }

    override fun toString(): String {
        var str = if (size == 3) "  012\n" else "  01234\n"
        for (i in 0 until size) {
            str += "$i "
            for (j in 0 until size)
                str += cells[i][j]
            str += "\n"
        }
        return str
    }
}