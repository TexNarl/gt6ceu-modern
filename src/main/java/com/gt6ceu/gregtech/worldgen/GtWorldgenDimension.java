/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/worldgen (dimension lists)
 * Purpose: Map GT6 worldgen dimension labels to modern dimension keys.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.worldgen;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;

public enum GtWorldgenDimension {
    OVERWORLD(Level.OVERWORLD),
    NETHER(Level.NETHER),
    END(Level.END),
    AETHER("aether"),
    ALFHEIM("alfheim"),
    ATUM("atum"),
    ASTEROIDS("asteroids"),
    BETWEENLANDS("betweenlands"),
    EREBUS("erebus"),
    MARS("mars"),
    MOON("moon"),
    PLANETS("planets");

    private final ResourceKey<Level> key;
    private final String path;

    GtWorldgenDimension(ResourceKey<Level> key) {
        this.key = key;
        this.path = key.location().getPath();
    }

    GtWorldgenDimension(String path) {
        this.key = null;
        this.path = path;
    }

    public boolean matches(ServerLevel level) {
        if (key != null) {
            return level.dimension() == key;
        }
        return level.dimension().location().getPath().equals(path);
    }

    public static GtWorldgenDimension fromLevel(ServerLevel level) {
        for (GtWorldgenDimension dimension : values()) {
            if (dimension.matches(level)) {
                return dimension;
            }
        }
        return null;
    }
}
