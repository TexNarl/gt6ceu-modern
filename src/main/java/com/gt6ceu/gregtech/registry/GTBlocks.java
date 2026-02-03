package com.gt6ceu.gregtech.registry;

import com.gt6ceu.GT6CEuModern;
import com.gt6ceu.gregtech.block.GTOreBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public final class GTBlocks {
    public static final DeferredBlock<Block> GT_ORE =
            GT6CEuModern.BLOCKS.register("gt_ore", () ->
                    new GTOreBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(3.0f, 6.0f)
                            .requiresCorrectToolForDrops()));

    public static void init() {
        GT6CEuModern.ITEMS.registerSimpleBlockItem("gt_ore", GT_ORE);
    }
}
