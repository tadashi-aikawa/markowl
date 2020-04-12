package net.mamansoft.markowl.action.markdown

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import net.mamansoft.markowl.domain.OwlDocument
import net.mamansoft.markowl.util.width

class AddHeader1BorderAction : AnAction() {
    override fun update(e: AnActionEvent) {
        e.presentation.isEnabledAndVisible = e.project != null && e.getData(CommonDataKeys.EDITOR) != null
    }

    override fun actionPerformed(e: AnActionEvent) {
        val doc = OwlDocument(e)

        val border = "=".repeat(width(doc.currentLineText))
        doc.safeInsertToNextLine("${border}\n")
    }
}
