/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/worldgen/WorldgenObject.java
 * Purpose: Minimal interface for chunk-level worldgen passes.
 * Status: PORTED
 * Notes: Used to run GT6-style generators on chunk load.
 */
package com.gt6ceu.gregtech.worldgen;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.chunk.ChunkAccess;

public interface GtChunkWorldgen {
    String id();

    boolean supports(ServerLevel level);

    void generate(ServerLevel level, ChunkAccess chunk, RandomSource random);
}
