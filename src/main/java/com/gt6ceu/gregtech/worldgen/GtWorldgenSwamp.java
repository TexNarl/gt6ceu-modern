/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenSwamp.java
 * Purpose: Replace swamp water blocks with GT swamp fluid blocks.
 * Status: PORTED
 * Notes: Applies only in swamp biomes and uses sea level as upper bound.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.registry.GTBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;

public class GtWorldgenSwamp implements GtChunkWorldgen {
    private final String id;

    public GtWorldgenSwamp(String id) {
        this.id = id;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public boolean supports(ServerLevel level) {
        return level.dimension() == ServerLevel.OVERWORLD;
    }

    @Override
    public void generate(ServerLevel level, ChunkAccess chunk, RandomSource random) {
        int minX = chunk.getPos().getMinBlockX();
        int minZ = chunk.getPos().getMinBlockZ();
        int seaLevel = level.getSeaLevel();
        for (int dx = 0; dx < 16; dx++) {
            for (int dz = 0; dz < 16; dz++) {
                BlockPos pos = new BlockPos(minX + dx, seaLevel, minZ + dz);
                if (!level.getBiome(pos).is(BiomeTags.IS_SWAMP)) {
                    continue;
                }
                Biome biome = level.getBiome(pos).value();
                if (!GtWorldgenClimate.isSwampy(biome)) {
                    continue;
                }
                for (int y = seaLevel; y >= level.getMinBuildHeight(); y--) {
                    BlockPos scan = new BlockPos(pos.getX(), y, pos.getZ());
                    if (level.getBlockState(scan).is(Blocks.WATER)) {
                        level.setBlock(scan, GTBlocks.SWAMP_WATER.get().defaultBlockState(), 2);
                    } else if (!level.getBlockState(scan).isAir()) {
                        break;
                    }
                }
            }
        }
    }
}
