/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/block/metatype/BlockMetaType.java
 * Purpose: Simple meta-based block for GT6 worldgen variants.
 * Status: PORTED
 * Notes: Uses an integer blockstate instead of legacy metadata.
 */
package com.gt6ceu.gregtech.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class GtMetaBlock extends Block {
    public static final IntegerProperty META = IntegerProperty.create("meta", 0, 15);

    public GtMetaBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(META, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(META);
    }
}
