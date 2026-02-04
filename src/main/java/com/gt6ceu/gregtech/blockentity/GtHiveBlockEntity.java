/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenHives.java
 * Purpose: Store hive variant/species data for worldgen placements.
 * Status: PORTED
 * Notes: Simplified NBT payload for now.
 */
package com.gt6ceu.gregtech.blockentity;

import com.gt6ceu.gregtech.registry.GTBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GtHiveBlockEntity extends BlockEntity {
    private int speciesId;
    private int hiveColor;
    private int generationSeed;
    private int honeyLevel;
    private int population;

    public GtHiveBlockEntity(BlockPos pos, BlockState state) {
        super(GTBlockEntities.HIVE.get(), pos, state);
    }

    public void setHiveData(int speciesId, int hiveColor, int generationSeed, int honeyLevel, int population) {
        this.speciesId = speciesId;
        this.hiveColor = hiveColor;
        this.generationSeed = generationSeed;
        this.honeyLevel = honeyLevel;
        this.population = population;
        setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("SpeciesId", speciesId);
        tag.putInt("HiveColor", hiveColor);
        tag.putInt("GenerationSeed", generationSeed);
        tag.putInt("HoneyLevel", honeyLevel);
        tag.putInt("Population", population);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        speciesId = tag.getInt("SpeciesId");
        hiveColor = tag.getInt("HiveColor");
        generationSeed = tag.getInt("GenerationSeed");
        honeyLevel = tag.getInt("HoneyLevel");
        population = tag.getInt("Population");
    }
}
