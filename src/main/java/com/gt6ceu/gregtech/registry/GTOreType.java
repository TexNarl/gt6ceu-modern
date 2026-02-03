package com.gt6ceu.gregtech.registry;

import net.minecraft.util.StringRepresentable;

public enum GTOreType implements StringRepresentable {
    // пример, добавь все
    CASSITERITE("cassiterite"),
    AMBER("amber"),
    CHALCOPYRITE("chalcopyrite");
    // ...

    private final String id;
    GTOreType(String id) { this.id = id; }
    @Override public String getSerializedName() { return id; }
}
