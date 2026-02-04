/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: gregtech/loaders/b/Loader_Worldgen.java
 * Purpose: Enumerate GregTech stone layer types for world generation.
 * Status: PORTED
 * Notes: Mirrors GT6 stone layer identifiers for modern registries.
 */
package com.gt6ceu.gregtech.worldgen;

import java.util.Arrays;

public enum GtStoneType {
    DEEPSLATE(0, "deepslate"),
    SLATE(1, "slate"),
    KOMATIITE(2, "komatiite"),
    KIMBERLITE(3, "kimberlite"),
    BASALT(4, "basalt"),
    ANDESITE(5, "andesite"),
    MARBLE(6, "marble"),
    LIMESTONE(7, "limestone"),
    GRANITE_BLACK(8, "granite_black"),
    GRANITE_RED(9, "granite_red"),
    GRANITE(10, "granite"),
    DIORITE(11, "diorite"),
    SCHIST_GREEN(12, "schist_green"),
    SCHIST_BLUE(13, "schist_blue"),
    SHALE(14, "shale"),
    QUARTZITE(15, "quartzite");

    private final int id;
    private final String registryName;

    GtStoneType(int id, String registryName) {
        this.id = id;
        this.registryName = registryName;
    }

    public int getId() {
        return id;
    }

    public String getRegistryName() {
        return registryName;
    }

    public static int maxId() {
        return Arrays.stream(values()).mapToInt(GtStoneType::getId).max().orElse(0);
    }

    public static GtStoneType byId(int id) {
        for (GtStoneType type : values()) {
            if (type.id == id) {
                return type;
            }
        }
        return DEEPSLATE;
    }
}
