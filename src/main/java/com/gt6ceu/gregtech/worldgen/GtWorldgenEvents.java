/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenStoneLayers.java
 * Purpose: Hook GT6 stone layer worldgen into chunk load.
 * Status: PORTED
 * Notes: Uses chunk persistent data to avoid reprocessing.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.registry.GTWorldgenFeatures;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BiomeLoadingEvent;
import net.neoforged.neoforge.event.level.ChunkEvent;

public final class GtWorldgenEvents {
    private GtWorldgenEvents() {
    }

    @SubscribeEvent
    public static void onChunkLoad(ChunkEvent.Load event) {
        if (!GtWorldgenConfig.enableChunkWorldgen() || GtWorldgenConfig.enablePlacedFeatureWorldgen()) {
            return;
        }
        if (!(event.getLevel() instanceof ServerLevel level)) {
            return;
        }
        ChunkAccess chunk = event.getChunk();
        GtChunkWorldgenRunner.generate(level, chunk);
    }

    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent event) {
        if (!GtWorldgenConfig.disableVanillaOreFeatures()) {
            return;
        }
        event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).clear();
    }
    @SubscribeEvent
    public static void onBiomeLoadingAddFeatures(BiomeLoadingEvent event) {
        if (!GtWorldgenConfig.enablePlacedFeatureWorldgen()) {
            return;
        }
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                GTWorldgenFeatures.GT_CHUNK_WORLDGEN_PLACED.getHolder().orElseThrow());
    }
}
