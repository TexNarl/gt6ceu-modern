import os
import shutil
import sys

GT6_RELATIVE = os.path.join(
    "src", "main", "resources",
    "assets", "gregtech",
    "textures", "blocks", "stones"
)

DEST_RELATIVE = os.path.join(
    "src", "main", "resources",
    "assets", "gt6ceu",
    "textures", "block"
)

VARIANT_MAP = {
    "STONE.png": "stone",
    "SMOOTH.png": "smooth",
    "COBBLE.png": "cobble",
    "COBBLE_MOSSY.png": "cobble_mossy",
    "BRICKS.png": "bricks",
    "BRICKS_CHISELED.png": "bricks_chiseled",
    "BRICKS_CRACKED.png": "bricks_cracked",
    "BRICKS_MOSSY.png": "bricks_mossy",
    "SMALL_BRICKS.png": "small_bricks",
    "TILES.png": "tiles",
    "SMALL_TILES.png": "small_tiles",
    "SQUARE_BRICKS.png": "square_bricks",
    "WINDMILL_TILES_A.png": "windmill_tiles_a",
    "WINDMILL_TILES_B.png": "windmill_tiles_b",
}

def die(msg):
    print("[ERROR]", msg)
    sys.exit(1)

def main(gt6_root, dest_root):
    src_root = os.path.join(gt6_root, GT6_RELATIVE)
    if not os.path.isdir(src_root):
        die(f"Не найдена папка GT6 stones: {src_root}")

    dst_root = os.path.join(dest_root, DEST_RELATIVE)
    os.makedirs(dst_root, exist_ok=True)

    copied = 0

    for folder in os.listdir(src_root):
        folder_path = os.path.join(src_root, folder)
        if not os.path.isdir(folder_path):
            continue

        # gt.stone.blueschist -> gt_stone_blueschist
        base = folder.replace(".", "_")

        for src_name, suffix in VARIANT_MAP.items():
            src_file = os.path.join(folder_path, src_name)
            if not os.path.isfile(src_file):
                continue

            dst_name = f"{base}_{suffix}.png"
            dst_file = os.path.join(dst_root, dst_name)

            shutil.copy2(src_file, dst_file)
            copied += 1

    print(f"[OK] Скопировано текстур: {copied}")
    print(f"[OK] Путь назначения: {dst_root}")

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage:")
        print("  python copy_gt6_textures.py <path_to_gt6> <path_to_your_project>")
        sys.exit(1)

    main(sys.argv[1], sys.argv[2])
