/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/loaders/b/Loader_Worldgen.java
 * Purpose: Seed GT6 stone layers and ore mappings for worldgen.
 * Status: PORTED
 * Notes: Initial port focuses on GT stone layers and ore generation tables.
 */
package com.gt6ceu.gregtech.worldgen;

public final class GtWorldgenBootstrap {
    private GtWorldgenBootstrap() {
    }

    public static void bootstrap() {
        if (!GtStoneLayer.LAYERS.isEmpty()) {
            return;
        }

        GtStoneLayer.DEEPSLATE = GtStoneLayer.createDefaultStoneLayer(GtStoneType.DEEPSLATE, GtOreMaterial.DEEPSLATE);

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.KOMATIITE, GtOreMaterial.KOMATIITE,
                new GtStoneLayerOre(GtOreMaterial.MGCO3, U16(), 20, 50),
                new GtStoneLayerOre(GtOreMaterial.CINNABAR, U12(), 0, 32),
                new GtStoneLayerOre(GtOreMaterial.REDSTONE, U8(), 0, 30),
                new GtStoneLayerOre(GtOreMaterial.PYRITE, U12(), 0, 30)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.KIMBERLITE, GtOreMaterial.KIMBERLITE,
                new GtStoneLayerOre(GtOreMaterial.DIAMOND, U48(), 0, 12),
                new GtStoneLayerOre(GtOreMaterial.SPINEL, U48(), 24, 48),
                new GtStoneLayerOre(GtOreMaterial.BALAS_RUBY, U48(), 24, 48)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.BASALT, GtOreMaterial.BASALT,
                new GtStoneLayerOre(GtOreMaterial.BASTNASITE, U24(), 24, 32),
                new GtStoneLayerOre(GtOreMaterial.MONAZITE, U32(), 24, 32),
                new GtStoneLayerOre(GtOreMaterial.MN_O2, U8(), 16, 48)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.BASALT, GtOreMaterial.BASALT,
                new GtStoneLayerOre(GtOreMaterial.PERIDOT, U32(), 0, 32),
                new GtStoneLayerOre(GtOreMaterial.UVAROVITE, U32(), 8, 40),
                new GtStoneLayerOre(GtOreMaterial.GROSSULAR, U32(), 16, 48),
                new GtStoneLayerOre(GtOreMaterial.CHROMITE, U8(), 32, 64)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.ANDESITE, GtOreMaterial.ANDESITE,
                new GtStoneLayerOre(GtOreMaterial.BROMARGYRITE, U8(), 0, 32)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.ANDESITE, GtOreMaterial.ANDESITE,
                new GtStoneLayerOre(GtOreMaterial.AU, U12(), 0, 32),
                new GtStoneLayerOre(GtOreMaterial.AU, U8(), 33, 64)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.MARBLE, GtOreMaterial.MARBLE,
                new GtStoneLayerOre(GtOreMaterial.CASSITERITE, U16(), 20, 80),
                new GtStoneLayerOre(GtOreMaterial.DIOPTASE, U64(), 24, 48)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.MARBLE, GtOreMaterial.MARBLE,
                new GtStoneLayerOre(GtOreMaterial.CASSITERITE, U16(), 20, 80),
                new GtStoneLayerOre(GtOreMaterial.STANNITE, U16(), 38, 82),
                new GtStoneLayerOre(GtOreMaterial.KESTERITE, U16(), 38, 82),
                new GtStoneLayerOre(GtOreMaterial.SPHALERITE, U8(), 10, 30),
                new GtStoneLayerOre(GtOreMaterial.CHALCOPYRITE, U8(), 0, 20),
                new GtStoneLayerOre(GtOreMaterial.PYRITE, U12(), 0, 30)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.LIMESTONE, GtOreMaterial.LIMESTONE,
                new GtStoneLayerOre(GtOreMaterial.BONE, U8(), 30, 60)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.LIMESTONE, GtOreMaterial.LIMESTONE,
                new GtStoneLayerOre(GtOreMaterial.STIBNITE, U24(), 10, 30),
                new GtStoneLayerOre(GtOreMaterial.GALENA, U8(), 30, 120),
                new GtStoneLayerOre(GtOreMaterial.PB, U16(), 50, 70)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.LIMESTONE, GtOreMaterial.LIMESTONE,
                new GtStoneLayerOre(GtOreMaterial.PYRITE, U16(), 0, 30),
                new GtStoneLayerOre(GtOreMaterial.ARSENOPYRITE, U16(), 0, 20),
                new GtStoneLayerOre(GtOreMaterial.GALENA, U8(), 5, 25),
                new GtStoneLayerOre(GtOreMaterial.GALENA, U8(), 80, 120),
                new GtStoneLayerOre(GtOreMaterial.WULFENITE, U32(), 30, 45),
                new GtStoneLayerOre(GtOreMaterial.POWELLITE, U32(), 35, 50),
                new GtStoneLayerOre(GtOreMaterial.MOLYBDENITE, U128(), 30, 50),
                new GtStoneLayerOre(GtOreMaterial.TETRAHEDRITE, U8(), 40, 80),
                new GtStoneLayerOre(GtOreMaterial.CU, U16(), 40, 80)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.LIMESTONE, GtOreMaterial.LIMESTONE,
                new GtStoneLayerOre(GtOreMaterial.SCHEELITE, U64(), 0, 16),
                new GtStoneLayerOre(GtOreMaterial.WOLFRAMITE, U64(), 0, 16),
                new GtStoneLayerOre(GtOreMaterial.FERBERITE, U64(), 0, 16),
                new GtStoneLayerOre(GtOreMaterial.HUEBNERITE, U64(), 0, 16),
                new GtStoneLayerOre(GtOreMaterial.TUNGSTATE, U64(), 0, 16),
                new GtStoneLayerOre(GtOreMaterial.YELLOW_LIMONITE, U8(), 16, 48),
                new GtStoneLayerOre(GtOreMaterial.BROWN_LIMONITE, U8(), 32, 64),
                new GtStoneLayerOre(GtOreMaterial.MALACHITE, U12(), 16, 64),
                new GtStoneLayerOre(GtOreMaterial.AZURITE, U24(), 16, 64)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.GRANITE_BLACK, GtOreMaterial.GRANITE_BLACK,
                new GtStoneLayerOre(GtOreMaterial.COOPERITE, U32(), 0, 16),
                new GtStoneLayerOre(GtOreMaterial.SPERRYLITE, U32(), 0, 16),
                new GtStoneLayerOre(GtOreMaterial.IR, U64(), 0, 8),
                new GtStoneLayerOre(GtOreMaterial.EMERALD, U64(), 24, 48),
                new GtStoneLayerOre(GtOreMaterial.AQUAMARINE, U64(), 8, 32),
                new GtStoneLayerOre(GtOreMaterial.MORGANITE, U64(), 24, 48),
                new GtStoneLayerOre(GtOreMaterial.HELIODOR, U64(), 24, 48),
                new GtStoneLayerOre(GtOreMaterial.GOSHENITE, U64(), 24, 48),
                new GtStoneLayerOre(GtOreMaterial.BIXBITE, U64(), 24, 48),
                new GtStoneLayerOre(GtOreMaterial.MAXIXE, U64(), 24, 48)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.GRANITE_RED, GtOreMaterial.GRANITE_RED,
                new GtStoneLayerOre(GtOreMaterial.PITCHBLENDE, U32(), 0, 18),
                new GtStoneLayerOre(GtOreMaterial.URANINITE, U32(), 0, 16),
                new GtStoneLayerOre(GtOreMaterial.TANTALITE, U64(), 30, 40),
                new GtStoneLayerOre(GtOreMaterial.COLUMBITE, U64(), 30, 40),
                new GtStoneLayerOre(GtOreMaterial.COLTAN, U16(), 20, 50)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.GRANITE, GtOreMaterial.S,
                new GtStoneLayerOre(GtOreMaterial.S, U16(), 0, 16)).setNoDeep());

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.GRANITE, GtOreMaterial.KNO3,
                new GtStoneLayerOre(GtOreMaterial.KNO3, U16(), 0, 16)).setNoDeep());

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.GRANITE, GtOreMaterial.LIGNITE,
                new GtStoneLayerOre(GtOreMaterial.LIGNITE, U16(), 0, 16)).setNoDeep());

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.GRANITE, GtOreMaterial.GRANITE,
                new GtStoneLayerOre(GtOreMaterial.BLUE_TOPAZ, U64(), 8, 32),
                new GtStoneLayerOre(GtOreMaterial.TOPAZ, U64(), 24, 48)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.GRANITE, GtOreMaterial.GRANITE,
                new GtStoneLayerOre(GtOreMaterial.APATITE, U8(), 32, 64),
                new GtStoneLayerOre(GtOreMaterial.PO4, U24(), 36, 60),
                new GtStoneLayerOre(GtOreMaterial.PHOSPHORITE, U24(), 40, 56),
                new GtStoneLayerOre(GtOreMaterial.PHOSPHORUS_RED, U24(), 44, 52)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.DIORITE, GtOreMaterial.DIORITE,
                new GtStoneLayerOre(GtOreMaterial.SAPPHIRE, U64(), 24, 48),
                new GtStoneLayerOre(GtOreMaterial.GREEN_SAPPHIRE, U64(), 24, 48),
                new GtStoneLayerOre(GtOreMaterial.YELLOW_SAPPHIRE, U64(), 24, 48),
                new GtStoneLayerOre(GtOreMaterial.ORANGE_SAPPHIRE, U64(), 24, 48),
                new GtStoneLayerOre(GtOreMaterial.BLUE_SAPPHIRE, U64(), 8, 32),
                new GtStoneLayerOre(GtOreMaterial.PURPLE_SAPPHIRE, U64(), 24, 48),
                new GtStoneLayerOre(GtOreMaterial.RUBY, U64(), 24, 48)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.DIORITE, GtOreMaterial.DIORITE,
                new GtStoneLayerOre(GtOreMaterial.GARNIERITE, U8(), 16, 48),
                new GtStoneLayerOre(GtOreMaterial.PENTLANDITE, U8(), 24, 56),
                new GtStoneLayerOre(GtOreMaterial.COBALTITE, U8(), 32, 64),
                new GtStoneLayerOre(GtOreMaterial.CRAPONITE, U64(), 24, 48),
                new GtStoneLayerOre(GtOreMaterial.AMETHYST, U64(), 24, 48),
                new GtStoneLayerOre(GtOreMaterial.ALEXANDRITE, U64(), 24, 48)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.SCHIST_GREEN, GtOreMaterial.SCHIST_GREEN,
                new GtStoneLayerOre(GtOreMaterial.ANDRADITE, U32(), 8, 40),
                new GtStoneLayerOre(GtOreMaterial.ALMANDINE, U32(), 16, 48)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.SCHIST_BLUE, GtOreMaterial.SCHIST_BLUE,
                new GtStoneLayerOre(GtOreMaterial.SPESSARTINE, U32(), 8, 40),
                new GtStoneLayerOre(GtOreMaterial.PYROPE, U32(), 16, 48)));

        GtStoneLayer.LAYERS.add(GtStoneLayer.createDefaultStoneLayer(GtStoneType.QUARTZITE, GtOreMaterial.QUARTZITE,
                new GtStoneLayerOre(GtOreMaterial.CERTUS_QUARTZ, U16(), 16, 48),
                new GtStoneLayerOre(GtOreMaterial.BARITE, U32(), 0, 32)));

        GtStoneLayer.bothSides(GtOreMaterial.COAL, GtOreMaterial.STONE,
                new GtStoneLayerOre(GtOreMaterial.AMBER, U4(), 30, 70),
                new GtStoneLayerOre(GtOreMaterial.AMBER, U8(), 30, 70),
                new GtStoneLayerOre(GtOreMaterial.AMBER_DOMINICAN, U8(), 30, 70));

        GtStoneLayer.bothSides(GtOreMaterial.LIGNITE, GtOreMaterial.STONE,
                new GtStoneLayerOre(GtOreMaterial.AMBER, U4(), 30, 70),
                new GtStoneLayerOre(GtOreMaterial.AMBER, U8(), 30, 70),
                new GtStoneLayerOre(GtOreMaterial.AMBER_DOMINICAN, U8(), 30, 70));

        GtStoneLayer.bothSides(GtOreMaterial.OILSHALE, GtOreMaterial.STONE,
                new GtStoneLayerOre(GtOreMaterial.AMBER, U4(), 30, 70),
                new GtStoneLayerOre(GtOreMaterial.AMBER, U8(), 30, 70),
                new GtStoneLayerOre(GtOreMaterial.AMBER_DOMINICAN, U8(), 30, 70));

        GtStoneLayer.bothSides(GtOreMaterial.KOMATIITE, GtOreMaterial.BASALT,
                new GtStoneLayerOre(GtOreMaterial.PERLITE, U4(), 0, 16));

        GtStoneLayer.bothSides(GtOreMaterial.GABBRO, GtOreMaterial.BASALT,
                new GtStoneLayerOre(GtOreMaterial.PERLITE, U4(), 0, 16));

        GtStoneLayer.bothSides(GtOreMaterial.LIMESTONE, GtOreMaterial.BASALT,
                new GtStoneLayerOre(GtOreMaterial.ILMENITE, U8(), 0, 32),
                new GtStoneLayerOre(GtOreMaterial.TIO2, U12(), 0, 32));

        GtStoneLayer.topBottom(GtOreMaterial.DOLOMITE, GtOreMaterial.DIORITE,
                new GtStoneLayerOre(GtOreMaterial.OPAL, U64(), 48, 64),
                new GtStoneLayerOre(GtOreMaterial.DIATOMITE, U16(), 16, 64));

        GtStoneLayer.bothSides(GtOreMaterial.DOLOMITE, GtOreMaterial.KCL,
                new GtStoneLayerOre(GtOreMaterial.KIO3, U12(), 32, 64));

        GtStoneLayer.bothSides(GtOreMaterial.DOLOMITE, GtOreMaterial.QUARTZITE,
                new GtStoneLayerOre(GtOreMaterial.KYANITE, U16(), 32, 72),
                new GtStoneLayerOre(GtOreMaterial.LEPIDOLITE, U32(), 16, 48),
                new GtStoneLayerOre(GtOreMaterial.SPODUMENE, U32(), 32, 64),
                new GtStoneLayerOre(GtOreMaterial.TANTALITE, U128(), 16, 48),
                new GtStoneLayerOre(GtOreMaterial.COLUMBITE, U128(), 16, 48),
                new GtStoneLayerOre(GtOreMaterial.COLTAN, U32(), 8, 56));

        if (GtWorldgenConfig.randomSmallGemEnabled(GtOreMaterial.EMERALD)) {
            GtStoneLayer.RANDOM_SMALL_GEM_ORES.add(GtOreMaterial.EMERALD);
        }
        if (GtWorldgenConfig.randomSmallGemEnabled(GtOreMaterial.DIAMOND)) {
            GtStoneLayer.RANDOM_SMALL_GEM_ORES.add(GtOreMaterial.DIAMOND);
        }
        if (GtWorldgenConfig.randomSmallGemEnabled(GtOreMaterial.RUBY)) {
            GtStoneLayer.RANDOM_SMALL_GEM_ORES.add(GtOreMaterial.RUBY);
        }
        if (GtWorldgenConfig.randomSmallGemEnabled(GtOreMaterial.SAPPHIRE)) {
            GtStoneLayer.RANDOM_SMALL_GEM_ORES.add(GtOreMaterial.SAPPHIRE);
        }

        GtWorldgenTables.bootstrap();
    }

    private static long U4() {
        return 648_648_000L / 4;
    }

    private static long U8() {
        return 648_648_000L / 8;
    }

    private static long U12() {
        return 648_648_000L / 12;
    }

    private static long U16() {
        return 648_648_000L / 16;
    }

    private static long U24() {
        return 648_648_000L / 24;
    }

    private static long U32() {
        return 648_648_000L / 32;
    }

    private static long U48() {
        return 648_648_000L / 48;
    }

    private static long U64() {
        return 648_648_000L / 64;
    }

    private static long U128() {
        return 648_648_000L / 128;
    }
}
