package com.gt6ceu.gregtech.registry;

import com.gt6ceu.GT6CEuModern;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.LinkedHashMap;
import java.util.Map;

public final class GTRocks {

    /** gt-style id -> block */
    public static final Map<String, DeferredBlock<Block>> ROCKS = new LinkedHashMap<>();
    private static boolean inited = false;

    /** БАЗОВЫЕ ПОРОДЫ (GT6) */
    private static final String[] BASE_ROCKS = {
            "granite.black",
            "granite.red",
            "basalt",
            "marble",
            "limestone",
            "granite",
            "diorite",
            "andesite",
            "komatiite",
            "greenschist",
            "blueschist",
            "kimberlite",
            "quartzite",
            "prismarine.light",
            "prismarine.dark",
            "slate",
            "shale"
    };

    /** ВАРИАЦИИ (как в GT6) */
    private static final String[] VARIANTS = {
            "stone",
            "smooth",
            "cobble",
            "cobble.mossy",
            "bricks",
            "bricks.chiseled",
            "bricks.cracked",
            "bricks.mossy",
            "small.bricks",
            "tiles",
            "small.tiles",
            "square.bricks",
            "windmill.tiles.a",
            "windmill.tiles.b"
    };

    private static void register(String baseRock, String variant) {
        // gt.stone.andesite.bricks
        String gtId = "gt.stone." + baseRock + "." + variant;

        // gt_stone_andesite_bricks
        String regName = gtId.replace('.', '_');

        DeferredBlock<Block> block = GT6CEuModern.BLOCKS.registerSimpleBlock(
                regName,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .strength(1.5f, 6.0f)
                        .requiresCorrectToolForDrops()
        );

        GT6CEuModern.ITEMS.registerSimpleBlockItem(regName, block);
        ROCKS.put(gtId, block);
    }

    public static void init() {
        if (inited) return;
        inited = true;

        for (String rock : BASE_ROCKS) {
            for (String variant : VARIANTS) {
                register(rock, variant);
            }
        }
    }

    private GTRocks() {}
}
