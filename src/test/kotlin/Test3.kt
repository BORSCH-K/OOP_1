package new_lab_3

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class TEST_3 : StringSpec({

    val outputBuffer = ByteArrayOutputStream()
    val output = PrintStream(outputBuffer)

    // BOARD
    val b1 = Board(
        arrayOf(
            arrayOf('0', ' ', '0'),
            arrayOf('0', 'X', 'X'),
            arrayOf('X', '0', 'X')
        )
    )
    val b2 = Board(
        arrayOf(
            arrayOf('0', 'X', '0'),
            arrayOf('0', 'X', 'X'),
            arrayOf('X', '0', 'X')
        )
    )
    "getOrNull" {
        b1.getOrNull(Point(1, 0)) shouldBe ' '
    }
    "setAndCopy" {
//      работает только отдельно
        b1.setAndCopy(Point(1, 0), 'X')
        b1.cells shouldBe b2.cells
    }
    "isFill" {
        b1.isFill shouldBe false
        b2.isFill shouldBe true
    }
    "constructor_1" {
        val t = arrayOf(
            arrayOf('0', 'X', '0'),
            arrayOf('0', 'X', 'X'),
            arrayOf('X', '0', 'X')
        )
        val t_n = Board(t)
        t_n.cells shouldBe t
    }
    "constructor_2" {
        val t = Board("0X00XXX0X")
        t.cells shouldBe arrayOf(
            arrayOf('0', 'X', '0'),
            arrayOf('0', 'X', 'X'),
            arrayOf('X', '0', 'X')
        )
    }
    "get" {
        b1[Point(0, 0)] shouldBe '0'
        b1[arrayOf(0, 0)] shouldBe '0'
    }
    "strToArray" {
        Board.stringToArray("123") shouldBe arrayOf('1', '2', '3')
    }
    "toString" {
        b1.toString() shouldBe "  012\n" + "0 0 0\n" + "1 0XX\n" + "2 X0X\n"
    }

    // STATE
    val s1 = State(b1)
    val b3 = Board(
        arrayOf(
            arrayOf('0', '0', '0'),
            arrayOf('0', 'X', 'X'),
            arrayOf('X', '0', 'X')
        )
    )
    val s2 = State(b2)
    val s3 = State(b3)
    "checkWin" {
        s1.checkWin() shouldBe ' '
        s3.checkWin() shouldBe '0'
    }
    "state.toString" {
        s3.toString() shouldBe "Игра окончена!\nПобедил Игрок_0!\n"
        s2.toString() shouldBe "Игра окончена!\nНичья!\n"
        s1.toString() shouldBe b1.toString()
    }
    "gameResult" {
        s1.gameResult shouldBe null
        s2.gameResult shouldBe "Ничья!"
        s3.gameResult shouldBe "Победил Игрок_0!"
    }
    "StateCopy" {
        val t = s1.copyState(s1, 'X')
        t.board.cells shouldBe b1.cells
    }

    // GAME
    "win - X" {
        val input = "0 0\n0 1\n1 1\n0 2\n2 2\n"
        outputBuffer.reset()
        val WinX = "Ход: 0\n" +
                "  012\n" +
                "0    \n" +
                "1    \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 1\n" +
                "  012\n" +
                "0 X  \n" +
                "1    \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 2\n" +
                "  012\n" +
                "0 X  \n" +
                "1 0  \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 3\n" +
                "  012\n" +
                "0 X  \n" +
                "1 0X \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 4\n" +
                "  012\n" +
                "0 X  \n" +
                "1 0X \n" +
                "2 0  \n" +
                "Ваш ход или команда\n" +
                "Игра окончена!\n" +
                "Победил Игрок_X!\n"
        game(ByteArrayInputStream(input.toByteArray()), output)
        outputBuffer.toString() shouldBe WinX
    }
    "win - 0" {
        val input = "0 0\n1 0\n0 1\n1 1\n2 0\n1 2\n"
        outputBuffer.reset()
        val Win0 = "Ход: 0\n" +
                "  012\n" +
                "0    \n" +
                "1    \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 1\n" +
                "  012\n" +
                "0 X  \n" +
                "1    \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 2\n" +
                "  012\n" +
                "0 X0 \n" +
                "1    \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 3\n" +
                "  012\n" +
                "0 X0 \n" +
                "1 X  \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 4\n" +
                "  012\n" +
                "0 X0 \n" +
                "1 X0 \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 5\n" +
                "  012\n" +
                "0 X0X\n" +
                "1 X0 \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Игра окончена!\n" +
                "Победил Игрок_0!\n"
        game(ByteArrayInputStream(input.toByteArray()), output)
        outputBuffer.toString() shouldBe Win0
    }
    "WinNot" {
        val input = "0 0\n1 1\n2 2\n0 1\n1 0\n2 0\n2 1\n1 2\n0 2\n"
        outputBuffer.reset()
        val WinNot = "Ход: 0\n" +
                "  012\n" +
                "0    \n" +
                "1    \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 1\n" +
                "  012\n" +
                "0 X  \n" +
                "1    \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 2\n" +
                "  012\n" +
                "0 X  \n" +
                "1  0 \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 3\n" +
                "  012\n" +
                "0 X  \n" +
                "1  0 \n" +
                "2   X\n" +
                "Ваш ход или команда\n" +
                "Ход: 4\n" +
                "  012\n" +
                "0 X  \n" +
                "1 00 \n" +
                "2   X\n" +
                "Ваш ход или команда\n" +
                "Ход: 5\n" +
                "  012\n" +
                "0 XX \n" +
                "1 00 \n" +
                "2   X\n" +
                "Ваш ход или команда\n" +
                "Ход: 6\n" +
                "  012\n" +
                "0 XX0\n" +
                "1 00 \n" +
                "2   X\n" +
                "Ваш ход или команда\n" +
                "Ход: 7\n" +
                "  012\n" +
                "0 XX0\n" +
                "1 00X\n" +
                "2   X\n" +
                "Ваш ход или команда\n" +
                "Ход: 8\n" +
                "  012\n" +
                "0 XX0\n" +
                "1 00X\n" +
                "2  0X\n" +
                "Ваш ход или команда\n" +
                "Игра окончена!\n" +
                "Ничья!\n"
        game(ByteArrayInputStream(input.toByteArray()), output)
        outputBuffer.toString() shouldBe WinNot
    }
    "Error" {
        val input = "0 0\n1 1\n2 2\n0 1\n1 0\n2 0\n2 0\n2 1\n1 2\n0 2\n"
        outputBuffer.reset()
        val Error = "Ход: 0\n" +
                "  012\n" +
                "0    \n" +
                "1    \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 1\n" +
                "  012\n" +
                "0 X  \n" +
                "1    \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 2\n" +
                "  012\n" +
                "0 X  \n" +
                "1  0 \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 3\n" +
                "  012\n" +
                "0 X  \n" +
                "1  0 \n" +
                "2   X\n" +
                "Ваш ход или команда\n" +
                "Ход: 4\n" +
                "  012\n" +
                "0 X  \n" +
                "1 00 \n" +
                "2   X\n" +
                "Ваш ход или команда\n" +
                "Ход: 5\n" +
                "  012\n" +
                "0 XX \n" +
                "1 00 \n" +
                "2   X\n" +
                "Ваш ход или команда\n" +
                "Ход: 6\n" +
                "  012\n" +
                "0 XX0\n" +
                "1 00 \n" +
                "2   X\n" +
                "Ваш ход или команда\n" +
                "Ваш ход или команда\n" +
                "Ход: 7\n" +
                "  012\n" +
                "0 XX0\n" +
                "1 00X\n" +
                "2   X\n" +
                "Ваш ход или команда\n" +
                "Ход: 8\n" +
                "  012\n" +
                "0 XX0\n" +
                "1 00X\n" +
                "2  0X\n" +
                "Ваш ход или команда\n" +
                "Игра окончена!\n" +
                "Ничья!\n"
        game(ByteArrayInputStream(input.toByteArray()), output)
        outputBuffer.toString() shouldBe Error
    }
    "takeBack"{
        val input = "1 1\n0 0\n-1 0\n1 1\n1 0\n0 0\n2 0\n2 2\n"
        outputBuffer.reset()
        val tb = "Ход: 0\n" +
                "  012\n" +
                "0    \n" +
                "1    \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 1\n" +
                "  012\n" +
                "0    \n" +
                "1  X \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 2\n" +
                "  012\n" +
                "0 0  \n" +
                "1  X \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 0\n" +
                "  012\n" +
                "0    \n" +
                "1    \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 1\n" +
                "  012\n" +
                "0    \n" +
                "1  X \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 2\n" +
                "  012\n" +
                "0  0 \n" +
                "1  X \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 3\n" +
                "  012\n" +
                "0 X0 \n" +
                "1  X \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Ход: 4\n" +
                "  012\n" +
                "0 X00\n" +
                "1  X \n" +
                "2    \n" +
                "Ваш ход или команда\n" +
                "Игра окончена!\n" +
                "Победил Игрок_X!\n"
        game(ByteArrayInputStream(input.toByteArray()), output)
        outputBuffer.toString() shouldBe tb
    }
})