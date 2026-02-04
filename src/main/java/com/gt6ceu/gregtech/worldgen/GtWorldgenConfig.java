/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/data/CS.java (ConfigsGT.WORLDGEN/WORLDGEN_GT5)
 * Purpose: Provide access to GT6-aligned worldgen configuration flags.
 * Status: PORTED
 * Notes: Mirrors legacy config keys via the modern ModConfigSpec.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.Config;

public final class GtWorldgenConfig {
    private GtWorldgenConfig() {
    }

    public static boolean generateInfiniteOilSources() {
        return Config.GENERATE_INFINITE_OIL_SOURCES.getAsBoolean();
    }

    public static boolean generateInfiniteGasSources() {
        return Config.GENERATE_INFINITE_GAS_SOURCES.getAsBoolean();
    }

    public static int customBedrockOreSlots() {
        return Config.AMOUNT_OF_CUSTOM_BEDROCK_ORE_SLOTS.getAsInt();
    }

    public static int customSmallOreSlots() {
        return Config.AMOUNT_OF_CUSTOM_SMALL_ORE_SLOTS.getAsInt();
    }

    public static int customLargeVeinSlots() {
        return Config.AMOUNT_OF_CUSTOM_LARGE_VEIN_SLOTS.getAsInt();
    }

    public static boolean enableChunkWorldgen() {
        return Config.ENABLE_CHUNK_WORLDGEN.getAsBoolean();
    }

    public static boolean enablePlacedFeatureWorldgen() {
        return Config.ENABLE_PLACED_FEATURE_WORLDGEN.getAsBoolean();
    }

    public static boolean disableVanillaOreFeatures() {
        return Config.DISABLE_VANILLA_ORE_FEATURES.getAsBoolean();
    }

    public static boolean randomSmallGemEnabled(GtOreMaterial material) {
        return switch (material) {
            case EMERALD -> Config.RANDOM_SMALL_GEM_ORE_EMERALD.getAsBoolean();
            case DIAMOND -> Config.RANDOM_SMALL_GEM_ORE_DIAMOND.getAsBoolean();
            case RUBY -> Config.RANDOM_SMALL_GEM_ORE_RUBY.getAsBoolean();
            case SAPPHIRE -> Config.RANDOM_SMALL_GEM_ORE_SAPPHIRE.getAsBoolean();
            default -> true;
        };
    }
}
