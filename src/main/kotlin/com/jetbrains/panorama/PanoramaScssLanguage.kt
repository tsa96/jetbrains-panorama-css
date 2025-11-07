package com.jetbrains.panorama

import com.intellij.lang.Language

class PanoramaScssLanguage private constructor() : Language("PanoramaSCSS") {
    override fun getDisplayName(): String = "Panorama SCSS"

    override fun isCaseSensitive(): Boolean = true

    companion object {
        @JvmField
        val INSTANCE = PanoramaScssLanguage()
    }
}
