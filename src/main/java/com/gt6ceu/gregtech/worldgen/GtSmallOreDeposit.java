/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/worldgen/WorldgenOresSmall.java
 * Purpose: Data model for GT6 small ore deposit definitions.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.worldgen;

import java.util.Set;

public record GtSmallOreDeposit(
        String id,
        boolean enabled,
        int minY,
        int maxY,
        int amount,
        GtOreMaterial material,
        Set<GtWorldgenDimension> dimensions
) {
    public boolean supportsDimension(GtWorldgenDimension dimension) {
        return dimensions.contains(dimension);
    }
}
