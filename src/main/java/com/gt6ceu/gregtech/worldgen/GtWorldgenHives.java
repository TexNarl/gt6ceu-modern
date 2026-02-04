/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenHives.java
 * Purpose: Place bumble hive blocks in suitable surface biomes.
 * Status: PORTED
 * Notes: Simplified surface placement and biome checks.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtVariantBlock;
import com.gt6ceu.gregtech.blockentity.GtHiveBlockEntity;
import com.gt6ceu.gregtech.registry.GTBlocks;
import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;

public class GtWorldgenHives implements GtChunkWorldgen {
    private final String id;
    private final int amount;
    private final int probability;
    private final ResourceKey<Level> dimension;
    private final Predicate<Biome> biomePredicate;

    public GtWorldgenHives(String id, int amount, int probability) {
        this(id, amount, probability, Level.OVERWORLD, defaultOverworldBiomes());
    }

    public GtWorldgenHives(String id, int amount, int probability, ResourceKey<Level> dimension,
                           Predicate<Biome> biomePredicate) {
        this.id = id;
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
                HiveProfile profile = selectHiveProfile(biome, random);
                placeHiveCluster(level, pos, profile, random);
            }
        }
    }

    private HiveProfile selectHiveProfile(Biome biome, RandomSource random) {
        int speciesId;
        int color;
        int variant;
        if (GtWorldgenClimate.isCold(biome)) {
            speciesId = 700;
            color = 0xeeeeee;
            variant = 2;
        } else if (GtWorldgenClimate.isHot(biome)) {
            speciesId = 900;
            color = 0xcc8800;
            variant = 3;
        } else if (GtWorldgenClimate.isHumid(biome)) {
            speciesId = 600;
            color = 0x66aa44;
            variant = 1;
        } else {
            speciesId = 500;
            color = 0xbbbbbb;
            variant = 0;
        }
        int honeyLevel = random.nextInt(6);
        int population = 2 + random.nextInt(6);
        return new HiveProfile(speciesId, color, variant, random.nextInt(), honeyLevel, population);
    }

    private void placeHiveCluster(ServerLevel level, BlockPos pos, HiveProfile profile, RandomSource random) {
        placeHive(level, pos, profile);
        if (random.nextBoolean()) {
            placeHive(level, pos.above(), profile);
        }
        if (random.nextInt(3) == 0) {
            placeHive(level, pos.north(), profile);
        }
        if (random.nextInt(3) == 0) {
            placeHive(level, pos.east(), profile);
        }
        if (random.nextInt(4) == 0) {
            placeHive(level, pos.south(), profile);
        }
    }

    private void placeHive(ServerLevel level, BlockPos pos, HiveProfile profile) {
        if (!level.getBlockState(pos).isAir()) {
            return;
        }
        level.setBlock(pos, GTBlocks.BUMBLE_HIVE.get().defaultBlockState().setValue(GtVariantBlock.VARIANT, profile.variant()), 2);
        if (level.getBlockEntity(pos) instanceof GtHiveBlockEntity hiveEntity) {
            hiveEntity.setHiveData(profile.speciesId(), profile.color(), profile.seed(), profile.honeyLevel(), profile.population());
        }
    }

    private record HiveProfile(int speciesId, int color, int variant, int seed, int honeyLevel, int population) {
    }

    private static Predicate<Biome> defaultOverworldBiomes() {
        return biome -> biome.is(BiomeTags.IS_FOREST)
                || biome.is(BiomeTags.IS_PLAINS)
                || biome.is(BiomeTags.IS_JUNGLE);
    }
}
