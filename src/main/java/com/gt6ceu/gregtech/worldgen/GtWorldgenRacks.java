/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/nether/WorldgenRacks.java
 * Purpose: Place nether rack deposits.
 * Status: PORTED
 * Notes: Simplified replacement of netherrack with GT racks.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtMetaBlock;
import com.gt6ceu.gregtech.registry.GTBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;

public class GtWorldgenRacks implements GtChunkWorldgen {
    private final String id;
    private final int attempts;
    private final int size;

    public GtWorldgenRacks(String id, int attempts, int size) {
        this.id = id;
        this.attempts = attempts;
        this.size = size;
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
        int minY = level.getMinBuildHeight() + 8;
        int maxY = Math.min(level.getMaxBuildHeight() - 8, minY + 96);
        if (minY >= maxY) {
            return;
        }
        for (int i = 0; i < attempts; i++) {
            int x = minX + random.nextInt(16);
            int y = minY + random.nextInt(maxY - minY);
            int z = minZ + random.nextInt(16);
            placeCluster(level, new BlockPos(x, y, z), random);
        }
    }

    private void placeCluster(ServerLevel level, BlockPos start, RandomSource random) {
        for (int i = 0; i < size; i++) {
            BlockPos pos = start.offset(random.nextInt(5) - 2, random.nextInt(5) - 2, random.nextInt(5) - 2);
            if (level.getBlockState(pos).is(Blocks.NETHERRACK)) {
                level.setBlock(pos, GTBlocks.RACKS.get().defaultBlockState().setValue(GtMetaBlock.META, 0), 2);
            }
        }
    }
}
