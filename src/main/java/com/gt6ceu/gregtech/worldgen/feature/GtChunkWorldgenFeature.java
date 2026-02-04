/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenStoneLayers.java
 * Purpose: Run GT6 chunk worldgen via the placed-feature pipeline.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.worldgen.feature;

import com.gt6ceu.gregtech.worldgen.GtChunkWorldgenRunner;
import com.mojang.serialization.Codec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class GtChunkWorldgenFeature extends Feature<NoneFeatureConfiguration> {
    public GtChunkWorldgenFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        if (!(level instanceof ServerLevel serverLevel)) {
            return false;
        }
        ChunkAccess chunk = serverLevel.getChunk(context.origin());
        RandomSource random = RandomSource.create(serverLevel.getSeed() ^ chunk.getPos().toLong());
        GtChunkWorldgenRunner.generate(serverLevel, chunk, random);
        return true;
    }
}
