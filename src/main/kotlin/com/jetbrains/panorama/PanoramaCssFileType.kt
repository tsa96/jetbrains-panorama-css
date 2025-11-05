package com.jetbrains.panorama

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

class PanoramaCssFileType private constructor() : LanguageFileType(PanoramaCssLanguage.INSTANCE) {
    override fun getName(): String = "Panorama CSS"
    override fun getDescription(): String = "Panorama CSS file"
    override fun getDefaultExtension(): String = "css"
    override fun getIcon(): Icon? = null
    
    override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"

    companion object {
        @JvmField
        val INSTANCE = PanoramaCssFileType()
    }
}
