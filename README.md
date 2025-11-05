# JetBrains Panorama CSS Plugin

A JetBrains IDE plugin that adds support for Panorama CSS/SCSS, based on the [VSCode Panorama CSS extension](https://github.com/panorama-languages-support/vscode-panorama-css).

## About

Panorama is a UI framework used in Valve's Source 1/2 game engines (CS:GO, Dota 2, etc.) that uses a CSS variant with custom properties. This plugin provides syntax support and property definitions for Panorama CSS/SCSS in JetBrains IDEs.

## Building

```bash
./gradlew build
```

## Installation

1. Build the plugin: `./gradlew buildPlugin`
2. In your JetBrains IDE: Settings > Plugins > Gear icon > Install Plugin from Disk
3. Select the ZIP file from `build/distributions/`
4. Restart the IDE

## License

MIT License
