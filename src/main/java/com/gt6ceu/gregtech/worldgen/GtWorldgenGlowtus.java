/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenGlowtus.java
 * Purpose: Place glowtus plants in humid biomes on water surfaces.
 * Status: PORTED
 * Notes: Uses simplified biome checks and GT placeholder block.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtVariantBlock;
import com.gt6ceu.gregtech.blockentity.GtGlowtusBlockEntity;
import com.gt6ceu.gregtech.registry.GTBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;

public class GtWorldgenGlowtus implements GtChunkWorldgen {
    private final String id;
    private final int amount;
    private final int probability;

    public GtWorldgenGlowtus(String id, int amount, int probability) {
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
            BlockPos surface = new BlockPos(x, level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, x, z), z);
            Biome biome = level.getBiome(surface).value();
            if (!level.getBiome(surface).is(BiomeTags.IS_JUNGLE) && !level.getBiome(surface).is(BiomeTags.IS_SWAMP)) {
                continue;
            }
            if (!GtWorldgenClimate.isHumid(biome)) {
                continue;
            }
            if (level.getBlockState(surface).is(Blocks.WATER) && level.getBlockState(surface.above()).isAir()) {
                int variant = new GtNoiseGenerator(level).get(x / 3.0f, 200, z / 3.0f, 6);
                int age = random.nextInt(5);
                placeGlowtus(level, surface.above(), variant, age);
                if (random.nextBoolean()) {
                    placeGlowtus(level, surface.above().above(), variant, age + 1);
                }
                if (random.nextInt(3) == 0) {
                    placeGlowtus(level, surface.above().north(), variant, age);
                }
            }
        }
    }

    private void placeGlowtus(ServerLevel level, BlockPos pos, int variant, int age) {
        if (!level.getBlockState(pos).isAir()) {
            return;
        }
        level.setBlock(pos, GTBlocks.GLOWTUS.get().defaultBlockState().setValue(GtVariantBlock.VARIANT, variant), 2);
        if (level.getBlockEntity(pos) instanceof GtGlowtusBlockEntity glowtusEntity) {
            glowtusEntity.setVariant(variant, age);
        }
    }
}
