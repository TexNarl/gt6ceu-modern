/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenStoneLayers.java
 * Purpose: Apply GT6 stone layer replacement and ore placement.
 * Status: PORTED
 * Notes: Uses chunk load event to mutate blocks with GT6 rules.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtStoneBlock;
import com.gt6ceu.gregtech.block.StoneVariant;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.material.Material;

public class GtStoneLayerWorldgen {
    public boolean generate(ServerLevel level, ChunkAccess chunk, RandomSource random) {
        if (GtStoneLayer.LAYERS.isEmpty()) {
            return false;
        }

        GtNoiseGenerator noise = new GtNoiseGenerator(level);
        LevelChunkSection[] sections = chunk.getSections();
        int listSize = GtStoneLayer.LAYERS.size();
        int maxY = chunk.getHighestSectionPosition() + 15;
        GtStoneLayer[] scan = new GtStoneLayer[7];
        int scanMinusOne = scan.length - 1;
        Block lastReplaced = Blocks.STONE;

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        int minX = chunk.getPos().getMinBlockX();
        int minZ = chunk.getPos().getMinBlockZ();

        for (int dx = 0; dx < 16; dx++) {
            for (int dz = 0; dz < 16; dz++) {
                int x = minX + dx;
                int z = minZ + dz;
                for (int k = 0; k < scan.length; k++) {
                    scan[k] = GtStoneLayer.LAYERS.get(noise.get(x, k - 2, z, listSize));
                    if (scan[k].isNoDeep()) {
                        scan[k] = GtStoneLayer.DEEPSLATE;
                    }
                }

                boolean canPlaceRocks = false;
                GtOreMaterial lastRock = GtOreMaterial.EMPTY;
                GtOreMaterial lastOre = null;
                GtOreMaterial[] lastOreHolder = new GtOreMaterial[1];

                for (int y = level.getMinBuildHeight() + 1; y <= maxY; y++) {
                    int sectionIndex = SectionPos.blockToSectionCoord(y) - chunk.getMinSection();
                    if (sectionIndex < 0 || sectionIndex >= sections.length) {
                        continue;
                    }
                    LevelChunkSection section = sections[sectionIndex];
                    if (section == null || section.hasOnlyAir()) {
                        if (canPlaceRocks && random.nextInt(128) == 0) {
                            placeRockIndicator(level, pos, x, y, z, lastOre, lastRock, random);
                        }
                        lastOre = null;
                        canPlaceRocks = false;
                        shiftScan(noise, scan, scanMinusOne, x, y, z, listSize);
                        continue;
                    }

                    BlockState state = section.getBlockState(dx, y & 15, dz);
                    Block block = state.getBlock();

                    if (block == Blocks.BEDROCK) {
                        canPlaceRocks = true;
                    } else if (block == Blocks.AIR) {
                        if (canPlaceRocks && random.nextInt(128) == 0) {
                            placeRockIndicator(level, pos, x, y, z, lastOre, lastRock, random);
                        }
                        lastOre = null;
                        canPlaceRocks = false;
                    } else if (isVanillaStone(block)) {
                        canPlaceRocks = true;
                        lastOreHolder[0] = null;
                        boolean placed = tryPlaceLayerOre(scan, level, random, x, y, z, lastOreHolder);
                        if (lastOreHolder[0] != null) {
                            lastOre = lastOreHolder[0];
                        }
                        if (!placed && scan[4] != scan[2] && !GtStoneLayer.RANDOM_SMALL_GEM_ORES.isEmpty() && random.nextInt(100) == 0) {
                            GtOreMaterial gem = GtStoneLayer.RANDOM_SMALL_GEM_ORES.get(random.nextInt(GtStoneLayer.RANDOM_SMALL_GEM_ORES.size()));
                            if (scan[3].getSmallOreState(gem) != null) {
                                level.setBlock(pos.set(x, y, z), scan[3].getSmallOreState(gem), 2);
                                placed = true;
                            }
                        }
                        if (!placed) {
                            lastRock = scan[3].surfaceMaterial();
                            if (!state.equals(scan[3].stoneState())) {
                                section.setBlockState(dx, y & 15, dz, scan[3].stoneState(), false);
                            }
                        }
                    } else if (block == Blocks.COBBLESTONE) {
                        canPlaceRocks = true;
                        lastRock = scan[3].surfaceMaterial();
                        if (!state.equals(scan[3].cobbleState())) {
                            section.setBlockState(dx, y & 15, dz, scan[3].cobbleState(), false);
                        }
                    } else if (block == Blocks.MOSSY_COBBLESTONE) {
                        canPlaceRocks = true;
                        lastRock = scan[3].surfaceMaterial();
                        if (!state.equals(scan[3].mossyState())) {
                            section.setBlockState(dx, y & 15, dz, scan[3].mossyState(), false);
                        }
                    } else if (block instanceof GtStoneBlock) {
                        canPlaceRocks = state.getValue(GtStoneBlock.VARIANT) == StoneVariant.STONE;
                    } else if (block == lastReplaced || GtStoneLayer.REPLACEABLE_BLOCKS.contains(block)) {
                        lastReplaced = block;
                        canPlaceRocks = true;
                        lastOreHolder[0] = null;
                        boolean placed = tryPlaceLayerOre(scan, level, random, x, y, z, lastOreHolder);
                        if (lastOreHolder[0] != null) {
                            lastOre = lastOreHolder[0];
                        }
                        if (!placed && scan[4] != scan[2] && !GtStoneLayer.RANDOM_SMALL_GEM_ORES.isEmpty() && random.nextInt(100) == 0) {
                            GtOreMaterial gem = GtStoneLayer.RANDOM_SMALL_GEM_ORES.get(random.nextInt(GtStoneLayer.RANDOM_SMALL_GEM_ORES.size()));
                            if (scan[3].getSmallOreState(gem) != null) {
                                level.setBlock(pos.set(x, y, z), scan[3].getSmallOreState(gem), 2);
                                placed = true;
                            }
                        }
                        if (!placed) {
                            lastRock = scan[3].surfaceMaterial();
                            if (!state.equals(scan[3].stoneState())) {
                                section.setBlockState(dx, y & 15, dz, scan[3].stoneState(), false);
                            }
                        }
                    } else if (state.getMaterial().isReplaceable()) {
                        if (canPlaceRocks && !state.getMaterial().isLiquid() && random.nextInt(128) == 0) {
                            placeRockIndicator(level, pos, x, y, z, lastOre, lastRock, random);
                        }
                        lastOre = null;
                        canPlaceRocks = false;
                    } else {
                        if (state.isSolidRender(level, pos.set(x, y, z))) {
                            Material material = state.getMaterial();
                            canPlaceRocks = material == Material.CLAY || material == Material.SAND || material == Material.GRASS || material == Material.DIRT;
                        } else {
                            lastOre = null;
                            canPlaceRocks = false;
                        }
                    }

                    shiftScan(noise, scan, scanMinusOne, x, y, z, listSize);
                }
            }
        }

        return true;
    }

    private boolean tryPlaceLayerOre(GtStoneLayer[] scan, ServerLevel level, RandomSource random, int x, int y, int z,
                                     GtOreMaterial[] lastOreHolder) {
        if (scan[5] == scan[1]) {
            for (GtStoneLayerOre ore : scan[3].ores()) {
                if (ore.check(level, y, random)) {
                    if (scan[6] == scan[0] ? ore.placeNormal(scan[3], level, x, y, z) : ore.placeSmall(scan[3], level, x, y, z)) {
                        if (ore.generatesIndicators()) {
                            lastOreHolder[0] = ore.getMaterial();
                        }
                        return true;
                    }
                }
            }
        } else {
            List<GtStoneLayerOre> ores = GtStoneLayer.get(scan[5], scan[1]);
            for (GtStoneLayerOre ore : ores) {
                if (ore.check(level, y, random)) {
                    if (ore.place(scan[3], level, x, y, z, random)) {
                        if (ore.generatesIndicators()) {
                            lastOreHolder[0] = ore.getMaterial();
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isVanillaStone(Block block) {
        return block == Blocks.STONE
                || block == Blocks.ANDESITE
                || block == Blocks.DIORITE
                || block == Blocks.GRANITE
                || block == Blocks.DEEPSLATE;
    }

    private void placeRockIndicator(ServerLevel level, BlockPos.MutableBlockPos pos, int x, int y, int z, GtOreMaterial lastOre,
                                    GtOreMaterial lastRock, RandomSource random) {
        GtOreMaterial material = lastRock;
        if (random.nextBoolean() && lastOre != null) {
            material = lastOre;
        }
        BlockState state = GtStoneLayer.DEEPSLATE.getNormalOreState(material);
        if (state != null) {
            level.setBlock(pos.set(x, y, z), state, 2);
        }
    }

    private void shiftScan(GtNoiseGenerator noise, GtStoneLayer[] scan, int scanMinusOne, int x, int y, int z, int listSize) {
        for (int t = 0; t < scanMinusOne; t++) {
            scan[t] = scan[t + 1];
        }
        scan[scanMinusOne] = GtStoneLayer.LAYERS.get(noise.get(x, y - 2 + scanMinusOne, z, listSize));
        if (y - 2 + scanMinusOne < 24 && scan[scanMinusOne].isNoDeep()) {
            scan[scanMinusOne] = GtStoneLayer.DEEPSLATE;
        }
    }
}
