package com.chayet.magicalcrystal.datagen;

import com.chayet.magicalcrystal.items.ModItems;
import com.chayet.magicalcrystal.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.MAGICAL_CRYSTAL_ITEM)
                .add(ModItems.MAGICAL_CRYSTAL_ITEM);

        getOrCreateTagBuilder(ModTags.Items.MAGICAL_CRYSTAL_TOOL);
    }
}
