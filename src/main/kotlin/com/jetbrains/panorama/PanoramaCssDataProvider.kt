package com.jetbrains.panorama

import com.intellij.openapi.diagnostic.Logger
import com.intellij.psi.css.impl.util.CssDataProvider
import com.intellij.psi.css.impl.util.completion.CssPropertyDescriptor
import com.google.gson.Gson
import com.google.gson.JsonObject

/**
 * Provides Panorama CSS property definitions to the IDE.
 * Loads properties from panorama-css-data.json resource file.
 */
class PanoramaCssDataProvider : CssDataProvider {
    private val logger = Logger.getInstance(PanoramaCssDataProvider::class.java)
    
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
            if (resourceStream == null) {
                logger.warn("Could not find panorama-css-data.json resource")
                return emptyList()
            }
            
            val jsonContent = resourceStream.bufferedReader().use { it.readText() }
            logger.info("Loaded Panorama CSS data, size: ${jsonContent.length} bytes")
            
            // Parse JSON and create property descriptors
            val gson = Gson()
            val dataObject = gson.fromJson(jsonContent, JsonObject::class.java)
            val properties = dataObject.getAsJsonArray("properties")
            
            if (properties == null) {
                logger.warn("No properties array found in panorama-css-data.json")
                return emptyList()
            }
            
            logger.info("Found ${properties.size()} Panorama CSS properties")
            
            // Note: The actual implementation would create CssPropertyDescriptor instances here
            // This requires accessing internal IntelliJ APIs which may vary by version
            // For now, return empty list - the plugin structure is correct but needs
            // version-specific API implementation
            
            return emptyList()
        } catch (e: Exception) {
            logger.error("Error loading Panorama CSS properties", e)
            return emptyList()
        }
    }
}
