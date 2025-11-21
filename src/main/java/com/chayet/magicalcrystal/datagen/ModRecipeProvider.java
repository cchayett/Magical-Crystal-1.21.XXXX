package com.chayet.magicalcrystal.datagen;

import com.chayet.magicalcrystal.MagicalCrystal;
import com.chayet.magicalcrystal.blocks.ModBlocks;
import com.chayet.magicalcrystal.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> MAGICAL_CRYSTAL_FRAGMENT_SMELTABLES = List.of(ModBlocks.MAGICAL_CRYSTAL_ORE,
                        ModBlocks.DEEPSLATE_MAGICAL_CRYSTAL_ORE);

                //smelting and blasting ores
                offerSmelting(MAGICAL_CRYSTAL_FRAGMENT_SMELTABLES, RecipeCategory.MISC, ModItems.MAGICAL_CRYSTAL_FRAGMENT, 0.5f, 800, "magical_crystal_fragment");
                offerBlasting(MAGICAL_CRYSTAL_FRAGMENT_SMELTABLES, RecipeCategory.MISC, ModItems.MAGICAL_CRYSTAL_FRAGMENT, 0.5f, 400, "magical_crystal_fragment");

                //ingots and blocks transform
                createShaped(RecipeCategory.MISC, ModBlocks.MAGICAL_CRYSTAL_BLOCK)
                        .pattern("iii")
                        .pattern("iii")
                        .pattern("iii")
                        .input('i', ModItems.MAGICAL_CRYSTAL_INGOT)
                        .criterion(hasItem(ModItems.MAGICAL_CRYSTAL_INGOT), conditionsFromItem(ModItems.MAGICAL_CRYSTAL_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_block_from_ingot")));
                createShapeless(RecipeCategory.MISC, ModItems.MAGICAL_CRYSTAL_INGOT, 9)
                        .input(ModBlocks.MAGICAL_CRYSTAL_BLOCK)
                        .criterion(hasItem(ModBlocks.MAGICAL_CRYSTAL_BLOCK), conditionsFromItem(ModBlocks.MAGICAL_CRYSTAL_BLOCK))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_ingot_from_block")));

                //nuggets and ingots transform
                createShaped(RecipeCategory.MISC, ModItems.MAGICAL_CRYSTAL_INGOT)
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .input('n', ModItems.MAGICAL_CRYSTAL_NUGGET)
                        .criterion(hasItem(ModItems.MAGICAL_CRYSTAL_NUGGET), conditionsFromItem(ModItems.MAGICAL_CRYSTAL_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_ingot_from_nugget")));
                createShapeless(RecipeCategory.MISC, ModItems.MAGICAL_CRYSTAL_NUGGET, 9)
                        .input(ModItems.MAGICAL_CRYSTAL_INGOT)
                        .criterion(hasItem(ModItems.MAGICAL_CRYSTAL_INGOT), conditionsFromItem(ModItems.MAGICAL_CRYSTAL_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_nugget_from_ingot")));

                //to magical crystal item
                createShaped(RecipeCategory.MISC, ModItems.MAGICAL_CRYSTAL_ITEM)
                        .pattern("fff")
                        .pattern("faf")
                        .pattern("fff")
                        .input('f', ModItems.MAGICAL_CRYSTAL_FRAGMENT)
                        .input('a', Items.AMETHYST_SHARD)
                        .criterion(hasItem(ModItems.MAGICAL_CRYSTAL_FRAGMENT), conditionsFromItem(ModItems.MAGICAL_CRYSTAL_FRAGMENT))
                        .offerTo(exporter);

                //to chaos plank
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHAOS_PLANKS, 4)
                        .input(ModBlocks.CHAOS_LOG)
                        .criterion(hasItem(ModBlocks.CHAOS_LOG), conditionsFromItem(ModBlocks.CHAOS_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(MagicalCrystal.MOD_ID, "chaos_plank_from_log")));
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHAOS_PLANKS, 4)
                        .input(ModBlocks.CHAOS_WOOD)
                        .criterion(hasItem(ModBlocks.CHAOS_WOOD), conditionsFromItem(ModBlocks.CHAOS_WOOD))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(MagicalCrystal.MOD_ID, "chaos_plank_from_wood")));
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHAOS_PLANKS, 4)
                        .input(ModBlocks.STRIPPED_CHAOS_LOG)
                        .criterion(hasItem(ModBlocks.STRIPPED_CHAOS_LOG), conditionsFromItem(ModBlocks.STRIPPED_CHAOS_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(MagicalCrystal.MOD_ID, "chaos_plank_from_stripped_log")));
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHAOS_PLANKS, 4)
                        .input(ModBlocks.STRIPPED_CHAOS_WOOD)
                        .criterion(hasItem(ModBlocks.STRIPPED_CHAOS_WOOD), conditionsFromItem(ModBlocks.STRIPPED_CHAOS_WOOD))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(MagicalCrystal.MOD_ID, "chaos_plank_from_stripped_wood")));

                //to different woods from logs
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHAOS_WOOD, 3)
                        .input(ModBlocks.CHAOS_LOG, 4)
                        .criterion(hasItem(ModBlocks.CHAOS_LOG), conditionsFromItem(ModBlocks.CHAOS_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(MagicalCrystal.MOD_ID, "chaos_wood_from_log")));
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_CHAOS_WOOD, 3)
                        .input(ModBlocks.STRIPPED_CHAOS_LOG, 4)
                        .criterion(hasItem(ModBlocks.STRIPPED_CHAOS_LOG), conditionsFromItem(ModBlocks.STRIPPED_CHAOS_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(MagicalCrystal.MOD_ID, "stripped_chaos_wood_from_log")));

                //for chaos trees series block

                //waiting

                //for magical crystal tools
                createShaped(RecipeCategory.MISC, ModItems.MAGICAL_CRYSTAL_STICK)
                        .pattern("c")
                        .pattern("c")
                        .input('c', ModItems.MAGICAL_CRYSTAL_INGOT)
                        .criterion(hasItem(ModItems.MAGICAL_CRYSTAL_INGOT), conditionsFromItem(ModItems.MAGICAL_CRYSTAL_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.MAGICAL_CRYSTAL_PICKAXE)
                        .pattern("mmm")
                        .pattern(" s ")
                        .pattern(" s ")
                        .input('m', ModItems.MAGICAL_CRYSTAL_INGOT)
                        .input('s', ModItems.MAGICAL_CRYSTAL_STICK)
                        .criterion(hasItem(ModItems.MAGICAL_CRYSTAL_FRAGMENT), conditionsFromItem(ModItems.MAGICAL_CRYSTAL_FRAGMENT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.MAGICAL_CRYSTAL_AXE)
                        .pattern("mm ")
                        .pattern("ms ")
                        .pattern(" s ")
                        .input('m', ModItems.MAGICAL_CRYSTAL_INGOT)
                        .input('s', ModItems.MAGICAL_CRYSTAL_STICK)
                        .criterion(hasItem(ModItems.MAGICAL_CRYSTAL_FRAGMENT), conditionsFromItem(ModItems.MAGICAL_CRYSTAL_FRAGMENT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.MAGICAL_CRYSTAL_SHOVEL)
                        .pattern(" m ")
                        .pattern(" s ")
                        .pattern(" s ")
                        .input('m', ModItems.MAGICAL_CRYSTAL_INGOT)
                        .input('s', ModItems.MAGICAL_CRYSTAL_STICK)
                        .criterion(hasItem(ModItems.MAGICAL_CRYSTAL_FRAGMENT), conditionsFromItem(ModItems.MAGICAL_CRYSTAL_FRAGMENT))
                        .offerTo(exporter);

            }
        };
    }

    @Override
    public String getName() {
        return "Magical Crystal Series recipes";
    }
}
