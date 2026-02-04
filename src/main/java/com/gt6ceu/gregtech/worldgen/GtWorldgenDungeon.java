/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/worldgen/dungeon/WorldgenDungeonGT.java
 * Purpose: Place a simple underground dungeon room.
 * Status: PORTED
 * Notes: Simplified room placement without loot integration.
 */
package com.gt6ceu.gregtech.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;

public class GtWorldgenDungeon implements GtChunkWorldgen {
    private final String id;
    private final int probability;

    public GtWorldgenDungeon(String id, int probability) {
        this.id = id;
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
        if (random.nextInt(probability) != 0) {
            return;
        }
        int minX = chunk.getPos().getMinBlockX();
        int minZ = chunk.getPos().getMinBlockZ();
        int centerX = minX + 8;
        int centerZ = minZ + 8;
        int baseY = Math.max(level.getMinBuildHeight() + 16, level.getSeaLevel() - 40);
        int roomY = baseY + random.nextInt(12);
        BlockPos center = new BlockPos(centerX, roomY, centerZ);
        carveRoom(level, center, random);
    }

    private void carveRoom(ServerLevel level, BlockPos center, RandomSource random) {
        int radius = 3;
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -2; dy <= 2; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    BlockPos pos = center.offset(dx, dy, dz);
                    boolean wall = Math.abs(dx) == radius || Math.abs(dy) == 2 || Math.abs(dz) == radius;
                    if (wall) {
                        level.setBlock(pos, random.nextInt(4) == 0 ? Blocks.MOSSY_COBBLESTONE.defaultBlockState()
                                : Blocks.COBBLESTONE.defaultBlockState(), 2);
                    } else {
                        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    }
                }
            }
        }
        level.setBlock(center.above(), Blocks.TORCH.defaultBlockState(), 2);
    }
}
