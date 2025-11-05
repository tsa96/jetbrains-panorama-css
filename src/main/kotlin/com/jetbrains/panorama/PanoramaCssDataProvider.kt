package com.jetbrains.panorama

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.css.impl.util.completion.CssJsonDataLoader
import com.intellij.psi.css.impl.util.completion.CssJsonPropertyDescriptor
import com.intellij.psi.css.impl.util.completion.CssPropertyDescriptor
import com.intellij.psi.css.descriptor.CssContextualPropertyDescriptor
import com.intellij.psi.css.impl.util.CssDataProvider
import org.jetbrains.annotations.NotNull

class PanoramaCssDataProvider : CssDataProvider {
    private val propertyDescriptors: List<CssPropertyDescriptor> by lazy {
        loadPanoramaProperties()
    }
    
    override fun getPropertyDescriptors(): Collection<CssPropertyDescriptor> {
        return propertyDescriptors
    }
    
    override fun getDescriptor(propertyName: String): CssPropertyDescriptor? {
        return propertyDescriptors.firstOrNull { 
            it.name.equals(propertyName, ignoreCase = false) 
        }
    }
    
    private fun loadPanoramaProperties(): List<CssPropertyDescriptor> {
        try {
            val resourceStream = javaClass.classLoader.getResourceAsStream("cssData/panorama-css-data.json")
                ?: return emptyList()
            
            val jsonContent = resourceStream.bufferedReader().use { it.readText() }
            
            // Parse the JSON and extract properties
            return CssJsonDataLoader.loadPropertiesFromJson(jsonContent)
        } catch (e: Exception) {
            e.printStackTrace()
            return emptyList()
        }
    }
}
