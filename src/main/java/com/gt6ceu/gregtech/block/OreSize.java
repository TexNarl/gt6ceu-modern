/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregapi/block/BlockOres.java
 * Purpose: Represent GT6 ore block size variants (normal/small/broken).
 * Status: PORTED
 * Notes: State value for ore block variants to match GT6 behavior.
 */
package com.gt6ceu.gregtech.block;

import net.minecraft.util.StringRepresentable;

public enum OreSize implements StringRepresentable {
    NORMAL("normal"),
    SMALL("small"),
    BROKEN("broken");

    private final String serializedName;

    OreSize(String serializedName) {
        this.serializedName = serializedName;
    }

    @Override
    public String getSerializedName() {
        return serializedName;
    }
}
