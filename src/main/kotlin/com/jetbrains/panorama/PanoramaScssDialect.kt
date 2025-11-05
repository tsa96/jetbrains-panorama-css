package com.jetbrains.panorama

import com.intellij.psi.css.CssDialect

class PanoramaScssDialect : CssDialect() {
    override fun getName(): String = "PanoramaSCSS"
    
    override fun getDisplayName(): String = "Panorama SCSS"
    
    override fun getDialectId(): String = "PanoramaSCSS"
}
