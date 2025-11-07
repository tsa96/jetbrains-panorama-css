package com.jetbrains.panorama

import com.intellij.openapi.diagnostic.Logger
import com.google.gson.Gson
import com.google.gson.JsonObject

/**
 * Loads Panorama CSS property definitions from the bundled JSON resource.
 *
 * NOTE: The original implementation used internal IDE CSS APIs to expose
 * custom property descriptors to the platform. Those APIs vary between
 * IDE versions and may not be available in the current compilation
 * environment. To keep the project building, this class only parses and
 * exposes the raw JSON data for future wiring.
 */
class PanoramaCssDataProvider {
    private val logger = Logger.getInstance(PanoramaCssDataProvider::class.java)

    val propertiesJson: JsonObject? by lazy {
        loadPanoramaProperties()
    }

    private fun loadPanoramaProperties(): JsonObject? {
        try {
            val resourceStream = javaClass.classLoader.getResourceAsStream("cssData/panorama-css-data.json")
            if (resourceStream == null) {
                logger.warn("Could not find panorama-css-data.json resource")
                return null
            }

            val jsonContent = resourceStream.bufferedReader().use { it.readText() }
            logger.info("Loaded Panorama CSS data, size: ${jsonContent.length} bytes")

            val gson = Gson()
            return gson.fromJson(jsonContent, JsonObject::class.java)
        } catch (e: Exception) {
            logger.error("Error loading Panorama CSS properties", e)
            return null
        }
    }
}
