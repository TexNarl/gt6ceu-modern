/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/worldgen/WorldgenOresSmall.java
 * Purpose: Place small GT6-style ore deposits based on registered ore tables.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtOreBlock;
import com.gt6ceu.gregtech.registry.GTBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.block.state.BlockState;

public class GtWorldgenOresSmall implements GtChunkWorldgen {
    private final String id;

    public GtWorldgenOresSmall(String id) {
        this.id = id;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public boolean supports(ServerLevel level) {
        return true;
    }

    @Override
    public void generate(ServerLevel level, ChunkAccess chunk, RandomSource random) {
        GtWorldgenTables.bootstrap();
        GtWorldgenDimension dimension = GtWorldgenDimension.fromLevel(level);
        if (dimension == null) {
            return;
        }
        int minX = chunk.getPos().getMinBlockX();
        int minZ = chunk.getPos().getMinBlockZ();
        int minBuild = level.getMinBuildHeight() + 1;
        int maxBuild = level.getMaxBuildHeight() - 1;
        for (GtSmallOreDeposit deposit : GtWorldgenTables.smallOres()) {
            if (!deposit.enabled() || !deposit.supportsDimension(dimension)) {
                continue;
            }
            int minY = Math.max(minBuild, deposit.minY());
            int maxY = Math.min(maxBuild, deposit.maxY());
            if (minY >= maxY) {
                continue;
            }
            for (int i = 0; i < deposit.amount(); i++) {
                int x = minX + random.nextInt(16);
                int y = minY + random.nextInt(Math.max(1, maxY - minY));
                int z = minZ + random.nextInt(16);
                BlockPos pos = new BlockPos(x, y, z);
                if (!level.getBlockState(pos).is(Blocks.STONE) && !level.getBlockState(pos).is(Blocks.DEEPSLATE)) {
                    continue;
                }
                level.setBlock(pos, oreStateFor(level, pos, deposit.material()), 2);
            }
        }
    }

    private BlockState oreStateFor(ServerLevel level, BlockPos pos, GtOreMaterial material) {
        boolean deepslate = level.getBlockState(pos).is(Blocks.DEEPSLATE);
        return GTBlocks.ORE_SMALL.get().defaultBlockState()
                .setValue(GtOreBlock.MATERIAL, material.getId())
                .setValue(GtOreBlock.STONE_TYPE, deepslate ? GtStoneType.DEEPSLATE.getId() : GtStoneType.GRANITE.getId());
    }
}
