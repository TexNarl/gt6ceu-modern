/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/data/CS.java (BlocksGT)
 * Purpose: Register GT stone and ore blocks required for worldgen.
 * Status: PORTED
 * Notes: Uses DeferredRegister for block/item registration.
 */
package com.gt6ceu.gregtech.registry;

import com.gt6ceu.GT6CEuModern;
import com.gt6ceu.gregtech.block.GtBushBlock;
import com.gt6ceu.gregtech.block.GtFluidSpringBlock;
import com.gt6ceu.gregtech.block.GtGlowtusBlock;
import com.gt6ceu.gregtech.block.GtHiveBlock;
import com.gt6ceu.gregtech.block.GtMetaBlock;
import com.gt6ceu.gregtech.block.GtOreBlock;
import com.gt6ceu.gregtech.block.GtStoneBlock;
import com.gt6ceu.gregtech.worldgen.GtStoneType;
import java.util.EnumMap;
import java.util.Map;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryObject;

public final class GTBlocks {
    private static final DeferredRegister.Blocks BLOCKS = GT6CEuModern.BLOCKS;
    private static final DeferredRegister.Items ITEMS = GT6CEuModern.ITEMS;

    public static final Map<GtStoneType, RegistryObject<GtStoneBlock>> STONE_BLOCKS = new EnumMap<>(GtStoneType.class);

    public static final RegistryObject<GtOreBlock> ORE_NORMAL = BLOCKS.register("ore_normal", () -> new GtOreBlock(defaultStoneProperties()));
    public static final RegistryObject<GtOreBlock> ORE_SMALL = BLOCKS.register("ore_small", () -> new GtOreBlock(defaultStoneProperties()));
    public static final RegistryObject<GtOreBlock> ORE_BROKEN = BLOCKS.register("ore_broken", () -> new GtOreBlock(defaultStoneProperties()));

    public static final RegistryObject<GtMetaBlock> ROCK_ORES = BLOCKS.register("rock_ores", () -> new GtMetaBlock(defaultStoneProperties()));
    public static final RegistryObject<GtMetaBlock> CRYSTAL_ORES = BLOCKS.register("crystal_ores", () -> new GtMetaBlock(defaultStoneProperties()));
    public static final RegistryObject<GtMetaBlock> DIGGABLES = BLOCKS.register("diggables", () -> new GtMetaBlock(defaultStoneProperties()));
    public static final RegistryObject<GtMetaBlock> SANDS = BLOCKS.register("sands", () -> new GtMetaBlock(defaultStoneProperties()));
    public static final RegistryObject<GtMetaBlock> RACKS = BLOCKS.register("racks", () -> new GtMetaBlock(defaultStoneProperties()));
    public static final RegistryObject<GtMetaBlock> COLTAN = BLOCKS.register("coltan", () -> new GtMetaBlock(defaultStoneProperties()));
    public static final RegistryObject<Block> SURFACE_ROCK = BLOCKS.register("surface_rock", () -> new Block(defaultStoneProperties()));
    public static final RegistryObject<Block> SURFACE_STICK = BLOCKS.register("surface_stick", () -> new Block(defaultStoneProperties()));
    public static final RegistryObject<Block> PRISMARINE_DARK = BLOCKS.register("prismarine_dark", () -> new Block(defaultStoneProperties()));
    public static final RegistryObject<Block> PRISMARINE_LIGHT = BLOCKS.register("prismarine_light", () -> new Block(defaultStoneProperties()));
    public static final RegistryObject<Block> RIVER_WATER = BLOCKS.register("river_water", () -> new Block(defaultFluidProperties()));
    public static final RegistryObject<Block> OCEAN_WATER = BLOCKS.register("ocean_water", () -> new Block(defaultFluidProperties()));
    public static final RegistryObject<Block> SWAMP_WATER = BLOCKS.register("swamp_water", () -> new Block(defaultFluidProperties()));
    public static final RegistryObject<GtBushBlock> SURFACE_BUSH = BLOCKS.register("surface_bush", () -> new GtBushBlock(defaultPlantProperties()));
    public static final RegistryObject<GtGlowtusBlock> GLOWTUS = BLOCKS.register("glowtus", () -> new GtGlowtusBlock(defaultPlantProperties()));
    public static final RegistryObject<GtHiveBlock> BUMBLE_HIVE = BLOCKS.register("bumble_hive", () -> new GtHiveBlock(defaultWoodProperties()));
    public static final RegistryObject<GtFluidSpringBlock> FLUID_SPRING = BLOCKS.register("fluid_spring", () -> new GtFluidSpringBlock(defaultFluidProperties()));

    static {
        for (GtStoneType type : GtStoneType.values()) {
            STONE_BLOCKS.put(type, BLOCKS.register(type.getRegistryName(), () -> new GtStoneBlock(defaultStoneProperties())));
        }
    }

    private GTBlocks() {
    }

    public static void register(IEventBus modEventBus) {
        for (RegistryObject<GtStoneBlock> stoneBlock : STONE_BLOCKS.values()) {
            registerBlockItem(stoneBlock);
        }
        registerBlockItem(ORE_NORMAL);
        registerBlockItem(ORE_SMALL);
        registerBlockItem(ORE_BROKEN);
        registerBlockItem(ROCK_ORES);
        registerBlockItem(CRYSTAL_ORES);
        registerBlockItem(DIGGABLES);
        registerBlockItem(SANDS);
        registerBlockItem(RACKS);
        registerBlockItem(COLTAN);
        registerBlockItem(SURFACE_ROCK);
        registerBlockItem(SURFACE_STICK);
        registerBlockItem(PRISMARINE_DARK);
        registerBlockItem(PRISMARINE_LIGHT);
        registerBlockItem(RIVER_WATER);
        registerBlockItem(OCEAN_WATER);
        registerBlockItem(SWAMP_WATER);
        registerBlockItem(SURFACE_BUSH);
        registerBlockItem(GLOWTUS);
        registerBlockItem(BUMBLE_HIVE);
        registerBlockItem(FLUID_SPRING);
    }

    private static void registerBlockItem(RegistryObject<? extends Block> blockSupplier) {
        ITEMS.register(blockSupplier.getId().getPath(),
                () -> new BlockItem(blockSupplier.get(), new Item.Properties()));
    }

    private static BlockBehaviour.Properties defaultStoneProperties() {
        return BlockBehaviour.Properties.of().strength(1.5f, 6.0f).sound(SoundType.STONE);
    }

    private static BlockBehaviour.Properties defaultFluidProperties() {
        return BlockBehaviour.Properties.of().strength(100.0f).noOcclusion();
    }

    private static BlockBehaviour.Properties defaultPlantProperties() {
        return BlockBehaviour.Properties.of().strength(0.2f).noOcclusion().sound(SoundType.GRASS);
    }

    private static BlockBehaviour.Properties defaultWoodProperties() {
        return BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD);
    }
}
