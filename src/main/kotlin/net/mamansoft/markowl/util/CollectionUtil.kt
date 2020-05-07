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

inline fun <reified T : Any> List<T>.fillUntil(element: T, maxSize: Int): List<T> {
    return this + List<T>(maxSize - this.size) { element }
}

fun List<String>.fillEmpty(maxSize: Int): List<String> {
    return this.fillUntil("", maxSize)
}
