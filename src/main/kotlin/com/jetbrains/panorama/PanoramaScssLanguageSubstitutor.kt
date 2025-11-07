package com.jetbrains.panorama

import com.intellij.lang.Language
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

/**
 * Placeholder for a language substitutor for Panorama SCSS files.
 *
 * The real substitutor would extend the IDE's LanguageSubstitutor type
 * and return an appropriate Language for files. To keep compilation
 * portable across IDEA versions, this is a no-op helper class.
 */
class PanoramaScssLanguageSubstitutor {
    fun getLanguage(file: VirtualFile, project: Project): Language? {
        return null
    }
}
