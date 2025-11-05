package com.jetbrains.panorama

import com.intellij.lang.Language
import com.intellij.lang.css.SCSSLanguage

class PanoramaScssLanguage private constructor() : Language(SCSSLanguage.INSTANCE, "PanoramaSCSS") {
    override fun getDisplayName(): String = "Panorama SCSS"
    
    override fun isCaseSensitive(): Boolean = true
    
    companion object {
        @JvmField
        val INSTANCE = PanoramaScssLanguage()
    }
}
