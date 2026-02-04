/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/loaders/b/Loader_Worldgen.java
 * Purpose: Register GT6 placed-feature worldgen entries.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.registry;

import com.gt6ceu.GT6CEuModern;
import com.gt6ceu.gregtech.worldgen.feature.GtChunkWorldgenFeature;
import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightmapPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryObject;

public final class GTWorldgenFeatures {
    private static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, GT6CEuModern.MODID);
    private static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registries.CONFIGURED_FEATURE, GT6CEuModern.MODID);
    private static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registries.PLACED_FEATURE, GT6CEuModern.MODID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GT_CHUNK_WORLDGEN =
            FEATURES.register("gt_chunk_worldgen", () -> new GtChunkWorldgenFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GT_CHUNK_WORLDGEN_CONFIGURED =
            CONFIGURED_FEATURES.register("gt_chunk_worldgen",
                    () -> new ConfiguredFeature<>(GT_CHUNK_WORLDGEN.get(), NoneFeatureConfiguration.INSTANCE));

    public static final RegistryObject<PlacedFeature> GT_CHUNK_WORLDGEN_PLACED =
            PLACED_FEATURES.register("gt_chunk_worldgen", () -> new PlacedFeature(
                    Holder.direct(GT_CHUNK_WORLDGEN_CONFIGURED.get()),
                    List.of(
                            CountPlacement.of(1),
                            InSquarePlacement.spread(),
                            HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                            BiomeFilter.biome()
                    )));

    private GTWorldgenFeatures() {
    }

    public static void register(IEventBus modEventBus) {
        FEATURES.register(modEventBus);
        CONFIGURED_FEATURES.register(modEventBus);
        PLACED_FEATURES.register(modEventBus);
    }
}
