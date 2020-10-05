package net.mamansoft.markowl.action.markdown

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import net.mamansoft.markowl.domain.OwlDocument
import net.mamansoft.markowl.domain.drawHeaderPrefix

class DrawH5PrefixAction : AnAction() {
    override fun update(e: AnActionEvent) {
        e.presentation.isEnabledAndVisible = e.project != null && e.getData(CommonDataKeys.EDITOR) != null
    }

    override fun actionPerformed(e: AnActionEvent) = drawHeaderPrefix(OwlDocument(e), 5)
}
