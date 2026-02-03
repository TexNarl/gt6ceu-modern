package com.gt6ceu.gregtech.registry;

import com.gt6ceu.GT6CEuModern;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;

public final class GTCreativeTabs {
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ORES_TAB =
            GT6CEuModern.CREATIVE_MODE_TABS.register("gt6ceu_ores", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.gt6ceu_ores"))
                            .icon(() -> {
                                var first = GTOres.ORES.values().stream().findFirst().orElse(null);
                                return first != null ? new ItemStack(first.get()) : ItemStack.EMPTY;
                            })
                            .displayItems((params, output) -> {
                                for (var b : GTOres.ORES.values()) output.accept(b);
                            })
                            .build()
            );

    private GTCreativeTabs() {}
}
