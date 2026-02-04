/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenTree*.java
 * Purpose: Place simple tree variants in eligible biomes.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.worldgen;

import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;

public class GtWorldgenTrees implements GtChunkWorldgen {
    private final String id;
    private final Block logBlock;
    private final Block leafBlock;
    private final int amount;
    private final int probability;
    private final ResourceKey<Level> dimension;
    private final Predicate<Biome> biomePredicate;

    public GtWorldgenTrees(String id, Block logBlock, Block leafBlock, int amount, int probability,
                           ResourceKey<Level> dimension, Predicate<Biome> biomePredicate) {
        this.id = id;
        this.logBlock = logBlock;
        this.leafBlock = leafBlock;
        this.amount = amount;
        this.probability = probability;
        this.dimension = dimension;
        this.biomePredicate = biomePredicate;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public boolean supports(ServerLevel level) {
        return level.dimension() == dimension;
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
            if (!biomePredicate.test(biome)) {
                continue;
            }
            BlockPos ground = pos.below();
            if (!level.getBlockState(ground).is(Blocks.GRASS_BLOCK)
                    && !level.getBlockState(ground).is(Blocks.DIRT)) {
                continue;
            }
            if (!level.getBlockState(pos).isAir()) {
                continue;
            }
            placeTree(level, pos, random);
        }
    }

    private void placeTree(ServerLevel level, BlockPos pos, RandomSource random) {
        int height = 3 + random.nextInt(3);
        BlockState logState = orientedLogState();
        for (int y = 0; y < height; y++) {
            BlockPos trunk = pos.above(y);
            if (!level.getBlockState(trunk).isAir()) {
                return;
            }
            level.setBlock(trunk, logState, 2);
        }
        BlockPos top = pos.above(height);
        for (int dx = -2; dx <= 2; dx++) {
            for (int dz = -2; dz <= 2; dz++) {
                for (int dy = -1; dy <= 1; dy++) {
                    BlockPos leafPos = top.offset(dx, dy, dz);
                    if (level.getBlockState(leafPos).isAir()) {
                        level.setBlock(leafPos, leafBlock.defaultBlockState(), 2);
                    }
                }
            }
        }
    }

    private BlockState orientedLogState() {
        BlockState state = logBlock.defaultBlockState();
        if (state.hasProperty(RotatedPillarBlock.AXIS)) {
            return state.setValue(RotatedPillarBlock.AXIS, net.minecraft.core.Direction.Axis.Y);
        }
        return state;
    }

    public static Predicate<Biome> defaultOverworldBiomes() {
        return biome -> biome.is(BiomeTags.IS_FOREST)
                || biome.is(BiomeTags.IS_PLAINS)
                || biome.is(BiomeTags.IS_TAIGA)
                || biome.is(BiomeTags.IS_SWAMP)
                || biome.is(BiomeTags.IS_JUNGLE);
    }
}
