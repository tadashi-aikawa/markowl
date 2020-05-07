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
    val lastLineOffset: Int
        get() = DocumentUtil.getLineTextRange(this.document, this.lastLine).endOffset
    val currentLine: Int
        get() = this.editor.visualToLogicalPosition(this.currentCaret.selectionEndPosition).line
    val isLastLine: Boolean
        get() = this.currentLine == this.lastLine
    val currentLineText: String
        get() = getTextByLine(this.currentLine)
    val currentLineEndOffset: Int
        get() = DocumentUtil.getLineEndOffset(this.currentCaret.offset, this.editor.document)
    val nextLineOffset: Int
        get() = this.currentLineEndOffset.plus(1)
    val nextLineRange: TextRange
        get() =  DocumentUtil.getLineTextRange(this.document, this.currentLine + 1)
    val nextLineText: String?
        get() = if (this.isLastLine) null else this.getTextByRange(this.nextLineRange)


    fun getTextByRange(range: TextRange): String = this.document.getText(range)
    fun getTextByLine(line: Int): String = this.document.getText(DocumentUtil.getLineTextRange(this.document, line))
    fun getLineStartOffset(line: Int): Int = this.document.getLineStartOffset(line)
    fun getLineEndOffset(line: Int): Int = this.document.getLineEndOffset(line)

    fun safeReplace(range: TextRange, text: String) {
        WriteCommandAction.runWriteCommandAction(this.project) {
            this.editor.document.replaceString(range.startOffset, range.endOffset, text)
        }
    }

    fun safeReplaceToNextLine(text: String) = this.safeReplace(nextLineRange, text)

    fun safeInsertToNextLine(text: String) {
        WriteCommandAction.runWriteCommandAction(this.project) {
            this.editor.document.insertString(currentLineEndOffset, "\n${text}")
        }
    }

    fun moveEOF() {
        this.currentCaret.moveToOffset(this.lastLineOffset)
    }
}

