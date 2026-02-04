/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/worldgen/WorldgenOresLarge.java
 * Purpose: Data model for GT6 large ore vein definitions.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.worldgen;

import java.util.Set;

public record GtLargeOreVein(
        String id,
        boolean enabled,
        boolean indicatorRocks,
        int minY,
        int maxY,
        int weight,
        int density,
        int size,
        GtOreMaterial top,
        GtOreMaterial bottom,
        GtOreMaterial between,
        GtOreMaterial spread,
        Set<GtWorldgenDimension> dimensions
) {
    public boolean supportsDimension(GtWorldgenDimension dimension) {
        return dimensions.contains(dimension);
    }
}
