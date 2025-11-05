# jetbrains-panorama-css

[![Build Plugin](https://github.com/tsa96/jetbrains-panorama-css/actions/workflows/build.yml/badge.svg)](https://github.com/tsa96/jetbrains-panorama-css/actions/workflows/build.yml)
[![Code Quality](https://github.com/tsa96/jetbrains-panorama-css/actions/workflows/quality.yml/badge.svg)](https://github.com/tsa96/jetbrains-panorama-css/actions/workflows/quality.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

A JetBrains plugin (for WebStorm, IntelliJ IDEA, etc.) that adds support for Panorama CSS and SCSS - a CSS variant used in Valve's Source 1/2 game engines.

## About Panorama

Panorama is a UI framework developed and used by Valve Software for games including CS:GO, Dota 2, and other Source engine games. It uses a subset of CSS3 with custom properties specific to the game engine.

## Features

- Syntax highlighting for Panorama CSS and SCSS
- Code completion for Panorama-specific properties
- Property validation for Panorama CSS properties
- Support for all 120+ Panorama CSS properties from the official Valve documentation

## Usage

After installing the plugin, you can:
1. Right-click on a .css or .scss file in your project
2. Select "Override File Type" from the context menu
3. Choose "Panorama CSS" or "Panorama SCSS" as appropriate

Or configure file associations globally in:
`Settings > Editor > File Types > Panorama CSS/SCSS`

## Derived From

This plugin is derived from the [vscode-panorama-css](https://github.com/panorama-languages-support/vscode-panorama-css) VSCode extension, using the same Panorama CSS property definitions.

## License

MIT License - See LICENSE file for details.