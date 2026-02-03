package com.gt6ceu.gregtech.registry;

import net.minecraft.util.StringRepresentable;

public enum GTRockType implements StringRepresentable {
    GRANITE_BLACK("granite_black"),
    GRANITE_RED("granite_red"),
    BASALT("basalt"),
    MARBLE("marble"),
    LIMESTONE("limestone"),
    GRANITE("granite"),
    DIORITE("diorite"),
    ANDESITE("andesite"),
    KOMATIITE("komatiite"),
    GREENSCHIST("greenschist"),
    BLUESCHIST("blueschist"),
    KIMBERLITE("kimberlite"),
    QUARTZITE("quartzite"),
    PRISMARINE_LIGHT("prismarine_light"),
    PRISMARINE_DARK("prismarine_dark"),
    SLATE("slate"),
    SHALE("shale");

    private final String id;
    GTRockType(String id) { this.id = id; }
    @Override public String getSerializedName() { return id; }
}
