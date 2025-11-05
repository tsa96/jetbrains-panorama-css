package com.jetbrains.panorama

import com.intellij.psi.css.CssDialect

class PanoramaCssDialect : CssDialect() {
    override fun getName(): String = "PanoramaCSS"
    
    override fun getDisplayName(): String = "Panorama CSS"
    
    override fun getDialectId(): String = "PanoramaCSS"
}
