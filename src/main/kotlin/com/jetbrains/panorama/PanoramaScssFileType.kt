package com.jetbrains.panorama

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

class PanoramaScssFileType private constructor() : LanguageFileType(PanoramaScssLanguage.INSTANCE) {
    override fun getName(): String = "Panorama SCSS"
    override fun getDescription(): String = "Panorama SCSS file"
    override fun getDefaultExtension(): String = "scss"
    override fun getIcon(): Icon? = null
    
    override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"

    companion object {
        @JvmField
        val INSTANCE = PanoramaScssFileType()
    }
}
