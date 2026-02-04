/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: dimension rock generators (Aether/Erebus/Alfheim/Planets)
 * Purpose: Place surface rock indicators in non-overworld dimensions.
 * Status: PORTED
 * Notes: Uses dimension path matching to avoid compat-only hooks.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.registry.GTBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;

public class GtWorldgenDimensionRocks implements GtChunkWorldgen {
    private final String id;
    private final String dimensionPath;
    private final int amount;
    private final int probability;

    public GtWorldgenDimensionRocks(String id, String dimensionPath, int amount, int probability) {
        this.id = id;
        this.dimensionPath = dimensionPath;
        this.amount = amount;
        this.probability = probability;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public boolean supports(ServerLevel level) {
        return level.dimension().location().getPath().contains(dimensionPath);
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
            if (level.getBlockState(pos).isAir()) {
                level.setBlock(pos, GTBlocks.SURFACE_ROCK.get().defaultBlockState(), 2);
            }
        }
    }
}
