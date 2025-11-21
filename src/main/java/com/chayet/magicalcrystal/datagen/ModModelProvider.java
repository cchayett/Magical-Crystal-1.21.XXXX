package com.chayet.magicalcrystal.datagen;

import com.chayet.magicalcrystal.blocks.ModBlocks;
import com.chayet.magicalcrystal.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGICAL_CRYSTAL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGICAL_CRYSTAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_MAGICAL_CRYSTAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGICON_COLLECTOR_DEVICE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHAOS_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHAOS_LOG);

        BlockStateModelGenerator.BlockTexturePool chaosWoodPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHAOS_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHAOS_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STRIPPED_CHAOS_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STRIPPED_CHAOS_LOG);

        chaosWoodPool.stairs(ModBlocks.CHAOS_STAIRS);
        chaosWoodPool.slab(ModBlocks.CHAOS_SLAB);
        chaosWoodPool.button(ModBlocks.CHAOS_BUTTON);
        chaosWoodPool.pressurePlate(ModBlocks.CHAOS_PRESSURE_PLATE);
        chaosWoodPool.fence(ModBlocks.CHAOS_FENCE);
        chaosWoodPool.fenceGate(ModBlocks.CHAOS_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.CHAOS_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CHAOS_TRAPDOOR);



    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MAGICAL_CRYSTAL_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGICAL_CRYSTAL_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGICAL_CRYSTAL_COAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGICAL_CRYSTAL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGICAL_CRYSTAL_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.MAGICAL_CRYSTAL_SCREEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIMARY_MAGICON_CONTAINER, Models.GENERATED);

        itemModelGenerator.register(ModItems.MAGICAL_CRYSTAL_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGICAL_CRYSTAL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MAGICAL_CRYSTAL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MAGICAL_CRYSTAL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MAGICAL_CRYSTAL_MINING_HAMMER, Models.HANDHELD);
    }
}
