/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/loaders/b/Loader_Worldgen.java
 * Purpose: Register GT6 worldgen passes for chunk load execution.
 * Status: PORTED
 * Notes: Focused on non-dungeon overworld/nether generators.
 */
package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.registry.GTBlocks;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;

public final class GtWorldgenRegistry {
    private static final Predicate<Biome> ANY_BIOME = biome -> true;
    private static final List<GtChunkWorldgen> OVERWORLD = List.of(
            new GtWorldgenOcean("ocean.seawater"),
            new GtWorldgenRiver("river.riverwater"),
            new GtWorldgenSwamp("swamp.dirtywater"),
            new GtWorldgenDeepOcean("ocean.prismacorals"),
            new GtWorldgenBlackSand("river.magnetite"),
            new GtWorldgenTurf("swamp.turf"),
            new GtWorldgenPit("pit.clay.vanilla", Blocks.CLAY, 0, 1, 8),
            new GtWorldgenPit("pit.clay.brown", GTBlocks.DIGGABLES.get(), 1, 1, 8),
            new GtWorldgenPit("pit.clay.turf", GTBlocks.DIGGABLES.get(), 2, 1, 8),
            new GtWorldgenPit("pit.clay.red", GTBlocks.DIGGABLES.get(), 3, 1, 8),
            new GtWorldgenPit("pit.clay.yellow", GTBlocks.DIGGABLES.get(), 4, 1, 8),
            new GtWorldgenPit("pit.clay.blue", GTBlocks.DIGGABLES.get(), 5, 1, 8),
            new GtWorldgenPit("pit.clay.white", GTBlocks.DIGGABLES.get(), 6, 1, 8),
            new GtWorldgenPit("pit.clay.lateric", GTBlocks.DIGGABLES.get(), 7, 1, 8),
            new GtWorldgenPit("pit.clay.bentonite", GTBlocks.DIGGABLES.get(), 8, 1, 8),
            new GtWorldgenPit("pit.clay.fullers", GTBlocks.DIGGABLES.get(), 9, 1, 8),
            new GtWorldgenPit("pit.clay.kaolinite", GTBlocks.DIGGABLES.get(), 10, 1, 8),
            new GtWorldgenLogs("log.dry", Blocks.OAK_LOG, 1, 8, Level.OVERWORLD, GtWorldgenLogs.defaultOverworldBiomes()),
            new GtWorldgenLogs("log.rotten", Blocks.STRIPPED_OAK_LOG, 1, 3, Level.OVERWORLD, GtWorldgenLogs.defaultOverworldBiomes()),
            new GtWorldgenLogs("log.mossy", Blocks.SPRUCE_LOG, 1, 8, Level.OVERWORLD, GtWorldgenLogs.defaultOverworldBiomes()),
            new GtWorldgenLogs("log.frozen", Blocks.BIRCH_LOG, 1, 8, Level.OVERWORLD, GtWorldgenLogs.defaultOverworldBiomes()),
            new GtWorldgenTrees("tree.rubber", Blocks.OAK_LOG, Blocks.OAK_LEAVES, 1, 5, Level.OVERWORLD, GtWorldgenTrees.defaultOverworldBiomes()),
            new GtWorldgenTrees("tree.maple", Blocks.SPRUCE_LOG, Blocks.SPRUCE_LEAVES, 1, 5, Level.OVERWORLD, GtWorldgenTrees.defaultOverworldBiomes()),
            new GtWorldgenTrees("tree.willow", Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 1, 4, Level.OVERWORLD, GtWorldgenTrees.defaultOverworldBiomes()),
            new GtWorldgenTrees("tree.bluemahoe", Blocks.JUNGLE_LOG, Blocks.JUNGLE_LEAVES, 1, 3, Level.OVERWORLD, GtWorldgenTrees.defaultOverworldBiomes()),
            new GtWorldgenTrees("tree.hazel", Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_LEAVES, 1, 32, Level.OVERWORLD, GtWorldgenTrees.defaultOverworldBiomes()),
            new GtWorldgenTrees("tree.cinnamon", Blocks.ACACIA_LOG, Blocks.ACACIA_LEAVES, 1, 3, Level.OVERWORLD, GtWorldgenTrees.defaultOverworldBiomes()),
            new GtWorldgenTrees("tree.coconut", Blocks.JUNGLE_LOG, Blocks.JUNGLE_LEAVES, 1, 1, Level.OVERWORLD, GtWorldgenTrees.defaultOverworldBiomes()),
            new GtWorldgenTrees("tree.rainbowood", Blocks.CHERRY_LOG, Blocks.CHERRY_LEAVES, 1, 4, Level.OVERWORLD, GtWorldgenTrees.defaultOverworldBiomes()),
            new GtWorldgenTrees("tree.bluespruce", Blocks.SPRUCE_LOG, Blocks.SPRUCE_LEAVES, 1, 32, Level.OVERWORLD, GtWorldgenTrees.defaultOverworldBiomes()),
            new GtWorldgenRocks("overworld.rocks", 2, 3),
            new GtWorldgenSticks("sticks", 2, 2),
            new GtWorldgenBushes("plant.bush", 1, 4),
            new GtWorldgenGlowtus("plant.glowtus", 16, 2),
            new GtWorldgenHives("overworld.bumblehives", 1, 8),
            new GtWorldgenOresVanilla("overworld.ore.coal", Blocks.STONE, 20, 120, 10, GtOreMaterial.COAL, Level.OVERWORLD, ANY_BIOME),
            new GtWorldgenOresVanilla("overworld.ore.iron", Blocks.STONE, 10, 80, 8, GtOreMaterial.FE2O3, Level.OVERWORLD, ANY_BIOME),
            new GtWorldgenOresVanilla("overworld.ore.copper", Blocks.STONE, 40, 120, 8, GtOreMaterial.CU, Level.OVERWORLD, ANY_BIOME),
            new GtWorldgenFlowers("plant.flowers", Blocks.DANDELION, 2, 4, Level.OVERWORLD, GtWorldgenFlowers.defaultOverworldBiomes()),
            new GtWorldgenFluidSpring("overworld.fluid.water", 100, Blocks.WATER, "minecraft:water", 1),
            new GtWorldgenFluidSpring("overworld.fluid.lava", 200, Blocks.LAVA, "minecraft:lava", 2),
            new GtWorldgenColtan("overworld.coltan", 4, 20),
            new GtWorldgenOresLarge("ore.large"),
            new GtWorldgenOresSmall("ore.small"),
            new GtWorldgenDungeon("dungeon.gt", 200)
    );

    private static final List<GtChunkWorldgen> NETHER = List.of(
            new GtWorldgenNetherClay("nether.clay.red"),
            new GtWorldgenNetherQuartz("nether.netherquartz"),
            new GtWorldgenNetherCrystals("nether.nethercrystals"),
            new GtWorldgenHives("nether.bumblehives", 1, 8, Level.NETHER, ANY_BIOME),
            new GtWorldgenRacks("nether.racks", 6, 18)
    );

    private static final List<GtChunkWorldgen> DIMENSIONAL = List.of(
            new GtWorldgenDimensionRocks("aether.rocks", "aether", 2, 3),
            new GtWorldgenDimensionRocks("erebus.rocks", "erebus", 2, 3),
            new GtWorldgenDimensionRocks("alfheim.rocks", "alfheim", 2, 3),
            new GtWorldgenDimensionRocks("planet.rocks", "planet", 2, 3),
            new GtWorldgenDimensionRocks("moon.rocks", "moon", 2, 3),
            new GtWorldgenDimensionRocks("mars.rocks", "mars", 2, 3),
            new GtWorldgenHives("end.bumblehives", 1, 8, Level.END, ANY_BIOME)
    );

    private GtWorldgenRegistry() {
    }

    public static List<GtChunkWorldgen> overworld() {
        return OVERWORLD;
    }

    public static List<GtChunkWorldgen> nether() {
        return NETHER;
    }

    public static List<GtChunkWorldgen> dimensional() {
        return DIMENSIONAL;
    }
}
