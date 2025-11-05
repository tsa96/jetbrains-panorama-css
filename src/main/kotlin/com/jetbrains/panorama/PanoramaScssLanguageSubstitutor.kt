package com.jetbrains.panorama

import com.intellij.lang.Language
import com.intellij.lang.LanguageSubstitutor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

/**
 * Language substitutor for Panorama SCSS files.
 * 
 * This implementation returns null, which means no automatic language substitution occurs.
 * Users must manually assign files to the Panorama SCSS language type via:
 * - Right-click file → "Override File Type" → "Panorama SCSS"
 * - Or configure file patterns in: Settings → Editor → File Types → Panorama SCSS
 */
class PanoramaScssLanguageSubstitutor : LanguageSubstitutor() {
    override fun getLanguage(file: VirtualFile, project: Project): Language? {
        // Users will explicitly assign file types in IDE settings
        // This is just a placeholder for the extension point
        return null
    }
}
