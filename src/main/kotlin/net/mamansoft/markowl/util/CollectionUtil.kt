package net.mamansoft.markowl.util

/**
 * [ ["a"],["i","u"],["i","u","e"] ] -> [ ["a","i","i"], ["","u","u"], ["","","e"] ]
 */
fun inverse(rows: List<List<String>>): List<List<String>> {
  val maxColumnNums = rows.map { it.size }.max() ?: 0
  val columns = MutableList<MutableList<String>>(maxColumnNums) { mutableListOf<String>() }
  for (row in rows) {
    for ((colIndex, cell) in row.fillEmpty(maxColumnNums).withIndex()) {
      columns[colIndex].add(cell)
    }
  }
  return columns
}
