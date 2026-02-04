package com.gt6ceu.client.atlas;

import io.redspace.atlasapi.api.AssetHandler;
import io.redspace.atlasapi.api.data.BakingPreparations;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.sources.SingleFile;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class GTOreAssetHandler extends AssetHandler {

    @Override
    public List<SpriteSource> buildSpriteSources() {
        return List.of(
                new SingleFile(
                        ResourceLocation.fromNamespaceAndPath("gt6ceu", "block/test"),
                        Optional.of(
                                ResourceLocation.fromNamespaceAndPath("gt6ceu", "block/test")
                        )
                )
        );
    }

    @Override
    public BakingPreparations makeBakedModelPreparations(ItemStack stack,
                                                         @Nullable ClientLevel level,
                                                         @Nullable LivingEntity entity,
                                                         int seed) {
        return new BakingPreparations(List.of());
    }

    @Override
    public int modelId(ItemStack stack,
                       @Nullable ClientLevel level,
                       @Nullable LivingEntity entity,
                       int seed) {
        return 0;
    }
}
