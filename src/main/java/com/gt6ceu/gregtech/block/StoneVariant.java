/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/block/metatype/BlockStones.java
 * Purpose: Represents GT6 stone block variants (stone/cobble/mossy).
 * Status: PORTED
 * Notes: Used to emulate GT6 stone metadata variants.
 */
package com.gt6ceu.gregtech.block;

import net.minecraft.util.StringRepresentable;

public enum StoneVariant implements StringRepresentable {
    STONE("stone"),
    COBBLE("cobble"),
    MOSSY("mossy");

    private final String serializedName;

    StoneVariant(String serializedName) {
        this.serializedName = serializedName;
    }

    @Override
    public String getSerializedName() {
        return serializedName;
    }
}
