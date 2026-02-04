/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/nether/WorldgenNetherClay.java
 * Purpose: Place GT diggables in the Nether using GT6 noise rules.
 * Status: PORTED
 * Notes: Uses meta 3 to match GT6 red clay entry.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtMetaBlock;
import com.gt6ceu.gregtech.registry.GTBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;

public class GtWorldgenNetherClay implements GtChunkWorldgen {
    private final String id;

    public GtWorldgenNetherClay(String id) {
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
        int upper = level.getSeaLevel() + 3;
        int lower = level.getSeaLevel() + 2;
        GtNoiseGenerator noise = new GtNoiseGenerator(level);
        for (int dx = 0; dx < 16; dx++) {
            for (int dz = 0; dz < 16; dz++) {
                if (noise.get(minX + dx, 42, minZ + dz, 8) == 0) {
                    for (int y = upper; y >= lower; y--) {
                        BlockPos pos = new BlockPos(minX + dx, y, minZ + dz);
                        if (level.getBlockState(pos).is(Blocks.NETHERRACK)) {
                            level.setBlock(pos, GTBlocks.DIGGABLES.get().defaultBlockState().setValue(GtMetaBlock.META, 3), 2);
                        }
                    }
                }
            }
        }
    }
}
