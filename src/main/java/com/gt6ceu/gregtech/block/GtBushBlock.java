/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/worldgen/WorldgenBushes.java
 * Purpose: Bush block with variant state and NBT storage.
 * Status: PORTED
 */
package com.gt6ceu.gregtech.block;

import com.gt6ceu.gregtech.blockentity.GtBushBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class GtBushBlock extends GtVariantBlock implements EntityBlock {
    public GtBushBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new GtBushBlockEntity(pos, state);
    }
}
