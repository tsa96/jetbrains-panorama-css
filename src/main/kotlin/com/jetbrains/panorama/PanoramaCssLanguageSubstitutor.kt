package com.jetbrains.panorama

import com.intellij.lang.Language
import com.intellij.lang.LanguageSubstitutor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

/**
 * Language substitutor for Panorama CSS files.
 * 
 * This implementation returns null, which means no automatic language substitution occurs.
 * Users must manually assign files to the Panorama CSS language type via:
 * - Right-click file → "Override File Type" → "Panorama CSS"
 * - Or configure file patterns in: Settings → Editor → File Types → Panorama CSS
 */
class PanoramaCssLanguageSubstitutor : LanguageSubstitutor() {
    override fun getLanguage(file: VirtualFile, project: Project): Language? {
        // Users will explicitly assign file types in IDE settings
        // This is just a placeholder for the extension point
        return null
    }
}
