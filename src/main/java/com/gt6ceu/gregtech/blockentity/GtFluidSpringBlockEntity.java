/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenFluidSpring.java
 * Purpose: Store fluid spring configuration and indicator data.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.blockentity;

import com.gt6ceu.gregtech.registry.GTBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GtFluidSpringBlockEntity extends BlockEntity {
    private String fluidId = "minecraft:water";
    private int indicatorType;

    public GtFluidSpringBlockEntity(BlockPos pos, BlockState state) {
        super(GTBlockEntities.FLUID_SPRING.get(), pos, state);
    }

    public void setSpringData(String fluidId, int indicatorType) {
        this.fluidId = fluidId;
        this.indicatorType = indicatorType;
        setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("FluidId", fluidId);
        tag.putInt("IndicatorType", indicatorType);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        fluidId = tag.getString("FluidId");
        indicatorType = tag.getInt("IndicatorType");
    }
}
