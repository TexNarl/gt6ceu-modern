# CODEX PORTING SPEC
## GregTech-6 → Minecraft 1.21.1 NeoForge (Java 21)

This document defines **mandatory rules** for porting GregTech-6
from Minecraft 1.7.10 Forge (Java 8) to Minecraft 1.21.1 NeoForge (Java 21).

This is a **porting contract**, not a suggestion.

---

## 1. Global Target

- Source: GregTech-6, Minecraft 1.7.10, Forge, Java 8
- Target: Minecraft 1.21.1, NeoForge, Java 21
- Goal: A **faithful technical port**, not a redesign and not a refactor

---

## 2. File-by-File Porting Rule (MANDATORY)

### 2.1 Every Java file must be accounted for

- Recursively enumerate **every `.java` file** in the original GT6 source tree.
- For each file, choose **exactly one** status:

| Status   | Meaning |
|---------|--------|
| PORTED  | Rewritten for NeoForge 1.21.1 + Java 21 |
| MOVED   | Ported but relocated to a new package/module |
| REMOVED | File is obsolete and intentionally absent |

- **No file may be silently skipped.**

---

## 3. Meaning of “REMOVED / DO NOT PORT”

A file is considered **REMOVED** if it existed in GT6 only as a
**technical workaround or code-level hack** for limitations of:

- Minecraft 1.7.10 internals,
- old Forge APIs,
- legacy Java (6–8) language or JVM constraints,

and this workaround is no longer required because:

- Minecraft 1.21.1 provides native engine behavior,
- NeoForge provides an official API,
- Java 21 removes the original limitation.

### Rules for REMOVED files

If a file is REMOVED:

- Do NOT port the file
- Do NOT create a replacement Java class
- Do NOT create a stub
- Do NOT reimplement the logic elsewhere
- Do NOT “modernize” the workaround

The file simply **does not exist** in the modern codebase.

### Minimal documentation rule

- If the removal is obvious, no documentation is required.
- If the removal is non-obvious, add a short explanation
  (commit message or brief markdown note).

---

## 4. Java & Code Style Rules

- All code must compile under **Java 21**
- Modern Java features may be used **only when they simplify compatibility**
- Behavior must remain equivalent unless explicitly documented

### Critical rule

This is a **port**, not a refactor.

- Do NOT refactor, redesign, or “clean up” code for style or readability alone
- Do NOT rewrite logic just because a modern pattern exists
- Changes are allowed only when required for NeoForge or Java 21 compatibility

---

## 5. Asset & Texture Rules (CRITICAL)

Models and blockstates must reference existing texture files by name;
no texture content generation or transformation is allowed.

### 5.1 Textures are immutable

- The directory `assets/gregtech/textures/` is **read-only**
- Textures must be copied verbatim from GT6
- **No new images may be created**
- **No existing images may be edited, split, recolored, or regenerated**

Clarification:
  When we say “textures should be created exactly like in GT6”,
  it means recreating the **same runtime/model/atlas composition behavior**.
  It does NOT mean generating or editing any image files.

### 5.2 GT6-style parameterized textures must be preserved

GregTech-6 relies on **parameterized texture composition**, for example:

- one ore texture,
- combined with multiple stone base textures,
- resulting in many visual variants without multiple ore PNGs.

This behavior **must be preserved exactly**.

### 5.3 Allowed changes

You MAY rewrite:
- `blockstates/*.json`
- `models/block/*.json`
- `models/item/*.json`
- Java-side model, atlas, or render logic

You MAY use:
- layered models
- atlas-based rendering
- mask-based or dynamic composition supported by Minecraft 1.21.1

You MAY NOT:
- generate combined textures
- bake variants into new images
- introduce placeholder textures

### Mandatory mental model

Assume:
1. The entire `textures/` folder was copied unchanged from GT6
2. Only models, blockstates, and code were rewritten
3. Visual output in-game must match GT6 behavior

If a solution requires new textures, the approach is incorrect.

---

## 6. API Replacement Guidance (Non-exhaustive)

- OreDictionary → Tags
- Old Forge registries → NeoForge registries / DeferredRegister
- Worldgen → ConfiguredFeature / PlacedFeature / biome modifiers
- Old packet systems → modern NeoForge networking
- ASM hacks → removed if obsolete; otherwise only if strictly unavoidable

---

## 7. Java File Header (REQUIRED)

Every PORTED or MOVED Java file must start with:

```java
/*
 * GT6 Port: 1.7.10 Forge → 1.21.1 NeoForge
 * Source: <original relative path>
 * Purpose: <1–2 lines>
 * Status: PORTED | MOVED
 * Notes: <important behavior or API changes>
 */
```

---

## 8. Reporting Requirement

Each porting iteration must report:
1. Count of PORTED / MOVED / REMOVED files
2. A list of processed files with:
- status
- original path
- new path or “removed”
- short justification

---

## 9. Forbidden Actions

The following are considered porting errors:
- Skipping a Java file
- Creating code for an obsolete workaround
- Creating or modifying textures
- Refactoring code “for cleanliness”
- Changing visual behavior compared to GT6
- Introducing new gameplay features not present in GT6