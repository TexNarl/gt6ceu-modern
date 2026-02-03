package com.gt6ceu.gregtech.registry;

import java.util.List;

public final class GTOreTypes {
    // Crystal ores (из BlockCrystalOres)
    public static final List<String> CRYSTAL = List.of(
            "arsenopyrite","chalcopyrite","cinnabar","cobaltite","galena","kesterite",
            "molybdenite","pyrite","sphalerite","stannite","stibnite","tetrahedrite"
    );

    // “простые” (то, что ты уже начал)
    public static final List<String> SIMPLE = List.of(
            "coal","lignite","nacl","kcl","oilshale","gypsum","milkyquartz","netherquartz",
            "s","apatite","ruby","amber","amethyst","graphite",
            "tio2","mno2","fe2o3"
    );

    // OREMATS (тот самый набор, который используется в worldgen списках GT6; у тебя он уже выписан)
    // В твоём GT6-дампе точно встречаются многие из них в sOres:contentReference[oaicite:2]{index=2},
    // и дополнительно есть Bastnasite/Coltan/Malachite/Bromargyrite/Smithsonite/Sperrylite:contentReference[oaicite:3]{index=3}.
    public static final List<String> OREMATS = List.of(
            "arsenopyrite","barite","basaltic_mineral_sand","bastnasite","bauxite","borax",
            "bromargyrite","brown_limonite","cassiterite","celestine","chalcopyrite","chromite",
            "cinnabar","cobaltite","coltan","columbite","cooperite","ferberite","ferrovanadium",
            "galena","garnet_sand","garnierite","glauconite_sand","granitic_mineral_sand",
            "huebnerite","ilmenite","kesterite","magnetite","malachite","molybdenite","pentlandite",
            "pitchblende","pollucite","powellite","quartz_sand","realgar","scheelite","smithsonite",
            "sperrylite","sphalerite","stannite","stibnite","tantalite","tetrahedrite","tungstate",
            "vermiculite","wolframite","wulfenite","yellow_limonite","zeolite"
    );

    private GTOreTypes() {}
}
