package com.jetbrains.panorama

import com.intellij.lang.Language

class PanoramaCssLanguage private constructor() : Language("PanoramaCSS") {
    override fun getDisplayName(): String = "Panorama CSS"

    override fun isCaseSensitive(): Boolean = true

    companion object {
        @JvmField
        val INSTANCE = PanoramaCssLanguage()
    }
}
