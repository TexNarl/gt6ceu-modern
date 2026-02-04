/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/worldgen/StoneLayerOres.java
 * Purpose: Encapsulate GT6 ore chance rules for stone layers.
 * Status: PORTED
 * Notes: Simplified biome handling for initial port; blockstate placement preserved.
 */
package com.gt6ceu.gregtech.worldgen;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class GtStoneLayerOre {
    private static final long U = 648_648_000L;

    private final GtOreMaterial material;
    private final boolean generateIndicators;
    private final long chance;
    private final int minY;
    private final int maxY;
    private final BlockState forcedState;

    public GtStoneLayerOre(GtOreMaterial material, long chance, int minY, int maxY) {
        this(material, true, chance, minY, maxY, null);
    }

    public GtStoneLayerOre(GtOreMaterial material, boolean generateIndicators, long chance, int minY, int maxY) {
        this(material, generateIndicators, chance, minY, maxY, null);
    }

    public GtStoneLayerOre(GtOreMaterial material, boolean generateIndicators, long chance, int minY, int maxY, BlockState forcedState) {
        this.material = material == null ? GtOreMaterial.EMPTY : material;
        this.generateIndicators = generateIndicators;
        this.chance = Math.max(1, Math.min(U, chance));
        this.minY = Math.min(minY, maxY);
        this.maxY = Math.max(minY, maxY);
        this.forcedState = forcedState;
    }

    public boolean generatesIndicators() {
        return generateIndicators;
    }

    public GtOreMaterial getMaterial() {
        return material;
    }

    public boolean check(int y, RandomSource random) {
        return y >= minY && y <= maxY && random.nextInt((int) U) < chance;
    }

    public boolean check(LevelAccessor level, int y, RandomSource random) {
        int min = getScaledMinY(level);
        int max = getScaledMaxY(level);
        return y >= min && y <= max && random.nextInt((int) U) < chance;
    }

    public boolean place(GtStoneLayer layer, LevelAccessor level, int x, int y, int z, RandomSource random) {
        if (forcedState != null) {
            return level.setBlock(new net.minecraft.core.BlockPos(x, y, z), forcedState, 2);
        }
        int min = getScaledMinY(level);
        int max = getScaledMaxY(level);
        if (y == min || y == max || random.nextBoolean()) {
            return placeSmall(layer, level, x, y, z);
        }
        return placeNormal(layer, level, x, y, z);
    }

    public boolean placeNormal(GtStoneLayer layer, LevelAccessor level, int x, int y, int z) {
        BlockState state = layer.getNormalOreState(material);
        return state != null && level.setBlock(new net.minecraft.core.BlockPos(x, y, z), state, 2);
    }

    public boolean placeSmall(GtStoneLayer layer, LevelAccessor level, int x, int y, int z) {
        BlockState state = layer.getSmallOreState(material);
        return state != null && level.setBlock(new net.minecraft.core.BlockPos(x, y, z), state, 2);
    }

    public boolean placeBroken(GtStoneLayer layer, LevelAccessor level, int x, int y, int z) {
        BlockState state = layer.getBrokenOreState(material);
        return state != null && level.setBlock(new net.minecraft.core.BlockPos(x, y, z), state, 2);
    }

    private int getScaledMinY(LevelAccessor level) {
        return scaleHeight(level, minY);
    }

    private int getScaledMaxY(LevelAccessor level) {
        return scaleHeight(level, maxY);
    }

    private int scaleHeight(LevelAccessor level, int legacyY) {
        int legacyMin = 0;
        int legacyMax = 64;
        int clampedLegacy = Math.max(legacyMin, Math.min(legacyMax, legacyY));
        int targetMin = level.getMinBuildHeight();
        int targetMax = level.getSeaLevel();
        if (targetMax <= targetMin) {
            return legacyY;
        }
        double normalized = (clampedLegacy - legacyMin) / (double) (legacyMax - legacyMin);
        return targetMin + (int) Math.round(normalized * (targetMax - targetMin));
    }
}
