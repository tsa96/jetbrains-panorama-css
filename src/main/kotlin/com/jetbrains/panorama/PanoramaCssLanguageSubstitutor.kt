package com.jetbrains.panorama

import com.intellij.lang.Language
import com.intellij.lang.LanguageSubstitutor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class PanoramaCssLanguageSubstitutor : LanguageSubstitutor() {
    override fun getLanguage(file: VirtualFile, project: Project): Language? {
        // Users will explicitly assign file types in IDE settings
        // This is just a placeholder for the extension point
        return null
    }
}
