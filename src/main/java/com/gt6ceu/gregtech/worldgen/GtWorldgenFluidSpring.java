/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenFluidSpring.java
 * Purpose: Place a simple underground fluid spring marker.
 * Status: PORTED
 * Notes: Simplified placeholder without fluid tile entity handling.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtFluidSpringBlock;
import com.gt6ceu.gregtech.blockentity.GtFluidSpringBlockEntity;
import com.gt6ceu.gregtech.block.GtMetaBlock;
import com.gt6ceu.gregtech.registry.GTBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;

public class GtWorldgenFluidSpring implements GtChunkWorldgen {
    private final String id;
    private final int probability;
    private final Block fluidBlock;
    private final String fluidId;
    private final int indicatorType;
    private final int surfaceIndicatorMeta;

    public GtWorldgenFluidSpring(String id, int probability) {
        this(id, probability, Blocks.WATER, "minecraft:water", 0);
    }

    public GtWorldgenFluidSpring(String id, int probability, Block fluidBlock, String fluidId, int indicatorType) {
        this.id = id;
        this.probability = probability;
        this.fluidBlock = fluidBlock;
        this.fluidId = fluidId;
        this.indicatorType = indicatorType;
        this.surfaceIndicatorMeta = indicatorType == 2 ? 3 : 2;
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
        if (fluidId.contains("oil") && !GtWorldgenConfig.generateInfiniteOilSources()) {
            return;
        }
        if (fluidId.contains("gas") && !GtWorldgenConfig.generateInfiniteGasSources()) {
            return;
        }
        if (random.nextInt(probability) != 0) {
            return;
        }
        int minX = chunk.getPos().getMinBlockX();
        int minZ = chunk.getPos().getMinBlockZ();
        int maxX = minX + 15;
        int maxZ = minZ + 15;
        int baseY = level.getMinBuildHeight();
        Block hostBlock = level.dimension() == ServerLevel.NETHER ? Blocks.NETHERRACK : Blocks.STONE;

        for (int i = 0; i <= 6; i++) {
            for (int x = minX + i; x <= maxX - i; x++) {
                for (int z = minZ + i; z <= maxZ - i; z++) {
                    BlockPos shellPos = new BlockPos(x, baseY + i + 1, z);
                    if (!level.getBlockState(shellPos).isSolidRender(level, shellPos)) {
                        level.setBlock(shellPos, hostBlock.defaultBlockState(), 2);
                    }
                    if (i > 0) {
                        BlockPos fluidPos = new BlockPos(x, baseY + i, z);
                        level.setBlock(fluidPos, fluidBlock.defaultBlockState(), 2);
                    }
                    if (i == 0 && random.nextInt(16) == 0) {
                        BlockPos springPos = new BlockPos(x, baseY, z);
                        placeSpringIndicator(level, springPos);
                    }
                }
            }
        }
        placeSurfaceIndicator(level, random, minX, minZ);
    }

    private void placeSpringIndicator(ServerLevel level, BlockPos pos) {
        level.setBlock(pos, GTBlocks.FLUID_SPRING.get().defaultBlockState().setValue(GtFluidSpringBlock.INDICATOR, indicatorType), 2);
        if (level.getBlockEntity(pos) instanceof GtFluidSpringBlockEntity springEntity) {
            springEntity.setSpringData(fluidId, indicatorType);
        }
    }

    private void placeSurfaceIndicator(ServerLevel level, RandomSource random, int minX, int minZ) {
        int x = minX + 4 + random.nextInt(8);
        int z = minZ + 4 + random.nextInt(8);
        int y = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, x, z);
        BlockPos pos = new BlockPos(x, y, z);
        BlockPos ground = pos.below();
        if (level.getBlockState(ground).is(Blocks.GRASS_BLOCK) || level.getBlockState(ground).is(Blocks.DIRT)) {
            level.setBlock(ground, GTBlocks.DIGGABLES.get().defaultBlockState().setValue(GtMetaBlock.META, surfaceIndicatorMeta), 2);
        }
    }
}
