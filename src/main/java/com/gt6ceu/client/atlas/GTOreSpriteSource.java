package com.gt6ceu.client.atlas;

import com.gt6ceu.GT6CEuModern;
import com.gt6ceu.gregtech.registry.GTOreType;
import com.gt6ceu.gregtech.registry.GTRockType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.SpriteSourceType;
import net.minecraft.client.renderer.texture.atlas.SpriteSources;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;

public class GTOreSpriteSource implements SpriteSource {

    public static final Codec<GTOreSpriteSource> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            Codec.STRING.fieldOf("rock").forGetter(s -> s.rock.getSerializedName()),
            Codec.STRING.fieldOf("ore").forGetter(s -> s.ore.getSerializedName())
    ).apply(inst, (r, o) -> new GTOreSpriteSource(
            GTRockType.valueOf(r.toUpperCase()),
            GTOreType.valueOf(o.toUpperCase())
    )));

    private final GTRockType rock;
    private final GTOreType ore;

    public GTOreSpriteSource(GTRockType rock, GTOreType ore) {
        this.rock = rock;
        this.ore = ore;
    }

    public ResourceLocation spriteId() {
        return ResourceLocation.fromNamespaceAndPath(
                GT6CEuModern.MODID,
                "block/dyn_ore/" + rock.getSerializedName() + "/" + ore.getSerializedName()
        );
    }

    @Override
    public void run(ResourceManager resourceManager, Output output) {
        // TODO: сюда позже вставим генерацию спрайта (rock + ORE_*) и output.add(...)
    }

    @Override
    public SpriteSourceType type() {
        return SpriteSources.SINGLE_FILE; // просто чтобы компилилось
    }
}
