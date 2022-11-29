//import io.kotest.core.spec.style.StringSpec
//import io.kotest.matchers.doubles.plusOrMinus
//import io.kotest.matchers.shouldBe
//import java.io.ByteArrayInputStream
//import java.io.ByteArrayOutputStream
//import java.io.PrintStream
//import kotlin.math.PI
//
//
//class GreatTest2 : StringSpec({// тесты
//    val outputBuffer = ByteArrayOutputStream()
//    val output = PrintStream(outputBuffer)
//    "Simple_test"{
//        great("VASA") shouldBe "Hello VASA"
//    }
//    "greater" {
//        val name = "Вася"
//        val input = ByteArrayInputStream(name.toByteArray())
//        greater(input, output)
//        outputBuffer.toString() shouldBe "Введите имя Привет Вася"
//    }
//    "радиус"{
//        square(1.0) shouldBe PI.plusOrMinus(0.001)
//    }
//    "print" {
//        val board = arrayOf(
//            arrayOf(' ',' ',' '),
//            arrayOf(' ','X',' '),
//            arrayOf(' ',' ','0'))
//        outputBuffer.reset() // очистка буфера
//        board.print(output)
//        outputBuffer.toString() shouldBe "  012\n0    \n1  X \n2   0\n"
//    }
//    "Check Win"{
//        val board1 = arrayOf(
//            arrayOf('X',' ',' '),
//            arrayOf(' ','X',' '),
//            arrayOf(' ',' ','X'))
//        board1.checkWin() shouldBe 'X'
//        val board2 = arrayOf(
//            arrayOf('0','0','0'),
//            arrayOf(' ','X',' '),
//            arrayOf(' ',' ','X'))
//        board2.checkWin() shouldBe '0'
//        val board3 = arrayOf(
//            arrayOf('X','0','X'),
//            arrayOf('X','0','X'),
//            arrayOf('0','X','0'))
//        board3.checkWin() shouldBe 'N'
//    }
//    "Full field"{// заполнен false, иначе true
//        val board_1 = arrayOf(
//            arrayOf('X',' ',' '),
//            arrayOf(' ','X',' '),
//            arrayOf(' ',' ','X'))
//        board_1.isFill() shouldBe true
//        val board_2 = arrayOf(
//            arrayOf('X','0','0'),
//            arrayOf('0','X','0'),
//            arrayOf('X','0','X'))
//        board_2.isFill() shouldBe false
//    }
//    "from str in int"{
//        val str = "0 1"
//        str.pointFromString() shouldBe Pair(0, 1)
//        val strn = "2"
//        strn.pointFromString() shouldBe Pair(-1, 2)
//    }
//    "to be or not to be"{
//        val board = arrayOf(
//            arrayOf('X','0',' '),
//            arrayOf(' ','X',' '),
//            arrayOf(' ',' ','X'))
//        val p1 : Pair<Int, Int> = Pair(0, 0)
//        val p2 : Pair<Int, Int> = Pair(0, 1)
//        board.isRightMove(p1) shouldBe false
//        board.isRightMove(p2) shouldBe true
//    }
//    "game: x - win"{
//        val input = "1 1\n0 1\n1 0\n2 1\n1 2\n"
//        outputBuffer.reset() // очистка буфера
//        game(ByteArrayInputStream(input.toByteArray()), output)
//        outputBuffer.toString() shouldBe "Игрок_X - победитель!"
//    }
//    "game: 0 - win"{
//        val input = "0 0\n1 1\n0 1\n1 0\n2 1\n1 2\n"
//        outputBuffer.reset() // очищаем
//        game(ByteArrayInputStream(input.toByteArray()), output)
//        outputBuffer.toString() shouldBe "Игрок_0 - победитель!"
//    }
//    "game: not winner"{
//        val input = "1 1\n0 0\n1 2\n1 0\n2 0\n0 2\n0 1\n2 1\n2 2\n"
//        outputBuffer.reset() // очистка буфера
//        game(ByteArrayInputStream(input.toByteArray()), output)
//        outputBuffer.toString() shouldBe "Ничья!"
//    }
//    "game: people make mistakes"{
//        val input = "1 1\n0 0\n0 0\n1 2\n1 0\n2 0\n0 2\n0 1\n2 1\n2 2\n"
//        outputBuffer.reset() // очистка буфера
//        game(ByteArrayInputStream(input.toByteArray()), output)
//        outputBuffer.toString() shouldBe "Введены не верные координаты!\nНичья!"
//    }
//    "game: back to the past"{
//        val input = "1 1\n0 0\n1 2\n0 1\n3\n1 0\n2 1\n2 0\n"
//        outputBuffer.reset() // очищаем
//        game(ByteArrayInputStream(input.toByteArray()), output)
//        outputBuffer.toString() shouldBe "Игрок_0 - победитель!"
//    }
//    "set"{
//        val board = arrayOf(
//            arrayOf('X','0',' '),
//            arrayOf(' ','X',' '),
//            arrayOf(' ',' ','X'))
//        board.set(Pair(0, 1), '5')
//        val i = board[1][0] == '5'
//        i shouldBe true
//    }
//    "copy"{
//        val board = arrayOf(
//            arrayOf('X','0',' '),
//            arrayOf(' ','X',' '),
//            arrayOf(' ',' ','X'))
//        board.copy() shouldBe arrayOf(arrayOf('X','0',' '), arrayOf(' ','X',' '), arrayOf(' ',' ','X'))
//    }
//})