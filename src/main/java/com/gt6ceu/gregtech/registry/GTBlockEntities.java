/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/block/multitileentity data
 * Purpose: Register block entities for GT surface worldgen blocks.
 * Status: PORTED
 * Notes: Provides NBT-backed variants for hives, bushes, glowtus, and fluid springs.
 */
package com.gt6ceu.gregtech.registry;

import com.gt6ceu.GT6CEuModern;
import com.gt6ceu.gregtech.blockentity.GtBushBlockEntity;
import com.gt6ceu.gregtech.blockentity.GtFluidSpringBlockEntity;
import com.gt6ceu.gregtech.blockentity.GtGlowtusBlockEntity;
import com.gt6ceu.gregtech.blockentity.GtHiveBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryObject;

public final class GTBlockEntities {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, GT6CEuModern.MODID);

    public static final RegistryObject<BlockEntityType<GtHiveBlockEntity>> HIVE =
            BLOCK_ENTITIES.register("bumble_hive", () ->
                    BlockEntityType.Builder.of(GtHiveBlockEntity::new, GTBlocks.BUMBLE_HIVE.get()).build(null));
    public static final RegistryObject<BlockEntityType<GtBushBlockEntity>> BUSH =
            BLOCK_ENTITIES.register("surface_bush", () ->
                    BlockEntityType.Builder.of(GtBushBlockEntity::new, GTBlocks.SURFACE_BUSH.get()).build(null));
    public static final RegistryObject<BlockEntityType<GtGlowtusBlockEntity>> GLOWTUS =
            BLOCK_ENTITIES.register("glowtus", () ->
                    BlockEntityType.Builder.of(GtGlowtusBlockEntity::new, GTBlocks.GLOWTUS.get()).build(null));
    public static final RegistryObject<BlockEntityType<GtFluidSpringBlockEntity>> FLUID_SPRING =
            BLOCK_ENTITIES.register("fluid_spring", () ->
                    BlockEntityType.Builder.of(GtFluidSpringBlockEntity::new, GTBlocks.FLUID_SPRING.get()).build(null));

    private GTBlockEntities() {
    }

    public static void register(IEventBus modEventBus) {
        BLOCK_ENTITIES.register(modEventBus);
    }
}
