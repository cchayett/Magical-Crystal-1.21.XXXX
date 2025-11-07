package com.chayet.magicalcrystal.items;

import com.chayet.magicalcrystal.MagicalCrystal;
import com.chayet.magicalcrystal.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    //first group for items
    public static final ItemGroup MAGICAL_CRYSTAL_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_item_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MAGICAL_CRYSTAL_ITEM))
                    .displayName(Text.translatable("itemGroup.magicalcrystal.magical_crystal_item_group"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.MAGICAL_CRYSTAL_ITEM);

                        entries.add(ModItems.MAGICAL_CRYSTAL_INGOT);
                        entries.add(ModItems.MAGICAL_CRYSTAL_COAL);
                        entries.add(ModItems.MAGICAL_CRYSTAL_FRAGMENT);
                        entries.add(ModItems.MAGICAL_CRYSTAL_NUGGET);

                        entries.add(ModItems.MAGICAL_CRYSTAL_SCREEN);
                        entries.add(ModItems.PRIMARY_MAGICON_CONTAINER);

                        entries.add(ModItems.MAGICAL_CRYSTAL_AXE);
                        entries.add(ModItems.MAGICAL_CRYSTAL_PICKAXE);
                        entries.add(ModItems.MAGICAL_CRYSTAL_SHOVEL);
                    })).build());

    //second group for blocks
    public static final ItemGroup MAGICAL_CRYSTAL_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_block_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.MAGICAL_CRYSTAL_BLOCK))
                    .displayName(Text.translatable("itemGroup.magicalcrystal.magical_crystal_block_group"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.MAGICAL_CRYSTAL_BLOCK);
                        entries.add(ModBlocks.MAGICAL_CRYSTAL_ORE);
                        entries.add(ModBlocks.DEEPSLATE_MAGICAL_CRYSTAL_ORE);

                        entries.add(ModBlocks.CHAOS_LOG);
                        entries.add(ModBlocks.CHAOS_LEAVES);
                        entries.add(ModBlocks.CHAOS_PLANKS);
                        entries.add(ModBlocks.CHAOS_WOOD);
                        entries.add(ModBlocks.STRIPPED_CHAOS_LOG);
                        entries.add(ModBlocks.STRIPPED_CHAOS_WOOD);

                        entries.add(ModBlocks.CHAOS_STAIRS);
                        entries.add(ModBlocks.CHAOS_SLAB);
                        entries.add(ModBlocks.CHAOS_BUTTON);
                        entries.add(ModBlocks.CHAOS_PRESSURE_PLATE);
                        entries.add(ModBlocks.CHAOS_FENCE);
                        entries.add(ModBlocks.CHAOS_FENCE_GATE);
                        entries.add(ModBlocks.CHAOS_DOOR);
                        entries.add(ModBlocks.CHAOS_TRAPDOOR);

                        entries.add(ModBlocks.MAGICON_COLLECTOR_DEVICE);
                    })).build());

    public static void registerItemGroups() {
        MagicalCrystal.LOGGER.info("Registering Item Groups for Magical Crystal");
    }
}
