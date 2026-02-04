/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenLog*.java
 * Purpose: Place surface log variants in eligible biomes.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.worldgen;

import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class GtWorldgenLogs implements GtChunkWorldgen {
    private final String id;
    private final Block logBlock;
    private final int amount;
    private final int probability;
    private final ResourceKey<Level> dimension;
    private final Predicate<Biome> biomePredicate;

    public GtWorldgenLogs(String id, Block logBlock, int amount, int probability, ResourceKey<Level> dimension,
                          Predicate<Biome> biomePredicate) {
        this.id = id;
        this.logBlock = logBlock;
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
            if (!level.getBlockState(ground).isSolidRender(level, ground)) {
                continue;
            }
            if (level.getBlockState(ground).is(Blocks.WATER)) {
                continue;
            }
            if (level.getBlockState(pos).isAir()) {
                level.setBlock(pos, orientedLogState(), 2);
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
                || biome.is(BiomeTags.IS_SWAMP);
    }
}
