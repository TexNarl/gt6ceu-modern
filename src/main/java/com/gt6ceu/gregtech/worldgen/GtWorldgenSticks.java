/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenSticks.java
 * Purpose: Place surface sticks in common overworld biomes.
 * Status: PORTED
 * Notes: Uses simple surface checks and GT blocks for placement.
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
import net.minecraft.world.level.levelgen.Heightmap;

public class GtWorldgenSticks implements GtChunkWorldgen {
    private final String id;
    private final int amount;
    private final int probability;

    public GtWorldgenSticks(String id, int amount, int probability) {
        this.id = id;
        this.amount = amount;
        this.probability = probability;
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
        for (int i = 0; i < amount; i++) {
            if (random.nextInt(probability) != 0) {
                continue;
            }
            int x = minX + random.nextInt(16);
            int z = minZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, x, z), z);
            Biome biome = level.getBiome(pos).value();
            if (!isAllowedBiome(biome)) {
                continue;
            }
            BlockPos ground = pos.below();
            if (!level.getBlockState(ground).isSolidRender(level, ground)) {
                continue;
            }
            if (!level.getBlockState(ground).is(Blocks.GRASS_BLOCK)
                    && !level.getBlockState(ground).is(Blocks.DIRT)
                    && !level.getBlockState(ground).is(Blocks.SAND)) {
                continue;
            }
            if (level.getBlockState(pos).isAir()) {
                level.setBlock(pos, GTBlocks.SURFACE_STICK.get().defaultBlockState(), 2);
            }
        }
    }

    private boolean isAllowedBiome(Biome biome) {
        return biome.is(BiomeTags.IS_FOREST)
                || biome.is(BiomeTags.IS_SWAMP)
                || biome.is(BiomeTags.IS_RIVER)
                || biome.is(BiomeTags.IS_PLAINS)
                || biome.is(BiomeTags.IS_SAVANNA)
                || biome.is(BiomeTags.IS_TAIGA)
                || biome.is(BiomeTags.IS_BADLANDS);
    }
}
