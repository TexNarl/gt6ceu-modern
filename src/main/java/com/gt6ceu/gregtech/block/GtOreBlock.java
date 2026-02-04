/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/block/BlockOres.java
 * Purpose: Base GT ore block with material and stone type properties.
 * Status: PORTED
 * Notes: Encodes ore material and host stone in blockstate properties.
 */
package com.gt6ceu.gregtech.block;

import com.gt6ceu.gregtech.worldgen.GtOreMaterial;
import com.gt6ceu.gregtech.worldgen.GtStoneType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class GtOreBlock extends Block {
    public static final IntegerProperty MATERIAL = IntegerProperty.create("material", 0, GtOreMaterial.maxId());
    public static final IntegerProperty STONE_TYPE = IntegerProperty.create("stone_type", 0, GtStoneType.maxId());

    public GtOreBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
                .setValue(MATERIAL, GtOreMaterial.EMPTY.getId())
                .setValue(STONE_TYPE, GtStoneType.DEEPSLATE.getId()));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(MATERIAL, STONE_TYPE);
    }
}
