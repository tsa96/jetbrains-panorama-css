# JetBrains Panorama CSS Plugin - Development Guide

## Overview

This plugin adds support for Panorama CSS and SCSS to JetBrains IDEs (WebStorm, IntelliJ IDEA, etc.). Panorama is a UI framework used in Valve's Source 1/2 game engines (CS:GO, Dota 2, etc.) that uses a CSS variant with custom properties.

## Architecture

### Core Components

1. **Language Definitions**
   - `PanoramaCssLanguage.kt` - Defines Panorama CSS as a language (extends CSS)
   - `PanoramaScssLanguage.kt` - Defines Panorama SCSS as a language (extends SCSS)

2. **File Types**
   - `PanoramaCssFileType.kt` - File type for .css files using Panorama dialect
   - `PanoramaScssFileType.kt` - File type for .scss files using Panorama dialect

3. **CSS Dialects**
   - `PanoramaCssDialect.kt` - CSS dialect implementation for Panorama CSS
   - `PanoramaScssDialect.kt` - CSS dialect implementation for Panorama SCSS

4. **Language Substitutors**
   - `PanoramaCssLanguageSubstitutor.kt` - Placeholder for CSS language substitution
   - `PanoramaScssLanguageSubstitutor.kt` - Placeholder for SCSS language substitution
   - Note: Users manually assign file types; no automatic detection

5. **Data Provider**
   - `PanoramaCssDataProvider.kt` - Loads Panorama CSS properties from JSON
   - Provides property completion, validation, and documentation

6. **Supporting Classes**
   - `PanoramaCssFileIndex.kt` - Indexes CSS/SCSS files for the plugin
   - `PanoramaProjectListener.kt` - Project lifecycle listener

### Data Files

- `src/main/resources/cssData/panorama-css-data.json` - 120+ Panorama CSS properties extracted from the VSCode plugin
  - Properties include: align, animation-*, background-*, blur, brightness, flow-children, ui-scale-*, wash-color, etc.
  - Each property includes:
    - Name
    - Description
    - Valid values
    - Syntax
    - References to VDC (Valve Developer Community) documentation

## How It Works

1. **Language Hierarchy**: Panorama CSS/SCSS inherit from standard CSS/SCSS, gaining all standard CSS features
2. **Custom Properties**: The `PanoramaCssDataProvider` loads Panorama-specific properties from JSON
3. **User Assignment**: Users explicitly assign files to use Panorama CSS/SCSS type via IDE settings
4. **Code Completion**: IDE provides completion for Panorama properties using the custom data
5. **Validation**: IDE validates against Panorama property definitions

## Building the Plugin

### Prerequisites
- JDK 17
- Gradle 8.2+ (included via wrapper)
- Internet access to download IntelliJ Platform SDK

### Build Commands

```bash
# Build the plugin
./gradlew build

# Run the plugin in a sandboxed IDE
./gradlew runIde

# Build the plugin distribution ZIP
./gradlew buildPlugin
```

The built plugin will be in `build/distributions/`.

### CI/CD

The project uses GitHub Actions for automated builds and releases. See [CI_CD.md](CI_CD.md) for:
- Automated build and test workflows
- Release automation
- JetBrains Marketplace publishing
- Code quality checks

To trigger a build on CI, simply push to `main` or `develop`, or create a pull request.

### Installation

1. Build the plugin: `./gradlew buildPlugin`
2. In your JetBrains IDE: Settings > Plugins > Gear icon > Install Plugin from Disk
3. Select the ZIP file from `build/distributions/`
4. Restart the IDE

## Usage

### Assigning Panorama File Types

**Method 1: Per File**
1. Right-click on a .css or .scss file
2. Select "Override File Type"
3. Choose "Panorama CSS" or "Panorama SCSS"

**Method 2: Global Association**
1. Go to Settings > Editor > File Types
2. Select "Panorama CSS" or "Panorama SCSS"
3. Add file patterns (e.g., `*.css` for specific directories)

### Features

Once a file is assigned the Panorama type:
- Autocomplete for Panorama-specific properties (e.g., `align`, `flow-children`, `ui-scale-x`)
- Property validation
- Hover documentation with links to VDC
- Syntax highlighting for CSS/SCSS with Panorama extensions

## Property List

The plugin supports 120+ Panorama-specific CSS properties, including:

**Layout & Positioning:**
- `align` - Horizontal and vertical positioning
- `flow-children` - Child element flow direction
- `horizontal-align`, `vertical-align`

**Visual Effects:**
- `blur` - Gaussian/fast gaussian blur
- `brightness` - Brightness adjustment
- `contrast` - Contrast adjustment
- `hue-rotation` - Hue rotation
- `saturation` - Saturation adjustment
- `wash-color`, `wash-color-fast` - Color washing effects

**Transforms:**
- `pre-transform-rotate2d` - 2D rotation before other transforms
- `pre-transform-scale2d` - 2D scaling before other transforms
- `ui-scale`, `ui-scale-x`, `ui-scale-y`, `ui-scale-z` - UI scaling

**UI-Specific:**
- `context-menu-*` - Context menu positioning
- `tooltip-*` - Tooltip positioning
- `sound`, `sound-out`, `sound-trans` - UI sound effects
- `texture-sampling` - Texture sampling mode

**Background:**
- `background-img-opacity` - Separate opacity for background images
- All standard CSS background properties

**And many more!** See `src/main/resources/cssData/panorama-css-data.json` for the complete list.

## Contributing

### Adding New Properties

1. Edit `src/main/resources/cssData/panorama-css-data.json`
2. Add property definition following the format:
```json
{
  "name": "property-name",
  "description": "Description of the property",
  "syntax": "value1 | value2",
  "values": [
    {
      "name": "value1",
      "description": "Description of value1"
    }
  ],
  "references": [
    {
      "name": "VDC Reference",
      "url": "https://developer.valvesoftware.com/wiki/..."
    }
  ],
  "restrictions": ["enum", "length", "color", etc.]
}
```
3. Rebuild the plugin

### Testing

Currently, testing must be done manually:
1. Build and install the plugin
2. Open a project with CSS/SCSS files
3. Assign Panorama file types
4. Verify autocomplete, validation, and documentation work

## Known Limitations

1. **No Automatic Detection**: Files must be manually assigned to Panorama CSS/SCSS types
2. **Build Dependencies**: Requires internet access to download IntelliJ Platform SDK during build
3. **No Syntax Highlighting Customization**: Uses standard CSS/SCSS syntax highlighting
4. **Property Descriptors**: The `PanoramaCssDataProvider` currently loads the JSON data but doesn't create property descriptors. This requires using internal IntelliJ APIs that vary by version. The JSON data is correctly formatted and ready for integration once the proper API access is implemented.

## References

- **Source VSCode Plugin**: https://github.com/panorama-languages-support/vscode-panorama-css
- **Valve Developer Community**: https://developer.valvesoftware.com/wiki/Panorama
- **CS:GO Panorama CSS Properties**: https://developer.valvesoftware.com/wiki/CSGO_Panorama_CSS_Properties
- **JetBrains Plugin Development**: https://plugins.jetbrains.com/docs/intellij/

## License

MIT License - See LICENSE file
