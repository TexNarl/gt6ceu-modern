/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/block/metatype/BlockStones.java
 * Purpose: Base GT stone block with stone/cobble/mossy variants.
 * Status: PORTED
 * Notes: Uses a blockstate property in place of legacy metadata.
 */
package com.gt6ceu.gregtech.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class GtStoneBlock extends Block {
    public static final EnumProperty<StoneVariant> VARIANT = EnumProperty.create("variant", StoneVariant.class);

    public GtStoneBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(VARIANT, StoneVariant.STONE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(VARIANT);
    }
}
