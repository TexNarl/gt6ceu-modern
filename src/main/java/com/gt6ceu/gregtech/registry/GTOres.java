package com.gt6ceu.gregtech.registry;

import com.gt6ceu.GT6CEuModern;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.LinkedHashMap;
import java.util.Map;

public final class GTOres {
    public static final Map<String, DeferredBlock<Block>> ORES = new LinkedHashMap<>();
    private static boolean inited = false;

    private static void ore(String regName) {
        DeferredBlock<Block> block = GT6CEuModern.BLOCKS.registerSimpleBlock(
                regName,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .strength(3.0f, 6.0f)
                        .requiresCorrectToolForDrops()
        );
        GT6CEuModern.ITEMS.registerSimpleBlockItem(regName, block);
        ORES.put(regName, block);
    }

    private static String oreId(String materialLower) {
        return "gt_ore_" + materialLower;
    }

    private static String crystalOreId(String materialLower) {
        return "gt_crystal_ore_" + materialLower;
    }

    public static void init() {
        if (inited) return;
        inited = true;

        // --- CRYSTAL ORES (из BlockCrystalOres в GT6) ---
        ore(crystalOreId("arsenopyrite"));
        ore(crystalOreId("chalcopyrite"));
        ore(crystalOreId("cinnabar"));
        ore(crystalOreId("cobaltite"));
        ore(crystalOreId("galena"));
        ore(crystalOreId("kesterite"));
        ore(crystalOreId("molybdenite"));
        ore(crystalOreId("pyrite"));
        ore(crystalOreId("sphalerite"));
        ore(crystalOreId("stannite"));
        ore(crystalOreId("stibnite"));
        ore(crystalOreId("tetrahedrite"));

        // --- “обычные” руды/породы-руды (списки ORE_MATERIALS и sOres в GT6) ---
        // простые
        ore(oreId("coal"));
        ore(oreId("lignite"));
        ore(oreId("nacl"));          // Salt / Rock Salt (NaCl)
        ore(oreId("kcl"));           // Potassium Salt (KCl)
        ore(oreId("oilshale"));      // Oil Shale
        ore(oreId("gypsum"));
        ore(oreId("milkyquartz"));
        ore(oreId("netherquartz"));
        ore(oreId("s"));             // Sulfur (MT.S)
        ore(oreId("apatite"));
        ore(oreId("ruby"));
        ore(oreId("amber"));
        ore(oreId("amethyst"));
        ore(oreId("graphite"));

        // оксиды из генерации (sOres в GT6)
        ore(oreId("tio2"));          // TiO2 (в GT6 это “титановая руда”/рутил-ветка)
        ore(oreId("mno2"));          // MnO2
        ore(oreId("fe2o3"));         // Fe2O3

        // --- MT.OREMATS.* (все 50 из GT6) ---
        ore(oreId("arsenopyrite"));
        ore(oreId("barite"));
        ore(oreId("basaltic_mineral_sand"));
        ore(oreId("bastnasite"));
        ore(oreId("bauxite"));
        ore(oreId("borax"));
        ore(oreId("bromargyrite"));
        ore(oreId("brown_limonite"));
        ore(oreId("cassiterite"));
        ore(oreId("celestine"));
        ore(oreId("chalcopyrite"));
        ore(oreId("chromite"));
        ore(oreId("cinnabar"));
        ore(oreId("cobaltite"));
        ore(oreId("coltan"));
        ore(oreId("columbite"));
        ore(oreId("cooperite"));
        ore(oreId("ferberite"));
        ore(oreId("ferrovanadium"));
        ore(oreId("galena"));
        ore(oreId("garnet_sand"));
        ore(oreId("garnierite"));
        ore(oreId("glauconite_sand"));
        ore(oreId("granitic_mineral_sand"));
        ore(oreId("huebnerite"));
        ore(oreId("ilmenite"));
        ore(oreId("kesterite"));
        ore(oreId("magnetite"));
        ore(oreId("malachite"));
        ore(oreId("molybdenite"));
        ore(oreId("pentlandite"));
        ore(oreId("pitchblende"));
        ore(oreId("pollucite"));
        ore(oreId("powellite"));
        ore(oreId("quartz_sand"));
        ore(oreId("realgar"));
        ore(oreId("scheelite"));
        ore(oreId("smithsonite"));
        ore(oreId("sperrylite"));
        ore(oreId("sphalerite"));
        ore(oreId("stannite"));
        ore(oreId("stibnite"));
        ore(oreId("tantalite"));
        ore(oreId("tetrahedrite"));
        ore(oreId("tungstate"));
        ore(oreId("vermiculite"));
        ore(oreId("wolframite"));
        ore(oreId("wulfenite"));
        ore(oreId("yellow_limonite"));
        ore(oreId("zeolite"));
    }

    private GTOres() {}
}
