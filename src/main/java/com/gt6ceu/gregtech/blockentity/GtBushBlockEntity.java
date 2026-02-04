/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenBushes.java
 * Purpose: Store bush species/berry data for worldgen placements.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.blockentity;

import com.gt6ceu.gregtech.registry.GTBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GtBushBlockEntity extends BlockEntity {
    private int berryType;
    private int growthStage;
    private int clusterSize;
    private boolean hasFruit;

    public GtBushBlockEntity(BlockPos pos, BlockState state) {
        super(GTBlockEntities.BUSH.get(), pos, state);
    }

    public void setBushData(int berryType, int growthStage, int clusterSize, boolean hasFruit) {
        this.berryType = berryType;
        this.growthStage = growthStage;
        this.clusterSize = clusterSize;
        this.hasFruit = hasFruit;
        setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("BerryType", berryType);
        tag.putInt("GrowthStage", growthStage);
        tag.putInt("ClusterSize", clusterSize);
        tag.putBoolean("HasFruit", hasFruit);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        berryType = tag.getInt("BerryType");
        growthStage = tag.getInt("GrowthStage");
        clusterSize = tag.getInt("ClusterSize");
        hasFruit = tag.getBoolean("HasFruit");
    }
}
