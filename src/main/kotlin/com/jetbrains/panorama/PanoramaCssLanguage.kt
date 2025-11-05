package com.jetbrains.panorama

import com.intellij.lang.Language
import com.intellij.lang.css.CSSLanguage

class PanoramaCssLanguage private constructor() : Language(CSSLanguage.INSTANCE, "PanoramaCSS") {
    override fun getDisplayName(): String = "Panorama CSS"
    
    override fun isCaseSensitive(): Boolean = true
    
    companion object {
        @JvmField
        val INSTANCE = PanoramaCssLanguage()
    }
}
