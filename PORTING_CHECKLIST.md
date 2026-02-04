This checklist is governed by CODEX_PORTING_SPEC.md.
All porting work must comply with that specification.

# GregTech 6 CEu Modern — Porting Checklist

This checklist captures the high-level systems that need to be reimplemented
for a full GT6 port to modern NeoForge. It is organized around the structure
of the legacy GT6 codebase in `example_of_gt6` so we can map modules and track
progress without editing the original sources.

## How to use
- Treat each bullet as a module-level deliverable.
- Expand into per-feature tasks as each system is started.
- Keep the list ordered by dependency (core APIs → content → worldgen → UI → compat).

## Core framework (gregapi)
- [ ] **Data & constants**: migrate global constants, enums, and data tables. (`gregapi/data`)
- [ ] **Config system**: port configuration definitions and config-backed toggles. (`gregapi/config`)
- [ ] **Localization**: port lang keys, translation loading, and naming conventions. (`gregapi/lang`)
- [ ] **Logging**: implement structured logging utilities. (`gregapi/log`)
- [ ] **Event hooks**: map event bus hooks to NeoForge equivalents. (`gregapi/event`)
- [ ] **Networking**: migrate custom packets and sync layers. (`gregapi/network`)
- [ ] **GUI framework**: port GUI widgets, layouts, and screen logic. (`gregapi/gui`)
- [ ] **Rendering**: port any custom renderers and model registration. (`gregapi/render`)
- [ ] **API surface**: public APIs used by GT and addons. (`gregapi/api`)
- [ ] **Utilities**: port common helpers (math, NBT, item utils, etc.). (`gregapi/util`)
- [ ] **Recipes**: migrate recipe map definitions and handlers. (`gregapi/recipes`)
- [ ] **Ore dictionary**: translate oredict behaviors to modern tags. (`gregapi/oredict`)
- [ ] **Materials & physical properties**: port material definitions, mass, melt/boil temps, and other physical stats. (`gregapi/data`, `gregtech/items`)
- [ ] **Wood dictionary**: port GT6 wood classification and tag mapping. (`gregapi/wooddict`)
- [ ] **Item system**: shared item base classes and behaviors. (`gregapi/item`)
- [ ] **Block system**: shared block base classes and behaviors. (`gregapi/block`)
- [ ] **Tile entities**: base tile logic and capability wrappers. (`gregapi/tileentity`)
- [ ] **Fluids**: fluid registration, containers, and behaviors. (`gregapi/fluid`)
- [ ] **Covers**: cover interfaces and behaviors for machines. (`gregapi/cover`)
- [ ] **Damage & enchants**: custom damage types and enchant logic. (`gregapi/damage`, `gregapi/enchants`)
- [ ] **Worldgen API**: reusable worldgen helpers and noise logic. (`gregapi/worldgen`)
- [ ] **Compatibility**: shared compat shims. (`gregapi/compat`)

## GT6 gameplay systems (gregtech)
- [ ] **Items**: materials, tools, components, consumables, batteries, and durability rules. (`gregtech/items`)
- [ ] **Blocks**: stones, ores, machine blocks, and multiblock casings. (`gregtech/blocks`)
- [ ] **Tile entities**: machine logic, energy/steam systems, inventories, and IO rules. (`gregtech/tileentity`)
- [ ] **Entities**: any custom entities (projectiles, mobs, etc.). (`gregtech/entities`)
- [ ] **Worldgen**: ore/rock generation, vein logic, and biome hooks. (`gregtech/worldgen`)
- [ ] **Rendering**: machine renders, special block/item models. (`gregtech/render`)
- [ ] **Loaders**: registries, post-init hookups, recipe loaders. (`gregtech/loaders`)
- [ ] **Compatibility**: integration with other mods. (`gregtech/compat`)
- [ ] **ASM/patches**: remove/replace legacy coremod logic with NeoForge hooks. (`gregtech/asm`)
- [ ] **Experimental/legacy**: identify any features to retire or rewrite. (`gregtech/experiments`, `gregtech/old`)
- [ ] **Pipes & cables**: item/fluid/energy transport blocks and behaviors. (`gregtech/blocks`, `gregtech/tileentity`)
- [ ] **Tools & armor**: tool tiers, mining levels, and armor stats. (`gregtech/items`)
- [ ] **Multiblocks**: controller logic, structure validation, and hatches. (`gregtech/tileentity`, `gregtech/blocks`)

## Assets & data
- [ ] **Block/item models**: port or recreate model JSONs and blockstates. (`example_of_gt6/src/main/resources/assets`)
- [ ] **Textures**: copy GT6 textures verbatim; no new or modified images.
  All visual variants must be achieved via models, blockstates, or code.
- [ ] **Sounds**: port custom sound assets and events. (`example_of_gt6/src/main/resources/assets`)
- [ ] **Data packs**: tags, recipes, loot tables. (Modern data pack format)
- [ ] **Translations**: merge and validate lang files. (`example_of_gt6/src/main/resources/assets`)

## Project scaffolding (modern repo)
- [ ] **Registries**: consolidate GT registries in `src/main/java/com/gt6ceu/gregtech/registry`.
- [ ] **Worldgen**: port stone/ore layer logic into modern worldgen pipeline.
- [ ] **Config**: expand `Config` to cover GT6 feature flags and tuning.
- [ ] **Creative tabs**: align creative tab layout with GT6 categories.

## Tracking conventions
- Mark a task as complete only when feature parity is verified in-game.
- For large systems (e.g., machines), create sub-checklists in dedicated docs.
