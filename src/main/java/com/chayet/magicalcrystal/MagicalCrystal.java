package com.chayet.magicalcrystal;

import com.chayet.magicalcrystal.blocks.ModBlocks;
import com.chayet.magicalcrystal.items.ModItemGroups;
import com.chayet.magicalcrystal.items.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagicalCrystal implements ModInitializer {
	public static final String MOD_ID = "magicalcrystal";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();//register itemGroups

		ModItems.registerModItems();//register items
		ModBlocks.registerModBlocks();//register blocks

		FuelRegistryEvents.BUILD.register(((builder, context) -> {
			builder.add(ModItems.MAGICAL_CRYSTAL_COAL, 6400);
		}));//set fuels

	}
}