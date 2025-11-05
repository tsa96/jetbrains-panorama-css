package com.jetbrains.panorama

import com.intellij.util.indexing.*
import com.intellij.util.io.EnumeratorStringDescriptor
import com.intellij.util.io.KeyDescriptor
import com.intellij.openapi.vfs.VirtualFile

class PanoramaCssFileIndex : ScalarIndexExtension<String>() {
    override fun getName(): ID<String, Void> = NAME
    
    override fun getIndexer(): DataIndexer<String, Void, FileContent> {
        return DataIndexer { inputData ->
            val file = inputData.file
            // Simple index for CSS/SCSS files - users will explicitly assign Panorama types
            if (file.extension == "css" || file.extension == "scss") {
                mapOf(file.name to null)
            } else {
                emptyMap()
            }
        }
    }
    
    override fun getKeyDescriptor(): KeyDescriptor<String> = EnumeratorStringDescriptor.INSTANCE
    
    override fun getInputFilter(): FileBasedIndex.InputFilter {
        return FileBasedIndex.InputFilter { file ->
            file.extension == "css" || file.extension == "scss"
        }
    }
    
    override fun dependsOnFileContent(): Boolean = false
    
    override fun getVersion(): Int = 1
    
    companion object {
        val NAME: ID<String, Void> = ID.create("PanoramaCssFileIndex")
    }
}
