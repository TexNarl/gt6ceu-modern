/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenStoneLayers.java
 * Purpose: Shared execution for GT6 chunk worldgen passes.
 * Status: PORTED
 * Notes: Keeps chunk persistent tags to avoid reprocessing.
 */
package com.gt6ceu.gregtech.worldgen;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.chunk.ChunkAccess;

public final class GtChunkWorldgenRunner {
    private static final String TAG_STONE_LAYERS = "gt6ceu_stone_layers";
    private static final GtStoneLayerWorldgen STONE_LAYER_WORLDGEN = new GtStoneLayerWorldgen();

    private GtChunkWorldgenRunner() {
    }

    public static void generate(ServerLevel level, ChunkAccess chunk) {
        RandomSource random = RandomSource.create(level.getSeed() ^ chunk.getPos().toLong());
        generate(level, chunk, random);
    }

    public static void generate(ServerLevel level, ChunkAccess chunk, RandomSource random) {
        CompoundTag tag = chunk.getPersistedData();
        if (!tag.getBoolean(TAG_STONE_LAYERS)) {
            STONE_LAYER_WORLDGEN.generate(level, chunk, level.getRandom());
            tag.putBoolean(TAG_STONE_LAYERS, true);
        }

        runExtraWorldgen(level, chunk, tag, random);
    }

    private static void runExtraWorldgen(ServerLevel level, ChunkAccess chunk, CompoundTag tag, RandomSource random) {
        for (GtChunkWorldgen worldgen : GtWorldgenRegistry.overworld()) {
            if (!worldgen.supports(level)) {
                continue;
            }
            String tagKey = "gt6ceu_worldgen_" + worldgen.id();
            if (tag.getBoolean(tagKey)) {
                continue;
            }
            worldgen.generate(level, chunk, random);
            tag.putBoolean(tagKey, true);
        }
        for (GtChunkWorldgen worldgen : GtWorldgenRegistry.nether()) {
            if (!worldgen.supports(level)) {
                continue;
            }
            String tagKey = "gt6ceu_worldgen_" + worldgen.id();
            if (tag.getBoolean(tagKey)) {
                continue;
            }
            worldgen.generate(level, chunk, random);
            tag.putBoolean(tagKey, true);
        }
        for (GtChunkWorldgen worldgen : GtWorldgenRegistry.dimensional()) {
            if (!worldgen.supports(level)) {
                continue;
            }
            String tagKey = "gt6ceu_worldgen_" + worldgen.id();
            if (tag.getBoolean(tagKey)) {
                continue;
            }
            worldgen.generate(level, chunk, random);
            tag.putBoolean(tagKey, true);
        }
    }
}
