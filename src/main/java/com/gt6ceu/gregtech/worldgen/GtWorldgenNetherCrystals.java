/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/nether/WorldgenNetherCrystals.java
 * Purpose: Place GT crystal ores in the Nether.
 * Status: PORTED
 * Notes: Uses noise to pick crystal meta variants.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtMetaBlock;
import com.gt6ceu.gregtech.registry.GTBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;

public class GtWorldgenNetherCrystals implements GtChunkWorldgen {
    private final String id;

    public GtWorldgenNetherCrystals(String id) {
        this.id = id;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public boolean supports(ServerLevel level) {
        return level.dimension() == ServerLevel.NETHER;
    }

    @Override
    public void generate(ServerLevel level, ChunkAccess chunk, RandomSource random) {
        int minX = chunk.getPos().getMinBlockX();
        int minZ = chunk.getPos().getMinBlockZ();
        int x = minX + random.nextInt(16);
        int z = minZ + random.nextInt(16);
        int y = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, x, z);
        BlockPos pos = new BlockPos(x, y, z);
        if (!level.getBlockState(pos).is(Blocks.NETHERRACK) && !level.getBlockState(pos).is(Blocks.NETHER_BRICKS)) {
            return;
        }
        int meta = new GtNoiseGenerator(level).get(x / 2f, 360, z / 2f, 16);
        level.setBlock(pos, GTBlocks.CRYSTAL_ORES.get().defaultBlockState().setValue(GtMetaBlock.META, meta), 2);
    }
}
