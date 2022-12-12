package lab_4

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

val outputBuffer = ByteArrayOutputStream()
val output = PrintStream(outputBuffer)

class TEST_4 : StringSpec({

    "Exit" {
        val input = "0\n"
        outputBuffer.reset() // очистка буфера
        game(ByteArrayInputStream(input.toByteArray()), output)
        outputBuffer.toString() shouldBe "Ход: 0\n" +
                "  012\n" +
                "0    \n" +
                "1    \n" +
                "2    \n" +
                "Exit\n"
    }

    // ДЛЯ БАЛДЫ
    "B: TakeBack" {
        val input = "0 0 l ll\n1 1 k kk\n-1 0\n0\n"
        outputBuffer.reset() // очистка буфера
        game(ByteArrayInputStream(input.toByteArray()), output)
        outputBuffer.toString() shouldBe "Ход: 0\n" +
                "Игрок: 1\n" +
                "  01234\n" +
                "0      \n" +
                "1      \n" +
                "2 balda\n" +
                "3      \n" +
                "4      \n" +
                "Ход: 1\n" +
                "Игрок: 2\n" +
                "  01234\n" +
                "0 l    \n" +
                "1      \n" +
                "2 balda\n" +
                "3      \n" +
                "4      \n" +
                "Ход: 2\n" +
                "Игрок: 1\n" +
                "  01234\n" +
                "0 l    \n" +
                "1  k   \n" +
                "2 balda\n" +
                "3      \n" +
                "4      \n" +
                "RETURN:\n" +
                "Ход: 0\n" +
                "Игрок: 1\n" +
                "  01234\n" +
                "0      \n" +
                "1      \n" +
                "2 balda\n" +
                "3      \n" +
                "4      \n" +
                "Exit\n"
    }
    "B: TakeBack+error" {
        val input = "0 0 l ll\n1 1 k kk\n-1 7\n-1 0\n0\n"
        outputBuffer.reset() // очистка буфера
        game(ByteArrayInputStream(input.toByteArray()), output)
        outputBuffer.toString() shouldBe "Ход: 0\n" +
                "Игрок: 1\n" +
                "  01234\n" +
                "0      \n" +
                "1      \n" +
                "2 balda\n" +
                "3      \n" +
                "4      \n" +
                "Ход: 1\n" +
                "Игрок: 2\n" +
                "  01234\n" +
                "0 l    \n" +
                "1      \n" +
                "2 balda\n" +
                "3      \n" +
                "4      \n" +
                "Ход: 2\n" +
                "Игрок: 1\n" +
                "  01234\n" +
                "0 l    \n" +
                "1  k   \n" +
                "2 balda\n" +
                "3      \n" +
                "4      \n" +
                "Error\n" +
                "RETURN:\n" +
                "Ход: 0\n" +
                "Игрок: 1\n" +
                "  01234\n" +
                "0      \n" +
                "1      \n" +
                "2 balda\n" +
                "3      \n" +
                "4      \n" +
                "Exit\n"
    }
    "B: Step+error" {
        val input = "0 7 l ll\n1 1 k kk\n0\n"
        outputBuffer.reset() // очистка буфера
        game(ByteArrayInputStream(input.toByteArray()), output)
        outputBuffer.toString() shouldBe "Ход: 0\n" +
                "Игрок: 1\n" +
                "  01234\n" +
                "0      \n" +
                "1      \n" +
                "2 balda\n" +
                "3      \n" +
                "4      \n" +
                "Error\n" +
                "Ход: 1\n" +
                "Игрок: 2\n" +
                "  01234\n" +
                "0      \n" +
                "1  k   \n" +
                "2 balda\n" +
                "3      \n" +
                "4      \n" +
                "Exit\n"
    }
    "B: Step*2" {
        val input = "0 0 l ll\n1 1 . ..\n0\n"
        outputBuffer.reset() // очистка буфера
        game(ByteArrayInputStream(input.toByteArray()), output)
        outputBuffer.toString() shouldBe "Ход: 0\n" +
                "Игрок: 1\n" +
                "  01234\n" +
                "0      \n" +
                "1      \n" +
                "2 balda\n" +
                "3      \n" +
                "4      \n" +
                "Ход: 1\n" +
                "Игрок: 2\n" +
                "  01234\n" +
                "0 l    \n" +
                "1      \n" +
                "2 balda\n" +
                "3      \n" +
                "4      \n" +
                "Ход: 2\n" +
                "Игрок: 1\n" +
                "  01234\n" +
                "0 l    \n" +
                "1  .   \n" +
                "2 balda\n" +
                "3      \n" +
                "4      \n" +
                "Exit\n"
    }

    // крестики-нолики
    "XO: Step*2"{
        val input = "0 0\n1 1\n0\n"
        outputBuffer.reset() // очистка буфера
        game(ByteArrayInputStream(input.toByteArray()), output)
        outputBuffer.toString() shouldBe "Ход: 0\n" +
                "  012\n" +
                "0    \n" +
                "1    \n" +
                "2    \n" +
                "Ход: 1\n" +
                "  012\n" +
                "0 X  \n" +
                "1    \n" +
                "2    \n" +
                "Ход: 2\n" +
                "  012\n" +
                "0 X  \n" +
                "1  0 \n" +
                "2    \n" +
                "Exit\n"
    }
    "XO: Step+error" {
        val input = "0 0\n1 5\n0\n"
        outputBuffer.reset() // очистка буфера
        game(ByteArrayInputStream(input.toByteArray()), output)
        outputBuffer.toString() shouldBe "Ход: 0\n" +
                "  012\n" +
                "0    \n" +
                "1    \n" +
                "2    \n" +
                "Ход: 1\n" +
                "  012\n" +
                "0 X  \n" +
                "1    \n" +
                "2    \n" +
                "Error\n" +
                "Exit\n"
    }
    "XO: TakeBack" {
        val input = "0 0\n1 1\n-1 0\n0\n"
        outputBuffer.reset() // очистка буфера
        game(ByteArrayInputStream(input.toByteArray()), output)
        outputBuffer.toString() shouldBe "Ход: 0\n" +
                "  012\n" +
                "0    \n" +
                "1    \n" +
                "2    \n" +
                "Ход: 1\n" +
                "  012\n" +
                "0 X  \n" +
                "1    \n" +
                "2    \n" +
                "Ход: 2\n" +
                "  012\n" +
                "0 X  \n" +
                "1  0 \n" +
                "2    \n" +
                "RETURN:\n" +
                "Ход: 0\n" +
                "  012\n" +
                "0    \n" +
                "1    \n" +
                "2    \n" +
                "Exit\n"
    }
    "XO: TakeBack+error" {
        val input = "0 0\n1 1\n-1 7\n-1 0\n0\n"
        outputBuffer.reset() // очистка буфера
        game(ByteArrayInputStream(input.toByteArray()), output)
        outputBuffer.toString() shouldBe "Ход: 0\n" +
                "  012\n" +
                "0    \n" +
                "1    \n" +
                "2    \n" +
                "Ход: 1\n" +
                "  012\n" +
                "0 X  \n" +
                "1    \n" +
                "2    \n" +
                "Ход: 2\n" +
                "  012\n" +
                "0 X  \n" +
                "1  0 \n" +
                "2    \n" +
                "Error\n" +
                "Ход: 2\n" +
                "  012\n" +
                "0 X  \n" +
                "1  0 \n" +
                "2    \n" +
                "RETURN:\n" +
                "Ход: 0\n" +
                "  012\n" +
                "0    \n" +
                "1    \n" +
                "2    \n" +
                "Exit\n"
    }
})