package com.chayet.magicalcrystal.datagen;

import com.chayet.magicalcrystal.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MAGICAL_CRYSTAL_BLOCK)
                .add(ModBlocks.DEEPSLATE_MAGICAL_CRYSTAL_ORE)
                .add(ModBlocks.MAGICAL_CRYSTAL_BLOCK);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.CHAOS_FENCE_GATE)
                .add(ModBlocks.CHAOS_FENCE)
                .add(ModBlocks.CHAOS_DOOR)
                .add(ModBlocks.CHAOS_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MAGICAL_CRYSTAL_BLOCK)
                .add(ModBlocks.MAGICAL_CRYSTAL_ORE)
                .add(ModBlocks.DEEPSLATE_MAGICAL_CRYSTAL_ORE);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.CHAOS_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.CHAOS_FENCE_GATE);
    }
}
