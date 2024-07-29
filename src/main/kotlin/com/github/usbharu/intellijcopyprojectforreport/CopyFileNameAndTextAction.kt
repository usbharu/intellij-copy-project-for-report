package com.github.usbharu.intellijcopyprojectforreport

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ide.CopyPasteManager
import com.intellij.openapi.vfs.readText
import java.awt.datatransfer.StringSelection


class CopyFileNameAndTextAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val virtualFile = e.getRequiredData(CommonDataKeys.VIRTUAL_FILE)

        val readText = virtualFile.readText()

        val project = e.getRequiredData(CommonDataKeys.PROJECT)


        // pathの取得
        val absolutePath = virtualFile.name
        val basePath = project.basePath ?: ""
        val text = absolutePath + "\n\n" + readText
        // clipboardへのコピー
        CopyPasteManager.getInstance().setContents(StringSelection(text))
    }
}