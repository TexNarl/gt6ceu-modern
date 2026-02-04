/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/worldgen/StoneLayer.java
 * Purpose: Define stone layer metadata, ore mappings, and lookup tables.
 * Status: PORTED
 * Notes: Uses blockstate properties instead of legacy metadata IDs.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.block.GtOreBlock;
import com.gt6ceu.gregtech.block.GtStoneBlock;
import com.gt6ceu.gregtech.block.StoneVariant;
import com.gt6ceu.gregtech.registry.GTBlocks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class GtStoneLayer {
    public static final List<GtStoneLayer> LAYERS = new ArrayList<>();
    public static final Map<GtOreMaterial, Map<GtOreMaterial, List<GtStoneLayerOre>>> MAP = new HashMap<>();
    public static final List<GtOreMaterial> RANDOM_SMALL_GEM_ORES = new ArrayList<>();
    public static final Set<Block> REPLACEABLE_BLOCKS = new HashSet<>();
    public static GtStoneLayer DEEPSLATE;

    static {
        REPLACEABLE_BLOCKS.add(Blocks.STONE);
        REPLACEABLE_BLOCKS.add(Blocks.COAL_ORE);
        REPLACEABLE_BLOCKS.add(Blocks.IRON_ORE);
        REPLACEABLE_BLOCKS.add(Blocks.GOLD_ORE);
        REPLACEABLE_BLOCKS.add(Blocks.DIAMOND_ORE);
        REPLACEABLE_BLOCKS.add(Blocks.EMERALD_ORE);
        REPLACEABLE_BLOCKS.add(Blocks.LAPIS_ORE);
        REPLACEABLE_BLOCKS.add(Blocks.REDSTONE_ORE);
    }

    private final BlockState stoneState;
    private final BlockState cobbleState;
    private final BlockState mossyState;
    private final GtStoneType stoneType;
    private final GtOreMaterial material;
    private final GtOreMaterial surfaceMaterial;
    private final List<GtStoneLayerOre> ores = new ArrayList<>();
    private boolean noDeep;

    public GtStoneLayer(GtStoneType stoneType, GtOreMaterial material, BlockState stoneState,
                        BlockState cobbleState, BlockState mossyState, GtStoneLayerOre... oreChances) {
        this.stoneType = stoneType == null ? GtStoneType.DEEPSLATE : stoneType;
        this.material = material == null ? GtOreMaterial.EMPTY : material;
        this.surfaceMaterial = material == null ? GtOreMaterial.EMPTY : material;
        this.stoneState = stoneState == null ? Blocks.STONE.defaultBlockState() : stoneState;
        this.cobbleState = cobbleState == null ? Blocks.COBBLESTONE.defaultBlockState() : cobbleState;
        this.mossyState = mossyState == null ? Blocks.MOSSY_COBBLESTONE.defaultBlockState() : mossyState;
        if (oreChances != null) {
            for (GtStoneLayerOre ore : oreChances) {
                if (ore != null && ore.getMaterial() != GtOreMaterial.EMPTY) {
                    ores.add(ore);
                }
            }
        }
    }

    public static GtStoneLayer createDefaultStoneLayer(GtStoneType stoneType, GtOreMaterial material, GtStoneLayerOre... oreChances) {
        BlockState stone = GTBlocks.STONE_BLOCKS.get(stoneType).get().defaultBlockState().setValue(GtStoneBlock.VARIANT, StoneVariant.STONE);
        BlockState cobble = GTBlocks.STONE_BLOCKS.get(stoneType).get().defaultBlockState().setValue(GtStoneBlock.VARIANT, StoneVariant.COBBLE);
        BlockState mossy = GTBlocks.STONE_BLOCKS.get(stoneType).get().defaultBlockState().setValue(GtStoneBlock.VARIANT, StoneVariant.MOSSY);
        return new GtStoneLayer(stoneType, material, stone, cobble, mossy, oreChances);
    }

    public GtStoneLayer setNoDeep() {
        this.noDeep = true;
        return this;
    }

    public boolean isNoDeep() {
        return noDeep;
    }

    public BlockState stoneState() {
        return stoneState;
    }

    public BlockState cobbleState() {
        return cobbleState;
    }

    public BlockState mossyState() {
        return mossyState;
    }

    public GtOreMaterial surfaceMaterial() {
        return surfaceMaterial;
    }

    public List<GtStoneLayerOre> ores() {
        return ores;
    }

    public BlockState getNormalOreState(GtOreMaterial oreMaterial) {
        return oreState(GTBlocks.ORE_NORMAL, oreMaterial);
    }

    public BlockState getSmallOreState(GtOreMaterial oreMaterial) {
        return oreState(GTBlocks.ORE_SMALL, oreMaterial);
    }

    public BlockState getBrokenOreState(GtOreMaterial oreMaterial) {
        return oreState(GTBlocks.ORE_BROKEN, oreMaterial);
    }

    private BlockState oreState(net.neoforged.neoforge.registries.RegistryObject<GtOreBlock> oreBlock,
                                GtOreMaterial oreMaterial) {
        return oreBlock.get().defaultBlockState()
                .setValue(GtOreBlock.MATERIAL, oreMaterial.getId())
                .setValue(GtOreBlock.STONE_TYPE, stoneType.getId());
    }

    public static boolean bothSides(GtOreMaterial top, GtOreMaterial bottom, GtStoneLayerOre... oreChances) {
        return topBottom(top, bottom, oreChances) && topBottom(bottom, top, oreChances);
    }

    public static boolean topBottom(GtOreMaterial top, GtOreMaterial bottom, GtStoneLayerOre... oreChances) {
        if (oreChances.length == 0) {
            return false;
        }
        Map<GtOreMaterial, List<GtStoneLayerOre>> map = MAP.computeIfAbsent(top, key -> new HashMap<>());
        List<GtStoneLayerOre> list = map.computeIfAbsent(bottom, key -> new ArrayList<>(oreChances.length));
        Collections.addAll(list, oreChances);
        return true;
    }

    private static GtOreMaterial lastTop;
    private static GtOreMaterial lastBottom;
    private static List<GtStoneLayerOre> lastList = Collections.emptyList();

    public static List<GtStoneLayerOre> get(GtStoneLayer top, GtStoneLayer bottom) {
        return get(top.material, bottom.material);
    }

    public static List<GtStoneLayerOre> get(GtOreMaterial top, GtOreMaterial bottom) {
        if (top == lastTop && bottom == lastBottom) {
            return lastList;
        }
        lastTop = top;
        lastBottom = bottom;
        Map<GtOreMaterial, List<GtStoneLayerOre>> map = MAP.get(top);
        if (map == null) {
            lastList = Collections.emptyList();
            return lastList;
        }
        List<GtStoneLayerOre> list = map.get(bottom);
        if (list == null) {
            lastList = Collections.emptyList();
            return lastList;
        }
        lastList = list;
        return list;
    }
}
