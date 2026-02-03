package com.gt6ceu.client.atlas;

import com.gt6ceu.GT6CEuModern;
import io.redspace.atlasapi.api.AssetHandler;
import io.redspace.atlasapi.api.AtlasApiRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class GTAtlasHandlers {

    private static final DeferredRegister<AssetHandler> HANDLERS =
            DeferredRegister.create(AtlasApiRegistry.ASSET_HANDLER_REGISTRY_KEY, GT6CEuModern.MODID);

    public static final Supplier<GTOreAssetHandler> ORE_HANDLER =
            HANDLERS.register("ore_handler", GTOreAssetHandler::new);

    public static void register(IEventBus bus) {
        HANDLERS.register(bus);
    }

    private GTAtlasHandlers() {}
}
