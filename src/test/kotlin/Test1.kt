//
//import io.kotest.core.spec.style.StringSpec
//import io.kotest.matchers.shouldBe
//import java.io.ByteArrayInputStream
//import java.io.ByteArrayOutputStream
//import java.io.PrintStream
//
//class GreatTest2 : StringSpec({
//    val outputBuffer = ByteArrayOutputStream()
//    val output = PrintStream(outputBuffer)
////    "Output board test" {
////        val board = arrayOf(
////            arrayOf(' ', ' ', ' '),
////            arrayOf(' ', 'X', ' '),
////            arrayOf(' ', ' ', '0')
////        )
////        outputBuffer.reset()
////        board.print(output)
////        outputBuffer.toString() shouldBe "  012\n0    \n1  X \n2   0\n"
////    }
////    "Check win test" {
////        var board = arrayOf(
////            arrayOf('X', 'X', 'X'),
////            arrayOf(' ', ' ', ' '),
////            arrayOf(' ', ' ', ' ')
////        )
////        board.checkWin() shouldBe 'X'
////        board = arrayOf(
////            arrayOf('X', ' ', ' '),
////            arrayOf(' ', 'X', ' '),
////            arrayOf(' ', ' ', 'X')
////        )
////        board.checkWin() shouldBe 'X'
////        board = arrayOf(
////            arrayOf(' ', '0', ' '),
////            arrayOf(' ', '0', ' '),
////            arrayOf(' ', '0', ' ')
////        )
////        board.checkWin() shouldBe '0'
////    }
////    "isFill test" {
////        var board = arrayOf(
////            arrayOf('0', '0', 'X'),
////            arrayOf('0', 'X', 'X'),
////            arrayOf('X', '0', '0')
////        )
////        !board.isFill() shouldBe true
////        board = arrayOf(
////            arrayOf(' ', '0', 'X'),
////            arrayOf('0', ' ', 'X'),
////            arrayOf(' ', ' ', ' ')
////        )
////        !board.isFill() shouldBe false
////    }
////    "pointFromString test" {
////        ("1 0").pointFromString() shouldBe Pair(1, 0)
////        ("1 y").pointFromString() shouldBe null
////        ("214 2").pointFromString() shouldBe Pair(214, 2)
////    }
////    "isRightMove test" {
////        board.isRightMove(Pair(1, 1)) shouldBe true
////        board.isRightMove(Pair(-1, -1)) shouldBe false
////        board.isRightMove(Pair(215, 1)) shouldBe false
////        board.isRightMove(Pair(0, 0)) shouldBe true
////        board.isRightMove(Pair(2, 2)) shouldBe true
////
////    }
////    "get test" {
////        val board = arrayOf(
////            arrayOf('0', '0', 'X'),
////            arrayOf('0', 'X', 'X'),
////            arrayOf('X', '0', '0')
////        )
////        board.get(Pair(1, 1)) shouldBe 'X'
////        board.get(Pair(2, 2)) shouldBe '0'
////        board.get(arrayOf(1, 2)) shouldBe '0'
////        board.get(arrayOf(2, 0)) shouldBe 'X'
////        board.get(arrayOf(2, 1)) shouldBe 'X'
////    }
////    "copy test" {
////        val board = arrayOf(
////            arrayOf('0', '0', 'X'),
////            arrayOf('X', '0', 'X'),
////            arrayOf('X', 'X', '0')
////        )
////        val testBoard = ArrayList<Array<Array<Char>>>()
////        testBoard.add(board.copy())
////        testBoard[0] shouldBe arrayOf(
////            arrayOf('0', '0', 'X'),
////            arrayOf('X', '0', 'X'),
////            arrayOf('X', 'X', '0')
////        )
////    }
//    "game test: win X" {
//        val input = "0 0\n1 1\n1 0\n2 2\n2 0\n"
//        outputBuffer.reset()
//        game(ByteArrayInputStream(input.toByteArray()), output)
//        outputBuffer.toString() shouldBe "Игрок_X - победитель!"
//    }
////    "game test: win 0" {
////        val input = "1 1\n0 0\n2 2\n1 0\n1 2\n2 0\n"
////        outputBuffer.reset()
////        lab2.game(ByteArrayInputStream(input.toByteArray()), output)
////        outputBuffer.toString() shouldBe "Победил игрок: 0"
////        board.print()
////    }
////    "game test: no winner" {
////        val input = "0 0\n1 0\n2 0\n1 1\n0 1\n0 2\n2 1\n2 2\n1 2\n"
////        outputBuffer.reset()
////        lab2.game(ByteArrayInputStream(input.toByteArray()), output)
////        outputBuffer.toString() shouldBe "Ничья"
////        board.print()
////    }
////    "game test: win + false point" {
////        val input = "1 1\n0 0\n2 2\n2 2\n1 0\n1 2\n2 0\n"
////        outputBuffer.reset()
////        lab2.game(ByteArrayInputStream(input.toByteArray()), output)
////        outputBuffer.toString() shouldBe "Победил игрок: 0"
////        board.print()
////    }
////    "game test: copy board" {
////        val input = "0 0\n1 0\n2 0\n1 1\n0 1\n0 2\n2 1\n2 2\n0\n1 1\n1 0\n2 2\n2 0\n"
////        outputBuffer.reset()
////        lab2.game(ByteArrayInputStream(input.toByteArray()), output)
////        outputBuffer.toString() shouldBe "Победил игрок: X"
////        board.print()
////    }
//})