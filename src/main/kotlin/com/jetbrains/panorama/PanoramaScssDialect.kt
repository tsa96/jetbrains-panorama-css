package com.jetbrains.panorama

/**
 * Simple placeholder for Panorama SCSS dialect metadata.
 *
 * The original implementation extended the IDE's CssDialect. That type may
 * not be available in all IDE distributions used for compilation, so we
 * keep a lightweight class here. Wiring to the platform's dialect API is
 * deferred until a specific target IDEA version is chosen.
 */
class PanoramaScssDialect {
    fun name(): String = "PanoramaSCSS"
    fun displayName(): String = "Panorama SCSS"
    fun dialectId(): String = "PanoramaSCSS"
}
