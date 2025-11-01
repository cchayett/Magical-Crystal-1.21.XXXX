package com.chayet.magicalcrystal.util;

import com.chayet.magicalcrystal.MagicalCrystal;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MagicalCrystal.MOD_ID, name));
        }
    }

    public static class Items{

        public static final TagKey<Item> MAGICAL_CRYSTAL_ITEM = createTag("magical_crystal_item");
        public static final TagKey<Item> MAGICAL_CRYSTAL_TOOL = createTag("magical_crystal_tool");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, name));
        }
    }
}
