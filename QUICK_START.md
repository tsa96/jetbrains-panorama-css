# Quick Start Guide

## Installation

### From Source
1. Clone this repository
2. Run `./gradlew buildPlugin`
3. In your JetBrains IDE:
   - Go to **Settings** > **Plugins**
   - Click the gear icon ⚙️
   - Select **Install Plugin from Disk...**
   - Choose the ZIP file from `build/distributions/`
   - Restart your IDE

### From JetBrains Marketplace (when published)
1. Open **Settings** > **Plugins**
2. Search for "Panorama CSS"
3. Click **Install**
4. Restart your IDE

## First Time Setup

### Option 1: Assign Individual Files
1. Right-click on a `.css` or `.scss` file in your Panorama project
2. Select **Override File Type**
3. Choose **Panorama CSS** or **Panorama SCSS**
4. The file will now use Panorama property definitions

### Option 2: Configure File Patterns (Recommended for Projects)
1. Go to **Settings** (Ctrl+Alt+S / Cmd+,)
2. Navigate to **Editor** > **File Types**
3. Find **Panorama CSS** in the list
4. Click the **+** button to add a file pattern
5. Add patterns like:
   - `*.css` (if all CSS files in project are Panorama)
   - `panorama/*.css` (for files in specific directory)
   - `*_panorama.css` (for files with specific naming)
6. Repeat for **Panorama SCSS** if using SCSS

## Using the Plugin

### Code Completion
Start typing a Panorama property name and press Ctrl+Space:

```css
.panel {
    ali[Ctrl+Space]  /* Shows: align */
    flow-[Ctrl+Space]  /* Shows: flow-children */
    ui-s[Ctrl+Space]  /* Shows: ui-scale, ui-scale-x, ui-scale-y, ui-scale-z */
}
```

### Property Documentation
Hover over any Panorama property to see:
- Property description
- Valid values
- Links to VDC (Valve Developer Community) documentation

### Example Workflow

1. Create or open a `.css` file in your Panorama project

2. Assign it as **Panorama CSS** (right-click > Override File Type)

3. Start writing Panorama CSS:

```css
/* Layout with Panorama properties */
#MainMenu {
    align: center middle;
    flow-children: down;
    width: 400px;
    height: 600px;
}

/* Button with effects */
.Button {
    horizontal-align: center;
    background-color: #333333;
    background-img-opacity: 0.8;
    
    /* Panorama-specific effects */
    wash-color: #ffffff;
    brightness: 1.2;
    
    /* Sound effects */
    sound: "ui_button_click";
    sound-out: "ui_button_hover_out";
}

/* Animated panel */
.AnimatedPanel {
    pre-transform-scale2d: 0.5;
    animation: slideIn 0.3s ease-out;
}
```

4. Get autocomplete for all Panorama properties:
   - `align`
   - `flow-children`
   - `background-img-opacity`
   - `wash-color`, `brightness`, `contrast`, `saturation`
   - `ui-scale-x`, `ui-scale-y`, `ui-scale-z`
   - `sound`, `sound-out`, `sound-trans`
   - And 100+ more!

## Common Panorama Patterns

### Center a Panel
```css
.centered {
    align: center middle;
    horizontal-align: center;
    vertical-align: center;
}
```

### Vertical List of Items
```css
.list {
    flow-children: down;
    width: 100%;
}
```

### Hover Effect with Wash Color
```css
.hoverable {
    wash-color: transparent;
    transition: wash-color 0.2s;
}

.hoverable:hover {
    wash-color: rgba(255, 255, 255, 0.1);
}
```

### Tooltip Positioning
```css
.tooltip {
    tooltip-position: 0px 10px 0px;
    tooltip-arrow-position: 50% 0%;
}
```

### UI Scaling
```css
.scaled-ui {
    ui-scale: 1.5; /* Uniform scaling */
}

.stretched-ui {
    ui-scale-x: 2.0;  /* Horizontal stretch */
    ui-scale-y: 1.0;  /* Normal vertical */
}
```

## Troubleshooting

### Properties Not Showing in Autocomplete

**Problem**: Panorama properties don't appear in autocomplete

**Solutions**:
1. Verify the file is assigned to **Panorama CSS** or **Panorama SCSS** type
   - Right-click file > **Override File Type** > Check current type
2. Restart the IDE after installing the plugin
3. Invalidate caches: **File** > **Invalidate Caches** > **Invalidate and Restart**

### File Type Not Available

**Problem**: "Panorama CSS" doesn't appear in file type list

**Solutions**:
1. Ensure the plugin is installed and enabled: **Settings** > **Plugins**
2. Restart the IDE
3. Check plugin compatibility with your IDE version (requires 2023.1+)

### Standard CSS Properties Not Working

**Problem**: Some standard CSS properties don't work in Panorama

**Note**: Panorama uses a **subset** of CSS3. Not all standard CSS properties are supported. Refer to the [Valve Developer Community documentation](https://developer.valvesoftware.com/wiki/CSGO_Panorama_CSS_Properties) for supported properties.

### Wrong Syntax Highlighting

**Problem**: Syntax highlighting looks wrong

**Solution**: The plugin uses standard CSS/SCSS syntax highlighting. Panorama CSS is syntactically identical to CSS, so this is expected behavior.

## Learning More

- **Panorama Properties Reference**: See `PANORAMA_PROPERTIES.md` for a complete list of Panorama-specific properties
- **Development Guide**: See `DEVELOPMENT.md` for plugin development details
- **Official Documentation**: https://developer.valvesoftware.com/wiki/Panorama
- **CS:GO Panorama CSS**: https://developer.valvesoftware.com/wiki/CSGO_Panorama_CSS_Properties

## Getting Help

- **Issues**: Report bugs at https://github.com/tsa96/jetbrains-panorama-css/issues
- **Discussions**: Ask questions in GitHub Discussions
- **VDC**: Valve Developer Community forums

## Contributing

Contributions are welcome! See `DEVELOPMENT.md` for information on:
- Building the plugin
- Adding new properties
- Testing changes
- Submitting pull requests
