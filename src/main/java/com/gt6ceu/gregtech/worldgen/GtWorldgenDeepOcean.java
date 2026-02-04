/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenDeepOcean.java
 * Purpose: Place deep-ocean prismarine structures.
 * Status: PORTED
 * Notes: Uses GT noise to gate prismarine pylons.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.registry.GTBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;

public class GtWorldgenDeepOcean implements GtChunkWorldgen {
    private final String id;

    public GtWorldgenDeepOcean(String id) {
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
        BlockPos center = new BlockPos(minX + 8, level.getSeaLevel(), minZ + 8);
        if (!level.getBiome(center).is(BiomeTags.IS_DEEP_OCEAN)) {
            return;
        }
        int selector = new GtNoiseGenerator(level).get(minX + 8, 32, minZ + 8, 16);
        if (selector < 12 || selector > 13) {
            return;
        }
        int baseY = level.getSeaLevel() - 4;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                for (int dy = 0; dy < 3; dy++) {
                    BlockPos pos = new BlockPos(center.getX() + dx, baseY + dy, center.getZ() + dz);
                    if (level.getBlockState(pos).is(Blocks.WATER)) {
                        level.setBlock(pos, GTBlocks.PRISMARINE_DARK.get().defaultBlockState(), 2);
                    }
                }
            }
        }
    }
}
