package lab_3

class Board(val cells: Array<Array<Char>>) {

    //
    constructor(string: String) : this(Array(size) { i -> stringToArray(string.substring(i until i + size)) })

    // изменить набор агрументов
    constructor(cells: Array<Array<Char>>, t: Int) : this(Array(size) { i -> Array(size) { j -> cells[i][j] } })

    // функции, написанные в объекте компаньоне, можно использовать в классе
    companion object {
        var size = 3
        fun stringToArray(string: String): Array<Char> {
            return Array(size) { i -> string[i] }
        }
    }

    // что значит оператор?
    operator fun get(point: Point): Char = cells[point.y][point.x]
    operator fun get(point: Array<Int>): Char = cells[point[1]][point[0]]

    fun getOrNull(point: Point): Char? {
        return if (point.x in 0 until size && point.y in 0 until size && get(point) == ' ') get(point)
        else null
    }

    fun setAndCopy(point: Point, c: Char): Board {
        return Board(cells.apply { this[point.y][point.x] = c }.copy())
    }

    val isFill: Boolean // заполнен?
        get() {
            for (i in 0 until size)
                for (j in 0 until size) {
                    if (cells[i][j] == ' ')
                        return false
                }
            return true
        }

    override fun toString(): String {
        var str = /*""*/ "  012\n"
        for (i in 0 until size) {
            str += "$i "
            for (j in 0 until size)
                str += cells[i][j]
            str += "\n"
        }
        return str
    }

    fun copy(): Array<Array<Char>> {
        return Array(size) { i -> Array(size) { j -> cells[i][j] } }
    }
}
//fun Array<Array<Char>>.copy(): Array<Array<Char>> {
//    return Array(3) { i -> Array(3) { j -> this[i][j] } }
//}