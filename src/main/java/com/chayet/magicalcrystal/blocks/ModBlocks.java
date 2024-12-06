package com.chayet.magicalcrystal.blocks;

import com.chayet.magicalcrystal.MagicalCrystal;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //all blocks
    public static final Block MAGICAL_CRYSTAL_BLOCK = registerBlocks("magical_crystal_block",
            new Block(AbstractBlock.Settings.create().strength(60f).requiresTool()
                    .sounds(BlockSoundGroup.METAL).mapColor(MapColor.PALE_PURPLE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_block")))
            ));

    //ore blocks
    public static final Block MAGICAL_CRYSTAL_ORE = registerBlocks("magical_crystal_ore",
            new Block(AbstractBlock.Settings.create().strength(25f).requiresTool()
                    .sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_ore")))
            ));
    public static final Block DEEPSLATE_MAGICAL_CRYSTAL_ORE = registerBlocks("deepslate_magical_crystal_ore",
            new Block(AbstractBlock.Settings.create().strength(40f).requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE).mapColor(MapColor.DEEPSLATE_GRAY)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MagicalCrystal.MOD_ID, "deepslate_magical_crystal_ore")))
            ));


    //method for block items
    private static void registerBlockItems(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MagicalCrystal.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    //method for blocks
    private static Block registerBlocks(String name, Block block) {
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MagicalCrystal.MOD_ID, name), block);
    }

    //all blocks register method
    public static void registerModBlocks() {
        MagicalCrystal.LOGGER.info("Registering Mod Blocks for " + MagicalCrystal.MOD_ID);
    }
}
