/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/nether/WorldgenNetherQuartz.java
 * Purpose: Place GT rock ores in the Nether using GT6 noise rules.
 * Status: PORTED
 * Notes: Uses meta 8 to match GT6 quartz entry.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtMetaBlock;
import com.gt6ceu.gregtech.registry.GTBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;

public class GtWorldgenNetherQuartz implements GtChunkWorldgen {
    private final String id;

    public GtWorldgenNetherQuartz(String id) {
        this.id = id;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public boolean supports(ServerLevel level) {
        return level.dimension() == ServerLevel.NETHER;
    }

    @Override
    public void generate(ServerLevel level, ChunkAccess chunk, RandomSource random) {
        int minX = chunk.getPos().getMinBlockX();
        int minZ = chunk.getPos().getMinBlockZ();
        GtNoiseGenerator noise = new GtNoiseGenerator(level);
        for (int dx = 0; dx < 16; dx++) {
            for (int dz = 0; dz < 16; dz++) {
                int y = 40 + noise.get(minX + dx, 0, minZ + dz, 200);
                placeIfNetherrack(level, minX + dx, y, minZ + dz);
                y = 40 + noise.get(minX + dx, 64, minZ + dz, 200);
                placeIfNetherrack(level, minX + dx, y, minZ + dz);
            }
        }
    }

    private void placeIfNetherrack(ServerLevel level, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        if (level.getBlockState(pos).is(Blocks.NETHERRACK)) {
            level.setBlock(pos, GTBlocks.ROCK_ORES.get().defaultBlockState().setValue(GtMetaBlock.META, 8), 2);
        }
    }
}
