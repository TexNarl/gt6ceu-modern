/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenOresLarge.java
 * Purpose: Place large GT6-style ore clusters based on registered ore tables.
 * Status: PORTED
 * Notes: Uses weighted table selection and simplified placement.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtOreBlock;
import com.gt6ceu.gregtech.registry.GTBlocks;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;

public class GtWorldgenOresLarge implements GtChunkWorldgen {
    private final String id;

    public GtWorldgenOresLarge(String id) {
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
        List<GtLargeOreVein> candidates = new ArrayList<>();
        int totalWeight = 0;
        for (GtLargeOreVein vein : GtWorldgenTables.largeOres()) {
            if (!vein.enabled() || !vein.supportsDimension(dimension)) {
                continue;
            }
            candidates.add(vein);
            totalWeight += Math.max(1, vein.weight());
        }
        if (candidates.isEmpty() || totalWeight == 0) {
            return;
        }

        int roll = random.nextInt(totalWeight);
        GtLargeOreVein selected = candidates.get(0);
        for (GtLargeOreVein vein : candidates) {
            roll -= Math.max(1, vein.weight());
            if (roll < 0) {
                selected = vein;
                break;
            }
        }
        placeVein(level, chunk, selected, random);
    }

    private void placeVein(ServerLevel level, ChunkAccess chunk, GtLargeOreVein vein, RandomSource random) {
        int minX = chunk.getPos().getMinBlockX();
        int minZ = chunk.getPos().getMinBlockZ();
        int minBuild = Math.max(level.getMinBuildHeight() + 1, vein.minY());
        int maxBuild = Math.min(level.getMaxBuildHeight() - 1, vein.maxY());
        if (minBuild >= maxBuild) {
            return;
        }
        int baseY = minBuild + random.nextInt(Math.max(1, maxBuild - minBuild));
        int baseX = minX + random.nextInt(16);
        int baseZ = minZ + random.nextInt(16);
        int attempts = Math.max(1, vein.size() * vein.density());
        for (int i = 0; i < attempts; i++) {
            int x = baseX + random.nextInt(vein.size() * 2 + 1) - vein.size();
            int y = baseY + random.nextInt(6) - 3;
            int z = baseZ + random.nextInt(vein.size() * 2 + 1) - vein.size();
            BlockPos pos = new BlockPos(x, y, z);
            if (!level.getBlockState(pos).is(Blocks.STONE) && !level.getBlockState(pos).is(Blocks.DEEPSLATE)) {
                continue;
            }
            GtOreMaterial material = selectMaterial(vein, y - baseY, random);
            if (material == GtOreMaterial.EMPTY) {
                material = fallbackMaterial(vein);
            }
            if (material == GtOreMaterial.EMPTY) {
                continue;
            }
            level.setBlock(pos, oreStateFor(level, pos, material), 2);
        }
    }

    private net.minecraft.world.level.block.state.BlockState oreStateFor(ServerLevel level, BlockPos pos, GtOreMaterial material) {
        boolean deepslate = level.getBlockState(pos).is(Blocks.DEEPSLATE);
        return GTBlocks.ORE_NORMAL.get().defaultBlockState()
                .setValue(GtOreBlock.MATERIAL, material.getId())
                .setValue(GtOreBlock.STONE_TYPE, deepslate ? GtStoneType.DEEPSLATE.getId() : GtStoneType.GRANITE.getId());
    }

    private GtOreMaterial selectMaterial(GtLargeOreVein vein, int offsetY, RandomSource random) {
        if (offsetY <= -1) {
            return vein.bottom();
        }
        if (offsetY >= 2) {
            return vein.top();
        }
        if (random.nextBoolean()) {
            return vein.between();
        }
        return vein.spread();
    }

    private GtOreMaterial fallbackMaterial(GtLargeOreVein vein) {
        if (vein.top() != GtOreMaterial.EMPTY) {
            return vein.top();
        }
        if (vein.bottom() != GtOreMaterial.EMPTY) {
            return vein.bottom();
        }
        if (vein.between() != GtOreMaterial.EMPTY) {
            return vein.between();
        }
        return vein.spread();
    }
}
