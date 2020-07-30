package net.mamansoft.markowl.util

import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.Test
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class EnglishTest(private val arg: String, private val expected: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf("HOGE", 4),
            arrayOf("hoge", 4)
        )
    }

    @Test
    fun test() {
        assertEquals(expected, width(arg))
    }
}

@RunWith(Parameterized::class)
class JapaneseTest(private val arg: String, private val expected: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf("ほげ", 4),
            arrayOf("ホゲﾎｹﾞ", 7),
            arrayOf("保毛★", 6)
        )
    }

    @Test
    fun test() {
        assertEquals(expected, width(arg))
    }
}


@RunWith(Parameterized::class)
class CyrillicTest(private val arg: String, private val expected: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf("Ѐԯ", 2),
            arrayOf("Ꙁꚝ", 2),
            arrayOf("Файл", 4),
            arrayOf("коллекции", 9),
            arrayOf("Описание", 8),
            arrayOf("Директория invoke-коллекций", 27)
        )
    }

    @Test
    fun test() {
        assertEquals(expected, width(arg))
    }
}

