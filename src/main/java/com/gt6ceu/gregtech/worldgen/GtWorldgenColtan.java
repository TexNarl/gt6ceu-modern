/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/overworld/WorldgenColtan.java
 * Purpose: Place coltan deposits in overworld stone.
 * Status: PORTED
 * Notes: Simplified cluster placement.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtMetaBlock;
import com.gt6ceu.gregtech.registry.GTBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;

public class GtWorldgenColtan implements GtChunkWorldgen {
    private final String id;
    private final int attempts;
    private final int size;

    public GtWorldgenColtan(String id, int attempts, int size) {
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
        return level.dimension() == ServerLevel.OVERWORLD;
    }

    @Override
    public void generate(ServerLevel level, ChunkAccess chunk, RandomSource random) {
        int minX = chunk.getPos().getMinBlockX();
        int minZ = chunk.getPos().getMinBlockZ();
        int minY = level.getMinBuildHeight() + 12;
        int maxY = Math.min(level.getSeaLevel() + 16, level.getMaxBuildHeight() - 8);
        for (int i = 0; i < attempts; i++) {
            int x = minX + random.nextInt(16);
            int y = minY + random.nextInt(Math.max(1, maxY - minY));
            int z = minZ + random.nextInt(16);
            placeCluster(level, new BlockPos(x, y, z), random);
        }
    }

    private void placeCluster(ServerLevel level, BlockPos start, RandomSource random) {
        for (int i = 0; i < size; i++) {
            BlockPos pos = start.offset(random.nextInt(6) - 3, random.nextInt(4) - 2, random.nextInt(6) - 3);
            if (level.getBlockState(pos).is(Blocks.STONE) || level.getBlockState(pos).is(Blocks.DEEPSLATE)) {
                level.setBlock(pos, GTBlocks.COLTAN.get().defaultBlockState().setValue(GtMetaBlock.META, 0), 2);
            }
        }
    }
}
