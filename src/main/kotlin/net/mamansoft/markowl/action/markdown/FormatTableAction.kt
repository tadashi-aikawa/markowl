package net.mamansoft.markowl.action.markdown

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.util.TextRange
import net.mamansoft.markowl.domain.OwlDocument
import net.mamansoft.markowl.util.countWideWord
import net.mamansoft.markowl.util.inverse
import net.mamansoft.markowl.util.width

fun formatTable(tableStr: String): String {
    val rows = tableStr.split("\n")
        .map { it.trim('|').split('|').map { v -> v.trim() } }
    val columns = inverse(rows)
    val columnWidths = columns.map { it.map(::width).max() ?: 0 }

    return rows.mapIndexed { rowIndex, row ->
        when (rowIndex) {
            1 -> row.mapIndexed { i, _ -> "-".repeat(columnWidths[i]) }
            else -> row.mapIndexed { i, value -> "%-${columnWidths[i].minus(countWideWord(value))}s".format(value) }
        }
    }.joinToString("\n") { row -> "| ${row.joinToString(" | ")} |" }
}

fun getRangeAsTable(doc: OwlDocument): TextRange {
    val startTableLine = (doc.currentLine downTo 0)
        .find { doc.getTextByLine(it).isEmpty() }?.plus(1) ?: 1
    val endTableLine = (doc.currentLine..doc.lastLine)
        .find { doc.getTextByLine(it).isEmpty() }?.minus(1) ?: doc.lastLine

    return TextRange(doc.getLineStartOffset(startTableLine), doc.getLineEndOffset(endTableLine))
}

class FormatTableAction : AnAction() {
    override fun update(e: AnActionEvent) {
        e.presentation.isEnabledAndVisible = e.project != null && e.getData(CommonDataKeys.EDITOR) != null
    }

    override fun actionPerformed(e: AnActionEvent) {
        val doc = OwlDocument(e)

        val tableRange = getRangeAsTable(doc)
        doc.safeReplace(tableRange, formatTable(doc.getTextByRange(tableRange)))
    }
}
