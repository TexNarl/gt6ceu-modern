/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenOresVanilla.java
 * Purpose: Place single-material ore deposits in specific biomes/dimensions.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtOreBlock;
import com.gt6ceu.gregtech.registry.GTBlocks;
import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;

public class GtWorldgenOresVanilla implements GtChunkWorldgen {
    private final String id;
    private final Block targetBlock;
    private final int minY;
    private final int maxY;
    private final int amount;
    private final GtOreMaterial material;
    private final ResourceKey<Level> dimension;
    private final Predicate<Biome> biomePredicate;

    public GtWorldgenOresVanilla(String id, Block targetBlock, int minY, int maxY, int amount,
                                 GtOreMaterial material, ResourceKey<Level> dimension, Predicate<Biome> biomePredicate) {
        this.id = id;
        this.targetBlock = targetBlock;
        this.minY = minY;
        this.maxY = maxY;
        this.amount = amount;
        this.material = material;
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
        int minBuild = Math.max(level.getMinBuildHeight() + 1, minY);
        int maxBuild = Math.min(level.getMaxBuildHeight() - 1, maxY);
        if (minBuild >= maxBuild) {
            return;
        }
        for (int i = 0; i < amount; i++) {
            int x = minX + random.nextInt(16);
            int y = minBuild + random.nextInt(Math.max(1, maxBuild - minBuild));
            int z = minZ + random.nextInt(16);
            BlockPos pos = new BlockPos(x, y, z);
            Biome biome = level.getBiome(pos).value();
            if (!biomePredicate.test(biome)) {
                continue;
            }
            if (!level.getBlockState(pos).is(targetBlock)) {
                continue;
            }
            level.setBlock(pos, oreStateFor(level, pos, material), 2);
        }
    }

    private BlockState oreStateFor(ServerLevel level, BlockPos pos, GtOreMaterial material) {
        boolean deepslate = level.getBlockState(pos).is(Blocks.DEEPSLATE);
        return GTBlocks.ORE_NORMAL.get().defaultBlockState()
                .setValue(GtOreBlock.MATERIAL, material.getId())
                .setValue(GtOreBlock.STONE_TYPE, deepslate ? GtStoneType.DEEPSLATE.getId() : GtStoneType.GRANITE.getId());
    }
}
