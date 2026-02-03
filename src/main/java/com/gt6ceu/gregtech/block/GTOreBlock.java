package com.gt6ceu.gregtech.block;

import com.gt6ceu.gregtech.registry.GTOreType;
import com.gt6ceu.gregtech.registry.GTRockType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class GTOreBlock extends Block {
    public static final EnumProperty<GTRockType> ROCK = EnumProperty.create("rock", GTRockType.class);
    public static final EnumProperty<GTOreType> ORE  = EnumProperty.create("ore",  GTOreType.class);

    public GTOreBlock(Properties props) {
        super(props);
        registerDefaultState(defaultBlockState()
                .setValue(ROCK, GTRockType.GRANITE_BLACK)
                .setValue(ORE,  GTOreType.CASSITERITE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        b.add(ROCK, ORE);
    }
}
