package com.chayet.magicalcrystal.blocks;

import com.chayet.magicalcrystal.MagicalCrystal;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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

    //chaos tree blocks
    public static final Block CHAOS_LOG = registerBlocks("chaos_log",
            new Block(AbstractBlock.Settings.create().strength(10f)
                    .sounds(BlockSoundGroup.WOOD).mapColor(MapColor.PURPLE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MagicalCrystal.MOD_ID, "chaos_log")))
            ));
    public static final Block CHAOS_LEAVES = registerBlocks("chaos_leaves",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .sounds(BlockSoundGroup.AZALEA_LEAVES).mapColor(MapColor.PALE_PURPLE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MagicalCrystal.MOD_ID, "chaos_leaves")))
            ));
    public static final Block CHAOS_WOOD = registerBlocks("chaos_wood",
            new Block(AbstractBlock.Settings.create().strength(10f)
                    .sounds(BlockSoundGroup.WOOD).mapColor(MapColor.PURPLE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MagicalCrystal.MOD_ID, "chaos_wood")))
            ));
    public static final Block CHAOS_PLANKS = registerBlocks("chaos_planks",
            new Block(AbstractBlock.Settings.create().strength(10f)
                    .sounds(BlockSoundGroup.WOOD).mapColor(MapColor.PURPLE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MagicalCrystal.MOD_ID, "chaos_planks")))
            ));
    public static final Block STRIPPED_CHAOS_LOG = registerBlocks("stripped_chaos_log",
            new Block(AbstractBlock.Settings.create().strength(10f)
                    .sounds(BlockSoundGroup.WOOD).mapColor(MapColor.PURPLE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MagicalCrystal.MOD_ID, "stripped_chaos_log")))
            ));
    public static final Block STRIPPED_CHAOS_WOOD = registerBlocks("stripped_chaos_wood",
            new Block(AbstractBlock.Settings.create().strength(10f)
                    .sounds(BlockSoundGroup.WOOD).mapColor(MapColor.PURPLE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MagicalCrystal.MOD_ID, "stripped_chaos_wood")))
            ));

    //working blocks
    public static final Block MAGICON_COLLECTOR_DEVICE = registerBlocks("magicon_collector_device",
            new Block(AbstractBlock.Settings.create().strength(10f)
                    .sounds(BlockSoundGroup.WOOD).mapColor(MapColor.PURPLE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MagicalCrystal.MOD_ID, "magicon_collector_device")))
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
