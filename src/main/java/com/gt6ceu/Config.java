package com.gt6ceu;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue GENERATE_INFINITE_OIL_SOURCES;
    public static final ModConfigSpec.BooleanValue GENERATE_INFINITE_GAS_SOURCES;
    public static final ModConfigSpec.IntValue AMOUNT_OF_CUSTOM_BEDROCK_ORE_SLOTS;
    public static final ModConfigSpec.IntValue AMOUNT_OF_CUSTOM_SMALL_ORE_SLOTS;
    public static final ModConfigSpec.IntValue AMOUNT_OF_CUSTOM_LARGE_VEIN_SLOTS;
    public static final ModConfigSpec.BooleanValue ENABLE_CHUNK_WORLDGEN;
    public static final ModConfigSpec.BooleanValue ENABLE_PLACED_FEATURE_WORLDGEN;
    public static final ModConfigSpec.BooleanValue DISABLE_VANILLA_ORE_FEATURES;
    public static final ModConfigSpec.BooleanValue RANDOM_SMALL_GEM_ORE_EMERALD;
    public static final ModConfigSpec.BooleanValue RANDOM_SMALL_GEM_ORE_DIAMOND;
    public static final ModConfigSpec.BooleanValue RANDOM_SMALL_GEM_ORE_RUBY;
    public static final ModConfigSpec.BooleanValue RANDOM_SMALL_GEM_ORE_SAPPHIRE;

    static {
        BUILDER.push("general");
        GENERATE_INFINITE_OIL_SOURCES = BUILDER
                .comment("Generate infinite oil sources.")
                .define("GenerateInfiniteOilSources", true);
        GENERATE_INFINITE_GAS_SOURCES = BUILDER
                .comment("Generate infinite gas sources.")
                .define("GenerateInfiniteGasSources", true);
        AMOUNT_OF_CUSTOM_BEDROCK_ORE_SLOTS = BUILDER
                .comment("Number of custom bedrock ore slots.")
                .defineInRange("AmountOfCustomBedrockOreSlots", 0, 0, 1000);
        AMOUNT_OF_CUSTOM_SMALL_ORE_SLOTS = BUILDER
                .comment("Number of custom small ore slots.")
                .defineInRange("AmountOfCustomSmallOreSlots", 0, 0, 1000);
        AMOUNT_OF_CUSTOM_LARGE_VEIN_SLOTS = BUILDER
                .comment("Number of custom large vein slots.")
                .defineInRange("AmountOfCustomLargeVeinSlots", 0, 0, 1000);
        ENABLE_CHUNK_WORLDGEN = BUILDER
                .comment("Enable GT6 chunk-load worldgen passes.")
                .define("EnableChunkWorldgen", true);
        ENABLE_PLACED_FEATURE_WORLDGEN = BUILDER
                .comment("Enable GT6 placed-feature worldgen passes.")
                .define("EnablePlacedFeatureWorldgen", true);
        DISABLE_VANILLA_ORE_FEATURES = BUILDER
                .comment("Remove vanilla ore features so GT6 ore tables can replace them.")
                .define("DisableVanillaOreFeatures", true);
        BUILDER.pop();

        BUILDER.push("ore");
        BUILDER.push("random_small_gem_ores");
        RANDOM_SMALL_GEM_ORE_EMERALD = BUILDER
                .comment("Enable emerald small gem ore.")
                .define("emerald", true);
        RANDOM_SMALL_GEM_ORE_DIAMOND = BUILDER
                .comment("Enable diamond small gem ore.")
                .define("diamond", true);
        RANDOM_SMALL_GEM_ORE_RUBY = BUILDER
                .comment("Enable ruby small gem ore.")
                .define("ruby", true);
        RANDOM_SMALL_GEM_ORE_SAPPHIRE = BUILDER
                .comment("Enable sapphire small gem ore.")
                .define("sapphire", true);
        BUILDER.pop();
        BUILDER.pop();
    }

    static final ModConfigSpec SPEC = BUILDER.build();

    private Config() {
    }
}
