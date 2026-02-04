/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenFluidSpring.java
 * Purpose: Fluid spring indicator block with variant state and NBT storage.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.block;

import com.gt6ceu.gregtech.blockentity.GtFluidSpringBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class GtFluidSpringBlock extends GtVariantBlock implements EntityBlock {
    public static final IntegerProperty INDICATOR = IntegerProperty.create("indicator", 0, 3);

    public GtFluidSpringBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(INDICATOR, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(INDICATOR);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new GtFluidSpringBlockEntity(pos, state);
    }
}
