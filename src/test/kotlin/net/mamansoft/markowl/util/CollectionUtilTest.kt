package net.mamansoft.markowl.util

import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testEnglish() {
        assertEquals(width("hoge"), 4)
    }

    @Test
    fun testJapanese() {
        assertEquals(4, width("ほげ"))
        assertEquals(7, width("ホゲﾎｹﾞ"))
        assertEquals(4, width("保毛"))
    }
}
