package com.chayet.magicalcrystal.datagen;

import com.chayet.magicalcrystal.blocks.ModBlocks;
import com.chayet.magicalcrystal.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MAGICAL_CRYSTAL_BLOCK);
        addDrop(ModBlocks.CHAOS_LOG);
        addDrop(ModBlocks.CHAOS_PLANKS);
        addDrop(ModBlocks.CHAOS_WOOD);
        addDrop(ModBlocks.STRIPPED_CHAOS_LOG);
        addDrop(ModBlocks.STRIPPED_CHAOS_WOOD);
        addDrop(ModBlocks.MAGICON_COLLECTOR_DEVICE);

        addDrop(ModBlocks.MAGICAL_CRYSTAL_ORE, oreDrops(ModBlocks.MAGICAL_CRYSTAL_ORE, ModItems.MAGICAL_CRYSTAL_FRAGMENT));
        addDrop(ModBlocks.DEEPSLATE_MAGICAL_CRYSTAL_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_MAGICAL_CRYSTAL_ORE, ModItems.MAGICAL_CRYSTAL_FRAGMENT, 2.0f, 4.0f));

        addDrop(ModBlocks.CHAOS_STAIRS);
        addDrop(ModBlocks.CHAOS_SLAB, slabDrops(ModBlocks.CHAOS_SLAB));
        addDrop(ModBlocks.CHAOS_BUTTON);
        addDrop(ModBlocks.CHAOS_PRESSURE_PLATE);
        addDrop(ModBlocks.CHAOS_FENCE);
        addDrop(ModBlocks.CHAOS_FENCE_GATE);
        addDrop(ModBlocks.CHAOS_DOOR, doorDrops(ModBlocks.CHAOS_DOOR));
        addDrop(ModBlocks.CHAOS_TRAPDOOR);


    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops){
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, (ItemEntry.builder(item)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                        .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
