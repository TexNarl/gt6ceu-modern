/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenTurf.java
 * Purpose: Replace swamp surface blocks with turf variants.
 * Status: PORTED
 * Notes: Uses pit mask and swamp-only biome checks.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtMetaBlock;
import com.gt6ceu.gregtech.registry.GTBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;

public class GtWorldgenTurf implements GtChunkWorldgen {
    private final String id;

    public GtWorldgenTurf(String id) {
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
        if (random.nextInt(32) != 0) {
            return;
        }
        BlockPos center = chunk.getPos().getMiddleBlockPosition(level.getSeaLevel());
        Biome biome = level.getBiome(center).value();
        if (!level.getBiome(center).is(BiomeTags.IS_SWAMP)) {
            return;
        }
        if (!GtWorldgenClimate.isSwampy(biome)) {
            return;
        }

        int minX = chunk.getPos().getMinBlockX();
        int minZ = chunk.getPos().getMinBlockZ();
        int baseX = minX - 16;
        int baseZ = minZ - 16;
        int seaLevel = level.getSeaLevel();
        int upperBound = seaLevel + 1;
        int lowerBound = seaLevel - 12;

        for (int i = 0; i < 48; i++) {
            for (int j = 0; j < 48; j++) {
                if (!GtWorldgenPit.SHAPE[i][j]) {
                    continue;
                }
                BlockPos lastPos = new BlockPos(baseX + i, upperBound + 1, baseZ + j);
                BlockState lastState = level.getBlockState(lastPos);
                int generated = 0;
                for (int y = upperBound; y > lowerBound && generated < 2; y--) {
                    BlockPos pos = new BlockPos(baseX + i, y, baseZ + j);
                    BlockState state = level.getBlockState(pos);
                    if (state.is(GTBlocks.DIGGABLES.get()) && state.getValue(GtMetaBlock.META) == 2) {
                        generated++;
                        lastState = state;
                        continue;
                    }
                    if (!state.isSolidRender(level, pos)) {
                        if (generated > 0) {
                            break;
                        }
                        lastState = state;
                        continue;
                    }
                    if (state.is(Blocks.DIRT) || state.is(Blocks.GRASS_BLOCK)) {
                        if (generated <= 0 && isTreeCover(lastState)) {
                            lastState = state;
                            continue;
                        }
                    } else if (generated > 0 && !state.is(BlockTags.BASE_STONE_OVERWORLD)) {
                        break;
                    } else if (generated <= 0) {
                        lastState = state;
                        continue;
                    }
                    level.setBlock(pos, GTBlocks.DIGGABLES.get().defaultBlockState().setValue(GtMetaBlock.META, 2), 2);
                    generated++;
                    lastState = state;
                }
            }
        }
    }

    private boolean isTreeCover(BlockState state) {
        return state.is(BlockTags.LOGS) || state.is(BlockTags.LEAVES) || state.is(BlockTags.SAPLINGS);
    }
}
