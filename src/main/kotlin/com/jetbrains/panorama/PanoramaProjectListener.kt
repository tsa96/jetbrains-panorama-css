package com.jetbrains.panorama

import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener

class PanoramaProjectListener : ProjectManagerListener {
    override fun projectOpened(project: Project) {
        // Initialize Panorama CSS support when project opens
    }
    
    override fun projectClosed(project: Project) {
        // Cleanup if needed
    }
}
