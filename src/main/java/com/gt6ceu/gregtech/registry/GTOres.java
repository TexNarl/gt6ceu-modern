package com.gt6ceu.gregtech.registry;

import com.gt6ceu.GT6CEuModern;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.LinkedHashMap;
import java.util.Map;

public final class GTOres {
    public static final Map<String, DeferredBlock<Block>> ORES = new LinkedHashMap<>();
    private static boolean inited = false;

    private static DeferredBlock<Block> registerOreBlock(String regName) {
        DeferredBlock<Block> block = GT6CEuModern.BLOCKS.registerSimpleBlock(
                regName,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .strength(3.0f, 6.0f)
                        .requiresCorrectToolForDrops()
        );
        GT6CEuModern.ITEMS.registerSimpleBlockItem(regName, block);
        return block;
    }

    private static String oreBlockId(String ore, String rockBase) {
        // rockBase: например "granite.black" или "basalt"
        // делаем безопасное имя:
        String rock = rockBase.replace('.', '_');
        return "gt_ore_" + ore + "__" + rock;
    }

    public static void init() {
        if (inited) return;
        inited = true;

        // 1) Берём список базовых пород (ТОЛЬКО stone-вариант, если хочешь как “руда в камне”)
        // В твоём GTRocks BASE_ROCKS уже есть нужные названия.
        for (String rockBase : GTRocks.getBaseRocks()) {

            // 2) Регистрируем все типы руд
            for (String ore : GTOreTypes.SIMPLE) {
                String id = oreBlockId(ore, rockBase);
                ORES.put(id, registerOreBlock(id));
            }
            for (String ore : GTOreTypes.OREMATS) {
                String id = oreBlockId(ore, rockBase);
                ORES.put(id, registerOreBlock(id));
            }
            for (String ore : GTOreTypes.CRYSTAL) {
                String id = "gt_crystal_ore_" + ore + "__" + rockBase.replace('.', '_');
                ORES.put(id, registerOreBlock(id));
            }
        }
    }

    private GTOres() {}
}
