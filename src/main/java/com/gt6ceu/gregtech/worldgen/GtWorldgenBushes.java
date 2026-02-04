/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenBushes.java
 * Purpose: Place simple bush blocks on the surface in temperate biomes.
 * Status: PORTED
 * Notes: Uses simplified placement rules and GT placeholder block.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtVariantBlock;
import com.gt6ceu.gregtech.blockentity.GtBushBlockEntity;
import com.gt6ceu.gregtech.registry.GTBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;

public class GtWorldgenBushes implements GtChunkWorldgen {
    private final String id;
    private final int amount;
    private final int probability;

    public GtWorldgenBushes(String id, int amount, int probability) {
        this.id = id;
        this.amount = amount;
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
            if (!level.getBiome(pos).is(BiomeTags.IS_PLAINS) && !level.getBiome(pos).is(BiomeTags.IS_FOREST)) {
                continue;
            }
            if (level.getBiome(pos).is(BiomeTags.IS_SNOWY) || GtWorldgenClimate.isCold(biome)) {
                continue;
            }
            if (!GtWorldgenClimate.isTemperate(biome) || GtWorldgenClimate.isArid(biome)) {
                continue;
            }
            BlockPos ground = pos.below();
            if (!level.getBlockState(ground).is(Blocks.GRASS_BLOCK) && !level.getBlockState(ground).is(Blocks.DIRT)) {
                continue;
            }
            if (level.getBlockState(pos).isAir()) {
                int berryType = selectBerryType(biome, level, x, z);
                int clusterSize = 1 + random.nextInt(4);
                placeBushCluster(level, pos, random, berryType, clusterSize);
            }
        }
    }

    private int selectBerryType(Biome biome, ServerLevel level, int x, int z) {
        int base = new GtNoiseGenerator(level).get(x / 2.0f, 300, z / 2.0f, 8);
        if (GtWorldgenClimate.isHumid(biome)) {
            return (base + 2) % 8;
        }
        if (GtWorldgenClimate.isCold(biome)) {
            return base % 4;
        }
        return base;
    }

    private void placeBushCluster(ServerLevel level, BlockPos pos, RandomSource random, int berryType, int clusterSize) {
        placeBush(level, pos, berryType, random.nextInt(4), clusterSize, random.nextBoolean());
        if (random.nextBoolean()) {
            placeBush(level, pos.north(), berryType, random.nextInt(4), clusterSize, random.nextBoolean());
        }
        if (random.nextBoolean()) {
            placeBush(level, pos.south(), berryType, random.nextInt(4), clusterSize, random.nextBoolean());
        }
        if (random.nextBoolean()) {
            placeBush(level, pos.east(), berryType, random.nextInt(4), clusterSize, random.nextBoolean());
        }
        if (random.nextBoolean()) {
            placeBush(level, pos.west(), berryType, random.nextInt(4), clusterSize, random.nextBoolean());
        }
        if (random.nextInt(3) == 0) {
            placeBush(level, pos.above(), berryType, random.nextInt(4), clusterSize, random.nextBoolean());
        }
    }

    private void placeBush(ServerLevel level, BlockPos pos, int berryType, int growthStage, int clusterSize, boolean hasFruit) {
        if (!level.getBlockState(pos).isAir()) {
            return;
        }
        level.setBlock(pos, GTBlocks.SURFACE_BUSH.get().defaultBlockState().setValue(GtVariantBlock.VARIANT, berryType), 2);
        if (level.getBlockEntity(pos) instanceof GtBushBlockEntity bushEntity) {
            bushEntity.setBushData(berryType, growthStage, clusterSize, hasFruit);
        }
    }
}
