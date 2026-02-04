/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenGlowtus.java
 * Purpose: Store glowtus variant data for worldgen placements.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.blockentity;

import com.gt6ceu.gregtech.registry.GTBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GtGlowtusBlockEntity extends BlockEntity {
    private int variant;
    private int age;

    public GtGlowtusBlockEntity(BlockPos pos, BlockState state) {
        super(GTBlockEntities.GLOWTUS.get(), pos, state);
    }

    public void setVariant(int variant, int age) {
        this.variant = variant;
        this.age = age;
        setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Variant", variant);
        tag.putInt("Age", age);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        variant = tag.getInt("Variant");
        age = tag.getInt("Age");
    }
}
