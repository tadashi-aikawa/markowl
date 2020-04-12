package net.mamansoft.markowl.domain

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Caret
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.util.DocumentUtil


class OwlDocument constructor(e: AnActionEvent) {
    private val project: Project = e.getRequiredData(CommonDataKeys.PROJECT)
    private val editor: Editor = e.getRequiredData(CommonDataKeys.EDITOR)
    private val document: Document = editor.document

    val currentCaret: Caret
        get() = this.editor.caretModel.currentCaret
    val lastLine: Int
        get() = this.document.lineCount - 1
    val currentLine: Int
        get() = this.currentCaret.selectionEndPosition.line
    val currentLineText: String
        get() = getTextByLine(this.currentLine)
    val nextLineOffset: Int
        get() = DocumentUtil.getLineEndOffset(this.currentCaret.selectionEnd, this.editor.document).plus(1)

    fun getTextByRange(range: TextRange) = this.document.getText(range)
    fun getTextByLine(line: Int): String = this.document.getText(DocumentUtil.getLineTextRange(this.document, line))
    fun getLineStartOffset(line: Int): Int = this.document.getLineStartOffset(line)
    fun getLineEndOffset(line: Int): Int = this.document.getLineEndOffset(line)

    fun safeReplace(range: TextRange, text: String) {
        WriteCommandAction.runWriteCommandAction(this.project) {
            this.editor.document.replaceString(range.startOffset, range.endOffset, text)
        }
    }

    fun safeInsertToNextLine(text: String) {
        WriteCommandAction.runWriteCommandAction(this.project) {
            this.editor.document.insertString(this.nextLineOffset, text)
        }
    }
}

