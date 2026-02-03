package com.gt6ceu.gregtech.worldgen;

import com.gt6ceu.gregtech.registry.GTRocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.List;

public class GTStoneLayers extends Feature<NoneFeatureConfiguration> {

    // Порядок камней — тот же, что в Loader_Rocks
    private final List<BlockState> states;

    public GTStoneLayers(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
        this.states = GTRocks.ROCKS.values().stream()
                .map(h -> h.value().defaultBlockState())
                .toList();
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        WorldGenLevel level = ctx.level();
        BlockPos origin = ctx.origin();
        int baseX = origin.getX();
        int baseZ = origin.getZ();

        // супер-простой "шум": хеш координат -> индекс породы
        for (int dx = 0; dx < 16; dx++) for (int dz = 0; dz < 16; dz++) {
            int x = baseX + dx;
            int z = baseZ + dz;

            int idx = fastHashToIndex(x, z, states.size());
            BlockState replaceWith = states.get(idx);

            // пока просто заменяем камень ниже 64
            for (int y = level.getMinBuildHeight(); y < 64; y++) {
                BlockPos p = new BlockPos(x, y, z);
                BlockState s = level.getBlockState(p);

                if (s.is(Blocks.STONE) || s.is(Blocks.DEEPSLATE)) {
                    level.setBlock(p, replaceWith, 2);
                }
            }
        }
        return true;
    }

    private static int fastHashToIndex(int x, int z, int mod) {
        long h = x * 341873128712L + z * 132897987541L; // типичный seed mix
        h ^= (h >>> 13);
        h *= 1274126177L;
        h ^= (h >>> 16);
        int v = (int) (h & 0x7fffffff);
        return v % mod;
    }
}
