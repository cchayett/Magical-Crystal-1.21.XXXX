package com.chayet.magicalcrystal.blocks;

import com.chayet.magicalcrystal.MagicalCrystal;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
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

    public static final Block CHAOS_LOG = registerBlocks("magical_crystal_block",
            new Block(AbstractBlock.Settings.create().strength(5f).requiresTool()
                    .sounds(BlockSoundGroup.METAL)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_block")))));


    private static void registerBlockItems(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MagicalCrystal.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    private static Block registerBlocks(String name, Block block) {
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MagicalCrystal.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        MagicalCrystal.LOGGER.info("Registering Mod Blocks for " + MagicalCrystal.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(CHAOS_LOG);
        });
    }
}
