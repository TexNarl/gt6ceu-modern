/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/worldgen climate helpers
 * Purpose: Provide climate-based filters for worldgen passes.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.worldgen;

import net.minecraft.world.level.biome.Biome;

public final class GtWorldgenClimate {
    private GtWorldgenClimate() {
    }

    public static boolean isCold(Biome biome) {
        return biome.getBaseTemperature() < 0.3f;
    }

    public static boolean isHot(Biome biome) {
        return biome.getBaseTemperature() > 1.1f;
    }

    public static boolean isTemperate(Biome biome) {
        float temp = biome.getBaseTemperature();
        return temp >= 0.3f && temp <= 1.1f;
    }

    public static boolean isHumid(Biome biome) {
        return biome.hasPrecipitation() && biome.getBaseTemperature() > 0.3f;
    }

    public static boolean isArid(Biome biome) {
        return !biome.hasPrecipitation() && biome.getBaseTemperature() > 0.4f;
    }

    public static boolean isSwampy(Biome biome) {
        float temp = biome.getBaseTemperature();
        return biome.hasPrecipitation() && temp >= 0.6f && temp <= 1.2f;
    }
}
