# Panorama CSS Properties - Quick Reference

This document lists Panorama-specific CSS properties that differ from standard CSS.

## Panorama-Exclusive Properties

These properties are unique to Panorama CSS and not found in standard CSS:

### Layout & Flow
- **align**: `<horizontal-align> <vertical-align>` - Combined horizontal and vertical alignment
- **flow-children**: Controls how child elements flow (down, right, etc.)
- **horizontal-align**: Separate horizontal alignment
- **vertical-align**: Vertical alignment for panels

### Visual Effects
- **blur**: `gaussian()` | `fastgaussian()` - Blur effects
- **brightness**: Brightness adjustment
- **contrast**: Contrast adjustment  
- **hue-rotation**: Hue rotation effect
- **saturation**: Saturation adjustment
- **wash-color**: Color washing effect
- **wash-color-fast**: Faster color washing

### Transforms & Scaling
- **pre-transform-rotate2d**: 2D rotation applied before other transforms
- **pre-transform-scale2d**: 2D scaling applied before other transforms
- **ui-scale**: Uniform UI scaling
- **ui-scale-x**: Horizontal UI scaling
- **ui-scale-y**: Vertical UI scaling  
- **ui-scale-z**: Depth UI scaling

### Images & Opacity
- **background-img-opacity**: `<number>` - Background image opacity (0-1), separate from panel opacity
- **img-shadow**: Image shadow effects
- **opacity-mask**: Opacity mask
- **opacity-mask-scroll-down**: Opacity mask on scroll down
- **opacity-mask-scroll-up**: Opacity mask on scroll up
- **opacity-mask-scroll-up-down**: Opacity mask on scroll both directions

### UI Positioning
- **context-menu-arrow-position**: Context menu arrow position
- **context-menu-body-position**: Context menu body position
- **context-menu-position**: Overall context menu position
- **tooltip-arrow-position**: Tooltip arrow position
- **tooltip-body-position**: Tooltip body position
- **tooltip-position**: Overall tooltip position

### Audio
- **sound**: UI sound effect on interaction
- **sound-out**: UI sound on mouse out
- **sound-trans**: UI sound on transition

### Rendering
- **texture-sampling**: Texture sampling mode
- **text-shadow-fast**: Optimized text shadow

### Source 2 Specific
- **-s2-mix-blend-mode**: `normal` | `multiply` | `screen` | `additive` | `SRGBadditive` | `opaque` - Blending mode

### Position Helpers
- **x**: X coordinate (absolute positioning)
- **y**: Y coordinate (absolute positioning)
- **z**: Z coordinate (depth)

## Modified Standard Properties

Some standard CSS properties work differently in Panorama:

- **animation**: Panorama subset of CSS animations
- **transform**: Panorama-specific transform functions
- **position**: Enhanced with x, y, z properties
- **overflow**: Panorama-specific behavior

## Example Usage

```css
.panel {
    /* Panorama-specific layout */
    align: center center;
    flow-children: down;
    
    /* Visual effects */
    wash-color: #ff0000;
    blur: gaussian(2);
    brightness: 1.2;
    
    /* UI scaling */
    ui-scale: 1.5;
    
    /* Background with separate opacity */
    background-image: url("file://{images}/bg.png");
    background-img-opacity: 0.5;
    
    /* Sounds */
    sound: "ui_button_click";
}

.tooltip {
    /* Tooltip positioning */
    tooltip-position: 0px 10px 0px;
    tooltip-arrow-position: 50% 0%;
}

.menu {
    /* Context menu */
    context-menu-position: 100% 0%;
}

.animated-panel {
    /* Pre-transforms applied before regular transforms */
    pre-transform-scale2d: 0.5;
    pre-transform-rotate2d: 45deg;
    transform: translateX(100px);
}
```

## Property Value Examples

### align
```css
align: left top;
align: center middle;
align: right bottom;
align: center_nopixelsnap middle; /* No pixel snapping */
```

### flow-children
```css
flow-children: down;    /* Vertical flow */
flow-children: right;   /* Horizontal flow */
flow-children: none;    /* No automatic flow */
```

### blur
```css
blur: gaussian(2);      /* Standard gaussian blur */
blur: fastgaussian(1);  /* Optimized blur */
```

### -s2-mix-blend-mode (Source 2)
```css
-s2-mix-blend-mode: normal;      /* With alpha blending */
-s2-mix-blend-mode: multiply;
-s2-mix-blend-mode: screen;
-s2-mix-blend-mode: additive;
-s2-mix-blend-mode: SRGBadditive; /* sRGB color space */
-s2-mix-blend-mode: opaque;      /* No alpha blending */
```

## Resources

- **CS:GO Panorama Properties**: https://developer.valvesoftware.com/wiki/CSGO_Panorama_CSS_Properties
- **Valve Developer Community**: https://developer.valvesoftware.com/wiki/Panorama

## Notes

1. Not all standard CSS properties are supported in Panorama
2. Some properties may behave differently than in web browsers
3. Property support varies between Source 1 and Source 2 engines
4. Always test in the target game engine for compatibility
