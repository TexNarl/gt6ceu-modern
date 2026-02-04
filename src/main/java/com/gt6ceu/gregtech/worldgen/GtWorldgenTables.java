/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/loaders/b/Loader_Worldgen.java
 * Purpose: Register GT6 ore table definitions for worldgen.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.worldgen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public final class GtWorldgenTables {
    private static final List<GtLargeOreVein> LARGE_ORES = new ArrayList<>();
    private static final List<GtSmallOreDeposit> SMALL_ORES = new ArrayList<>();
    private static boolean bootstrapped;

    private static final Set<GtWorldgenDimension> DIM_ALL = Collections.unmodifiableSet(EnumSet.allOf(GtWorldgenDimension.class));
    private static final Set<GtWorldgenDimension> DIM_OVERWORLD = Collections.unmodifiableSet(EnumSet.of(GtWorldgenDimension.OVERWORLD));
    private static final Set<GtWorldgenDimension> DIM_NETHER = Collections.unmodifiableSet(EnumSet.of(GtWorldgenDimension.NETHER));
    private static final Set<GtWorldgenDimension> DIM_END = Collections.unmodifiableSet(EnumSet.of(GtWorldgenDimension.END));
    private static final Set<GtWorldgenDimension> DIM_AETHER = Collections.unmodifiableSet(EnumSet.of(GtWorldgenDimension.AETHER));
    private static final Set<GtWorldgenDimension> DIM_ALFHEIM = Collections.unmodifiableSet(EnumSet.of(GtWorldgenDimension.ALFHEIM));
    private static final Set<GtWorldgenDimension> DIM_ATUM = Collections.unmodifiableSet(EnumSet.of(GtWorldgenDimension.ATUM));
    private static final Set<GtWorldgenDimension> DIM_ASTEROIDS = Collections.unmodifiableSet(EnumSet.of(GtWorldgenDimension.ASTEROIDS));
    private static final Set<GtWorldgenDimension> DIM_BETWEENLANDS = Collections.unmodifiableSet(EnumSet.of(GtWorldgenDimension.BETWEENLANDS));
    private static final Set<GtWorldgenDimension> DIM_EREBUS = Collections.unmodifiableSet(EnumSet.of(GtWorldgenDimension.EREBUS));
    private static final Set<GtWorldgenDimension> DIM_MARS = Collections.unmodifiableSet(EnumSet.of(GtWorldgenDimension.MARS));
    private static final Set<GtWorldgenDimension> DIM_MOON = Collections.unmodifiableSet(EnumSet.of(GtWorldgenDimension.MOON));
    private static final Set<GtWorldgenDimension> DIM_PLANETS = Collections.unmodifiableSet(EnumSet.of(GtWorldgenDimension.PLANETS));

    private static final Set<GtWorldgenDimension> ORE_OVERWORLD = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> ORE_A97 = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> ORE_ENVM = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> ORE_CW2_AquaCavern = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> ORE_CW2_Caveland = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> ORE_CW2_Cavenia = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> ORE_CW2_Cavern = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> ORE_CW2_Caveworld = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> ORE_EREBUS = DIM_EREBUS;
    private static final Set<GtWorldgenDimension> ORE_ATUM = DIM_ATUM;
    private static final Set<GtWorldgenDimension> ORE_BETWEENLANDS = DIM_BETWEENLANDS;
    private static final Set<GtWorldgenDimension> ORE_MARS = DIM_MARS;
    private static final Set<GtWorldgenDimension> ORE_PLANETS = DIM_PLANETS;
    private static final Set<GtWorldgenDimension> ORE_MOON = DIM_MOON;
    private static final Set<GtWorldgenDimension> ORE_ASTEROIDS = DIM_ASTEROIDS;
    private static final Set<GtWorldgenDimension> ORE_END = DIM_END;
    private static final Set<GtWorldgenDimension> ORE_ALL = DIM_ALL;

    private static final Set<GtWorldgenDimension> GEN_OVERWORLD = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_GT = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_PFAA = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_A97 = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_A97_GT = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_ENVM = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_ENVM_GT = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_CW2_AquaCavern = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_CW2_AquaCavern_GT = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_CW2_Caveland = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_CW2_Caveland_GT = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_CW2_Cavenia = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_CW2_Cavenia_GT = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_CW2_Cavern = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_CW2_Cavern_GT = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_CW2_Caveworld = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_CW2_Caveworld_GT = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_EREBUS = DIM_EREBUS;
    private static final Set<GtWorldgenDimension> GEN_BETWEENLANDS = DIM_BETWEENLANDS;
    private static final Set<GtWorldgenDimension> GEN_ATUM = DIM_ATUM;
    private static final Set<GtWorldgenDimension> GEN_ALFHEIM = DIM_ALFHEIM;
    private static final Set<GtWorldgenDimension> GEN_AETHER = DIM_AETHER;
    private static final Set<GtWorldgenDimension> GEN_NETHER = DIM_NETHER;
    private static final Set<GtWorldgenDimension> GEN_END = DIM_END;
    private static final Set<GtWorldgenDimension> GEN_MARS = DIM_MARS;
    private static final Set<GtWorldgenDimension> GEN_ASTEROIDS = DIM_ASTEROIDS;
    private static final Set<GtWorldgenDimension> GEN_MOON = DIM_MOON;
    private static final Set<GtWorldgenDimension> GEN_PLANETS = DIM_PLANETS;
    private static final Set<GtWorldgenDimension> GEN_GEMS = DIM_OVERWORLD;
    private static final Set<GtWorldgenDimension> GEN_ALL = DIM_ALL;

    private GtWorldgenTables() {
    }

    public static void bootstrap() {
        if (bootstrapped) {
            return;
        }
        bootstrapped = true;
        registerLargeOres();
        registerSmallOres();
        registerCustomSlots();
    }

    public static List<GtLargeOreVein> largeOres() {
        return LARGE_ORES;
    }

    public static List<GtSmallOreDeposit> smallOres() {
        return SMALL_ORES;
    }

    private static void registerLargeOres() {
addLarge("ore.large.lignite", true, true, 50, 130, 160, 8, 32, GtOreMaterial.LIGNITE , GtOreMaterial.LIGNITE , GtOreMaterial.LIGNITE , GtOreMaterial.COAL , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM));
addLarge("ore.large.coal", true, true, 50, 80, 80, 6, 32, GtOreMaterial.COAL , GtOreMaterial.COAL , GtOreMaterial.COAL , GtOreMaterial.LIGNITE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM));
addLarge("ore.large.apatite", true, true, 40, 60, 60, 3, 16, GtOreMaterial.APATITE , GtOreMaterial.APATITE , GtOreMaterial.PHOSPHORUS_BLUE , GtOreMaterial.PO4 , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS));
addLarge("ore.large.lapis", true, true, 20, 50, 40, 5, 16, GtOreMaterial.LAZURITE , GtOreMaterial.SODALITE , GtOreMaterial.LAPIS , GtOreMaterial.AZURITE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS));
addLarge("ore.large.bauxite", true, true, 50, 90, 80, 4, 24, GtOreMaterial.BAUXITE , GtOreMaterial.BAUXITE , GtOreMaterial.BAUXITE , GtOreMaterial.ILMENITE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS));
addLarge("ore.large.iodinesalt", true, true, 50, 60, 30, 3, 24, GtOreMaterial.KIO3 , GtOreMaterial.NA_CL , GtOreMaterial.BORAX , GtOreMaterial.ZEOLITE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS));
addLarge("ore.large.rocksalt", true, true, 50, 60, 30, 3, 24, GtOreMaterial.KCL , GtOreMaterial.COLTAN , GtOreMaterial.LEPIDOLITE , GtOreMaterial.SPODUMENE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS));
addLarge("ore.large.asbestos", true, true, 10, 40, 30, 3, 16, GtOreMaterial.CHROMITE , GtOreMaterial.TALC , GtOreMaterial.GYPSUM , GtOreMaterial.ASBESTOS , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS));
addLarge("ore.large.sapphire", true, true, 10, 40, 30, 3, 16, GtOreMaterial.BLUE_SAPPHIRE , GtOreMaterial.ORANGE_SAPPHIRE , GtOreMaterial.YELLOW_SAPPHIRE , GtOreMaterial.RUBY , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS));
addLarge("ore.large.sapphire2", true, true, 10, 40, 30, 3, 16, GtOreMaterial.GREEN_SAPPHIRE , GtOreMaterial.RUBY , GtOreMaterial.BLUE_SAPPHIRE , GtOreMaterial.PURPLE_SAPPHIRE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS));
addLarge("ore.large.garnet", true, true, 10, 40, 60, 3, 16, GtOreMaterial.ALMANDINE , GtOreMaterial.PYROPE , GtOreMaterial.ANDRADITE , GtOreMaterial.UVAROVITE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS));
addLarge("ore.large.pitchblende", true, true, 10, 40, 40, 3, 16, GtOreMaterial.PITCHBLENDE , GtOreMaterial.PITCHBLENDE , GtOreMaterial.URANINITE , GtOreMaterial.URANINITE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS, ORE_PLANETS));
addLarge("ore.large.monazite", true, true, 20, 40, 30, 3, 16, GtOreMaterial.BASTNASITE , GtOreMaterial.BASTNASITE , GtOreMaterial.MONAZITE , GtOreMaterial.ND , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS, ORE_PLANETS));
addLarge("ore.large.diamond", true, true, 5, 20, 40, 2, 16, GtOreMaterial.GRAPHITE , GtOreMaterial.GRAPHITE , GtOreMaterial.DIAMOND , GtOreMaterial.GRAPHITE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS, ORE_PLANETS));
addLarge("ore.large.galena", true, true, 30, 60, 40, 5, 16, GtOreMaterial.GALENA , GtOreMaterial.GALENA , GtOreMaterial.AG , GtOreMaterial.PB , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS, ORE_PLANETS));
addLarge("ore.large.quartz", true, true, 40, 80, 60, 3, 16, GtOreMaterial.MILKY_QUARTZ , GtOreMaterial.BARITE , GtOreMaterial.CERTUS_QUARTZ , GtOreMaterial.CERTUS_QUARTZ , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS, ORE_PLANETS, ORE_MOON, ORE_ASTEROIDS));
addLarge("ore.large.peridot", true, true, 10, 40, 60, 3, 16, GtOreMaterial.KYANITE , GtOreMaterial.MGCO3 , GtOreMaterial.PERIDOT , GtOreMaterial.GLAUCONITE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS, ORE_PLANETS, ORE_MOON));
addLarge("ore.large.gold", true, true, 20, 30, 5, 3, 16, GtOreMaterial.PYRITE , GtOreMaterial.CHALCOPYRITE , GtOreMaterial.ARSENOPYRITE , GtOreMaterial.AU , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS, ORE_PLANETS, ORE_ASTEROIDS));
addLarge("ore.large.platinum", true, true, 40, 50, 5, 3, 16, GtOreMaterial.COOPERITE , GtOreMaterial.PD , GtOreMaterial.SPERRYLITE , GtOreMaterial.IR , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS, ORE_PLANETS, ORE_END, ORE_ASTEROIDS));
addLarge("ore.large.molybdenum", true, true, 20, 50, 5, 3, 16, GtOreMaterial.WULFENITE , GtOreMaterial.MOLYBDENITE , GtOreMaterial.MO , GtOreMaterial.POWELLITE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS, ORE_PLANETS, ORE_END));
addLarge("ore.large.cassiterite", true, true, 40, 90, 170, 5, 24, GtOreMaterial.STANNITE , GtOreMaterial.KESTERITE , GtOreMaterial.HUEBNERITE , GtOreMaterial.CASSITERITE, merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS, ORE_PLANETS, ORE_END));
addLarge("ore.large.tungstate", true, true, 20, 50, 10, 3, 16, GtOreMaterial.SCHEELITE , GtOreMaterial.RUSSELLITE , GtOreMaterial.TUNGSTATE , GtOreMaterial.PINALITE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS, ORE_ASTEROIDS));
addLarge("ore.large.manganese", true, true, 20, 30, 20, 3, 16, GtOreMaterial.GROSSULAR , GtOreMaterial.SPESSARTINE , GtOreMaterial.MN_O2 , GtOreMaterial.COLTAN , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS));
addLarge("ore.large.beryllium", true, true, 5, 30, 15, 3, 16, GtOreMaterial.AQUAMARINE , GtOreMaterial.MAXIXE , GtOreMaterial.EMERALD , GtOreMaterial.TH , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS));
addLarge("ore.large.beryllium2", true, true, 5, 30, 15, 3, 16, GtOreMaterial.BIXBITE , GtOreMaterial.GOSHENITE , GtOreMaterial.HELIODOR , GtOreMaterial.MORGANITE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS));
addLarge("ore.large.titanium", true, true, 10, 40, 40, 3, 16, GtOreMaterial.TIO2 , GtOreMaterial.TIO2 , GtOreMaterial.ZIRCON , GtOreMaterial.ILMENITE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS));
addLarge("ore.large.nickel", true, true, 10, 40, 40, 3, 16, GtOreMaterial.GARNIERITE , GtOreMaterial.NI , GtOreMaterial.COBALTITE , GtOreMaterial.PENTLANDITE, merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS));
addLarge("ore.large.redstone", true, true, 10, 40, 60, 3, 24, GtOreMaterial.REDSTONE , GtOreMaterial.REDSTONE , GtOreMaterial.RUBY , GtOreMaterial.CINNABAR , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS, ORE_PLANETS));
addLarge("ore.large.tetrahedrite", true, true, 70, 120, 150, 4, 24, GtOreMaterial.TETRAHEDRITE , GtOreMaterial.TETRAHEDRITE , GtOreMaterial.CU , GtOreMaterial.STIBNITE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS, ORE_PLANETS));
addLarge("ore.large.iron", true, true, 10, 40, 120, 4, 24, GtOreMaterial.BROWN_LIMONITE , GtOreMaterial.YELLOW_LIMONITE , GtOreMaterial.FE2O3 , GtOreMaterial.MALACHITE , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS));
addLarge("ore.large.copper", true, true, 10, 30, 80, 4, 24, GtOreMaterial.CHALCOPYRITE , GtOreMaterial.FE2O3 , GtOreMaterial.PYRITE , GtOreMaterial.CU , merge(ORE_OVERWORLD, ORE_A97, ORE_ENVM, ORE_CW2_AquaCavern, ORE_CW2_Caveland, ORE_CW2_Cavenia, ORE_CW2_Cavern, ORE_CW2_Caveworld, ORE_EREBUS, ORE_ATUM, ORE_BETWEENLANDS, ORE_MARS));
addLarge("ore.large.adamantium", true, true, 10, 120, 5, 2, 16, GtOreMaterial.BROWN_LIMONITE , GtOreMaterial.YELLOW_LIMONITE , GtOreMaterial.FE2O3 , GtOreMaterial.ADAMANTINE , merge(ORE_MARS));
addLarge("ore.large.naquadah", true, true, 10, 60, 10, 4, 32, GtOreMaterial.NAQUADAH , GtOreMaterial.NAQUADAH , GtOreMaterial.NAQUADAH , GtOreMaterial.NAQUADAH , merge(ORE_MARS, ORE_PLANETS, ORE_ASTEROIDS, ORE_END));
addLarge("ore.large.trinium", true, true, 10, 90, 100, 1, 12, GtOreMaterial.TRINIUM , GtOreMaterial.TRINIUM , GtOreMaterial.TRINIUM , GtOreMaterial.TRINIUM , merge(ORE_MARS, ORE_PLANETS, ORE_ASTEROIDS, ORE_END));
addLarge("ore.large.dolamide", true, true, 5, 60, 40, 3, 16, GtOreMaterial.DURANIUM_HEXAIODIDE , GtOreMaterial.DURANIUM_HEXAFLUORIDE, GtOreMaterial.DURANIUM_HEXACHLORIDE, GtOreMaterial.DOLAMIDE , merge(ORE_MARS, ORE_PLANETS, ORE_ASTEROIDS));
addLarge("ore.large.moonmars", true, true, 10, 90, 240, 1, 8, GtOreMaterial.MGCO3 , GtOreMaterial.MN_O2 , GtOreMaterial.AL2O3 , GtOreMaterial.TIO2 , merge(ORE_MARS, ORE_PLANETS, ORE_MOON));
addLarge("ore.large.cheese", true, true, 10, 90, 100, 3, 16, GtOreMaterial.CHEESE , GtOreMaterial.CHEESE , GtOreMaterial.CHEESE , GtOreMaterial.SE , merge(ORE_MOON));
addLarge("ore.large.desh", true, true, 10, 90, 100, 3, 16, GtOreMaterial.TRITANIUM_HEXAFLUORIDE, GtOreMaterial.DURANIUM_HEXAASTATIDE, GtOreMaterial.DURANIUM_HEXABROMIDE , GtOreMaterial.DESH , merge(ORE_MARS));
addLarge("ore.large.syrmorite", true, true, 30, 45, 160, 2, 32, GtOreMaterial.SYRMORITE , GtOreMaterial.SYRMORITE , GtOreMaterial.SYRMORITE , GtOreMaterial.SYRMORITE , merge(ORE_BETWEENLANDS));
addLarge("ore.large.octine", true, true, 10, 25, 40, 1, 32, GtOreMaterial.OCTINE , GtOreMaterial.OCTINE , GtOreMaterial.OCTINE , GtOreMaterial.OCTINE , merge(ORE_BETWEENLANDS));
    }

    private static void registerSmallOres() {
addSmall("ore.small.copper", true, 60, 120, 16, GtOreMaterial.CU , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_END, GEN_MARS, GEN_ASTEROIDS, GEN_MOON, GEN_PLANETS));
addSmall("ore.small.chalcopyrite", true, 60, 120, 16, GtOreMaterial.CHALCOPYRITE, merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_END, GEN_MARS));
addSmall("ore.small.malachite", true, 40, 70, 8, GtOreMaterial.MALACHITE , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_END, GEN_MARS));
addSmall("ore.small.tin", true, 60, 120, 16, GtOreMaterial.SN , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_END, GEN_MARS, GEN_ASTEROIDS, GEN_MOON, GEN_PLANETS));
addSmall("ore.small.cassiterite", true, 60, 120, 16, GtOreMaterial.CASSITERITE , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_NETHER, GEN_END, GEN_MARS));
addSmall("ore.small.zinc", true, 40, 70, 4, GtOreMaterial.ZN , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_END, GEN_MARS, GEN_ASTEROIDS, GEN_MOON, GEN_PLANETS));
addSmall("ore.small.sphalerite", true, 30, 60, 12, GtOreMaterial.SPHALERITE , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_END, GEN_MARS));
addSmall("ore.small.smithsonite", true, 30, 60, 2, GtOreMaterial.SMITHSONITE , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_END, GEN_MARS));
addSmall("ore.small.stibnite", true, 20, 40, 2, GtOreMaterial.STIBNITE , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_END, GEN_MARS));
addSmall("ore.small.bismuth", true, 80, 120, 8, GtOreMaterial.BI , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_NETHER, GEN_MARS, GEN_ASTEROIDS, GEN_MOON, GEN_PLANETS));
addSmall("ore.small.lead", true, 40, 80, 16, GtOreMaterial.PB , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_END, GEN_MARS, GEN_ASTEROIDS, GEN_MOON, GEN_PLANETS));
addSmall("ore.small.galena", true, 40, 80, 16, GtOreMaterial.GALENA , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_END, GEN_MARS));
addSmall("ore.small.silver", true, 20, 40, 4, GtOreMaterial.AG , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_END, GEN_MARS, GEN_ASTEROIDS, GEN_MOON, GEN_PLANETS));
addSmall("ore.small.gold", true, 20, 40, 4, GtOreMaterial.AU , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_NETHER, GEN_END, GEN_MARS, GEN_ASTEROIDS, GEN_MOON, GEN_PLANETS));
addSmall("ore.small.pyrite", true, 20, 40, 4, GtOreMaterial.PYRITE , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_END, GEN_MARS, GEN_ASTEROIDS, GEN_MOON, GEN_PLANETS));
addSmall("ore.small.hematite", true, 40, 80, 24, GtOreMaterial.FE2O3 , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_END, GEN_MARS));
addSmall("ore.small.pyrolusite", true, 20, 40, 4, GtOreMaterial.MN_O2 , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_END, GEN_MARS, GEN_MOON, GEN_PLANETS));
addSmall("ore.small.garnierite", true, 20, 40, 4, GtOreMaterial.GARNIERITE , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_END, GEN_MARS));
addSmall("ore.small.pentlandite", true, 20, 40, 4, GtOreMaterial.PENTLANDITE , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_END, GEN_MARS));
addSmall("ore.small.scheelite", true, 5, 50, 1, GtOreMaterial.SCHEELITE , merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_NETHER, GEN_END, GEN_MARS, GEN_ASTEROIDS, GEN_MOON, GEN_PLANETS));
addSmall("ore.small.salt", true, 40, 80, 6, GtOreMaterial.NA_CL , merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_NETHER, GEN_END, GEN_MARS));
addSmall("ore.small.rocksalt", true, 40, 80, 6, GtOreMaterial.KCL , merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_NETHER, GEN_END, GEN_MARS));
addSmall("ore.small.borax", true, 10, 40, 4, GtOreMaterial.BORAX , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_NETHER, GEN_END, GEN_MARS));
addSmall("ore.small.asbestos", true, 20, 40, 8, GtOreMaterial.ASBESTOS , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_NETHER));
addSmall("ore.small.diamond", true, 5, 10, 2, GtOreMaterial.DIAMOND , merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_AETHER, GEN_NETHER, GEN_MARS, GEN_ASTEROIDS, GEN_MOON, GEN_PLANETS));
addSmall("ore.small.amber", true, 5, 70, 1, GtOreMaterial.AMBER , merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_AETHER));
addSmall("ore.small.craponite", true, 5, 250, 2, GtOreMaterial.CRAPONITE , merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_NETHER, GEN_END, GEN_MARS, GEN_ASTEROIDS, GEN_MOON, GEN_PLANETS));
addSmall("ore.small.redstone", true, 5, 20, 16, GtOreMaterial.REDSTONE , merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_NETHER, GEN_MARS, GEN_PLANETS));
addSmall("ore.small.lapis", true, 20, 40, 8, GtOreMaterial.LAPIS , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER));
addSmall("ore.small.eudialyte", true, 20, 40, 4, GtOreMaterial.EUDIALYTE , merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT));
addSmall("ore.small.azurite", true, 20, 40, 4, GtOreMaterial.AZURITE , merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT));
addSmall("ore.small.coal", true, 40, 100, 36, GtOreMaterial.COAL , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM));
addSmall("ore.small.graphite", true, 5, 10, 2, GtOreMaterial.GRAPHITE , merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_AETHER, GEN_NETHER, GEN_MARS, GEN_ASTEROIDS, GEN_PLANETS));
addSmall("ore.small.pollucite", true, 1, 250, 1, GtOreMaterial.POLLUCITE , merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_NETHER));
addSmall("ore.small.zeolite", true, 1, 250, 1, GtOreMaterial.ZEOLITE , merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_ALFHEIM, GEN_NETHER));
addSmall("ore.small.coltan", true, 1, 250, 4, GtOreMaterial.COLTAN , merge(GEN_END, GEN_ASTEROIDS, GEN_ALFHEIM, GEN_AETHER, GEN_NETHER, GEN_EREBUS, GEN_BETWEENLANDS));
addSmall("ore.small.platinum", true, 20, 40, 6, GtOreMaterial.PT , merge(GEN_END, GEN_ASTEROIDS, GEN_ALFHEIM, GEN_AETHER));
addSmall("ore.small.iridium", true, 20, 40, 6, GtOreMaterial.IR , merge(GEN_END, GEN_ASTEROIDS, GEN_ALFHEIM, GEN_AETHER));
addSmall("ore.small.sperrylite", true, 20, 40, 4, GtOreMaterial.SPERRYLITE , merge(GEN_END, GEN_ASTEROIDS, GEN_ALFHEIM, GEN_AETHER));
addSmall("ore.small.cooperite", true, 20, 40, 4, GtOreMaterial.COOPERITE , merge(GEN_END, GEN_ASTEROIDS));
addSmall("ore.small.naquadah", true, 10, 80, 6, GtOreMaterial.NAQUADAH , merge(GEN_END, GEN_ASTEROIDS, GEN_MARS, GEN_PLANETS));
addSmall("ore.small.trinium", true, 10, 80, 12, GtOreMaterial.TRINIUM , merge(GEN_END, GEN_ASTEROIDS, GEN_MARS, GEN_PLANETS));
addSmall("ore.small.dolamide", true, 5, 250, 8, GtOreMaterial.DOLAMIDE , merge(GEN_ASTEROIDS, GEN_MARS, GEN_PLANETS));
addSmall("ore.small.endium", true, 10, 80, 32, GtOreMaterial.ENDIUM , merge(GEN_END));
addSmall("ore.small.sugilite", true, 10, 80, 16, GtOreMaterial.SUGILITE , merge(GEN_END));
addSmall("ore.small.ambrosium", true, 30, 120, 64, GtOreMaterial.AMBROSIUM , merge(GEN_AETHER));
addSmall("ore.small.zanite", true, 30, 120, 16, GtOreMaterial.ZANITE , merge(GEN_AETHER));
addSmall("ore.small.sulfur", true, 5, 15, 8, GtOreMaterial.S , merge(GEN_OVERWORLD, GEN_GT, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_MARS));
addSmall("ore.small.niter", true, 10, 120, 32, GtOreMaterial.NITER , merge(GEN_NETHER));
addSmall("ore.small.efrine", true, 90, 120, 8, GtOreMaterial.EFRINE , merge(GEN_NETHER));
addSmall("ore.small.cinnabar", true, 5, 250, 16, GtOreMaterial.CINNABAR , merge(GEN_NETHER));
addSmall("ore.small.nikolite", true, 10, 40, 4, GtOreMaterial.NIKOLITE , merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_AETHER, GEN_MARS, GEN_PLANETS, GEN_ALFHEIM, GEN_NETHER, GEN_END));
addSmall("ore.small.aer", false, 10, 60, 8, GtOreMaterial.INFUSED_AIR, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_AETHER, GEN_MARS, GEN_PLANETS, GEN_ALFHEIM, GEN_NETHER, GEN_END));
addSmall("ore.small.ancientdebris", false, 5, 90, 16, GtOreMaterial.ANCIENT_DEBRIS, merge(GEN_NETHER, GEN_MARS));
addSmall("ore.small.aqua", false, 10, 60, 8, GtOreMaterial.INFUSED_WATER, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_AETHER, GEN_MARS, GEN_PLANETS, GEN_ALFHEIM, GEN_NETHER, GEN_END));
addSmall("ore.small.bischofite", false, 40, 80, 1, GtOreMaterial.BISCHOFITE, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM));
addSmall("ore.small.blackquartz", false, 20, 40, 1, GtOreMaterial.BLACK_QUARTZ, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM));
addSmall("ore.small.certus", false, 20, 40, 1, GtOreMaterial.CERTUS_QUARTZ, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_AETHER, GEN_MARS, GEN_PLANETS, GEN_ALFHEIM, GEN_ASTEROIDS, GEN_MOON));
addSmall("ore.small.chimerite", false, 10, 40, 8, GtOreMaterial.CHIMERITE, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_AETHER, GEN_MARS, GEN_PLANETS, GEN_ALFHEIM));
addSmall("ore.small.datolite", false, 40, 80, 1, GtOreMaterial.DATOLITE, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM));
addSmall("ore.small.gypsum", false, 40, 80, 1, GtOreMaterial.GYPSUM, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM));
addSmall("ore.small.hexorium_black", false, 0, 20, 6, GtOreMaterial.HEXORIUM_BLACK, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM));
addSmall("ore.small.hexorium_blue", false, 0, 60, 30, GtOreMaterial.HEXORIUM_BLUE, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM));
addSmall("ore.small.hexorium_green", false, 0, 60, 30, GtOreMaterial.HEXORIUM_GREEN, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM));
addSmall("ore.small.hexorium_red", false, 0, 60, 30, GtOreMaterial.HEXORIUM_RED, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM));
addSmall("ore.small.hexorium_white", false, 0, 20, 6, GtOreMaterial.HEXORIUM_WHITE, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM));
addSmall("ore.small.ignis", false, 10, 60, 8, GtOreMaterial.INFUSED_FIRE, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_AETHER, GEN_MARS, GEN_PLANETS, GEN_ALFHEIM, GEN_NETHER, GEN_END));
addSmall("ore.small.mica", false, 40, 80, 1, GtOreMaterial.MICA, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM));
addSmall("ore.small.ordo", false, 10, 60, 8, GtOreMaterial.INFUSED_ORDER, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_AETHER, GEN_MARS, GEN_PLANETS, GEN_ALFHEIM, GEN_NETHER, GEN_END));
addSmall("ore.small.perdito", false, 10, 60, 8, GtOreMaterial.INFUSED_ENTROPY, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_AETHER, GEN_MARS, GEN_PLANETS, GEN_ALFHEIM, GEN_NETHER, GEN_END));
addSmall("ore.small.potassiumfeldspar", false, 40, 80, 1, GtOreMaterial.POTASSIUM_FELDSPAR, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM));
addSmall("ore.small.terra", false, 10, 60, 8, GtOreMaterial.INFUSED_EARTH, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_AETHER, GEN_MARS, GEN_PLANETS, GEN_ALFHEIM, GEN_NETHER, GEN_END));
addSmall("ore.small.trona", false, 40, 80, 1, GtOreMaterial.TRONA, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM));
addSmall("ore.small.vinteum", false, 30, 60, 8, GtOreMaterial.VINTEUM, merge(GEN_OVERWORLD, GEN_GT, GEN_PFAA, GEN_A97, GEN_A97_GT, GEN_ENVM, GEN_ENVM_GT, GEN_CW2_AquaCavern, GEN_CW2_AquaCavern_GT, GEN_CW2_Caveland, GEN_CW2_Caveland_GT, GEN_CW2_Cavenia, GEN_CW2_Cavenia_GT, GEN_CW2_Cavern, GEN_CW2_Cavern_GT, GEN_CW2_Caveworld, GEN_CW2_Caveworld_GT, GEN_EREBUS, GEN_BETWEENLANDS, GEN_ATUM, GEN_AETHER, GEN_MARS, GEN_PLANETS, GEN_ALFHEIM));
    }

    private static void registerCustomSlots() {
        int customSmall = GtWorldgenConfig.customSmallOreSlots();
        for (int i = 0; i < customSmall; i++) {
            addSmall("ore.small.custom" + (i < 10 ? "0" : "") + i, false, 0, 0, 0, GtOreMaterial.EMPTY, DIM_ALL);
        }
        int customLarge = GtWorldgenConfig.customLargeVeinSlots();
        for (int i = 0; i < customLarge; i++) {
            addLarge("ore.large.custom" + (i < 10 ? "0" : "") + i, false, true, 0, 0, 0, 0, 0,
                    GtOreMaterial.EMPTY, GtOreMaterial.EMPTY, GtOreMaterial.EMPTY, GtOreMaterial.EMPTY, DIM_ALL);
        }
    }

    private static void addLarge(String id, boolean enabled, boolean indicatorRocks, int minY, int maxY, int weight,
                                 int density, int size, GtOreMaterial top, GtOreMaterial bottom, GtOreMaterial between,
                                 GtOreMaterial spread, Set<GtWorldgenDimension> dimensions) {
        LARGE_ORES.add(new GtLargeOreVein(id, enabled, indicatorRocks, minY, maxY, weight, density, size,
                top, bottom, between, spread, dimensions));
    }

    private static void addSmall(String id, boolean enabled, int minY, int maxY, int amount, GtOreMaterial material,
                                 Set<GtWorldgenDimension> dimensions) {
        SMALL_ORES.add(new GtSmallOreDeposit(id, enabled, minY, maxY, amount, material, dimensions));
    }

    @SafeVarargs
    private static Set<GtWorldgenDimension> merge(Set<GtWorldgenDimension>... sets) {
        EnumSet<GtWorldgenDimension> result = EnumSet.noneOf(GtWorldgenDimension.class);
        for (Set<GtWorldgenDimension> set : sets) {
            result.addAll(set);
        }
        return Collections.unmodifiableSet(result);
    }
}
