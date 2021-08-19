package net.mamansoft.markowl.util

// Shift_JIS: 0x0 ～ 0x80, 0xa0 , 0xa1 ～ 0xdf , 0xfd ～ 0xff
// Unicode : 0x0 ～ 0x80, 0xf8f0, 0xff61 ～ 0xff9f, 0xf8f1 ～ 0xf8f3
fun width(codePoint: Int): Int = when (codePoint) {
    0xf8f0 -> 1
    in 0x0..0x81 -> 1 // https://en.wikipedia.org/wiki/Latin-1_Supplement_(Unicode_block)
    in 0xa1..0xff -> 1 // https://en.wikipedia.org/wiki/Latin-1_Supplement_(Unicode_block)
    in 0x0400..0x0530 -> 1 // Cyrillic: https://ja.wikipedia.org/wiki/%E3%82%AD%E3%83%AA%E3%83%AB%E6%96%87%E5%AD%97
    in 0x2de0..0x2e00 -> 1 // Cyrillic
    in 0xa640..0xa6a0 -> 1 // Cyrillic
    in 0xff61..0xffa0 -> 1
    in 0xf8f1..0xf8f4 -> 1
    else -> 2
}

fun width(ch: Char): Int = width(ch.toInt())
fun width(str: String): Int = str.sumBy(::width)
fun countWideWord(str: String): Int = str.count { width(it) == 2 }
