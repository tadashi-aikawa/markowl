package net.mamansoft.markowl.util

fun inverse(rows: List<List<String>>): List<List<String>> {
    val columns = MutableList<MutableList<String>>(rows[0].size) { mutableListOf<String>() }
    for (row in rows) {
        for ((colIndex, cell) in row.withIndex()) {
            columns[colIndex].add(cell)
        }
    }
    return columns
}
