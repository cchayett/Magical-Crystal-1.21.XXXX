package com.chayet.magicalcrystal.items;

import com.chayet.magicalcrystal.MagicalCrystal;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    //all items.
    public static final Item MAGICAL_CRYSTAL_ITEM = registerItem("magical_crystal", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal")))));

    public static final Item MAGICAL_CRYSTAL_INGOT = registerItem("magical_crystal_ingot", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_ingot")))));

    public static final Item MAGICAL_CRYSTAL_COAL = registerItem("magical_crystal_coal", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_coal")))));

    public static final Item MAGICAL_CRYSTAL_FRAGMENT = registerItem("magical_crystal_fragment", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_fragment")))));

    public static final Item MAGICAL_CRYSTAL_NUGGET = registerItem("magical_crystal_nugget", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_nugget")))));

    public static final Item MAGICAL_CRYSTAL_SCREEN = registerItem("magical_crystal_screen", new Item(new Item.Settings().maxCount(1)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_screen")))));



    //item register method
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MagicalCrystal.MOD_ID, name), item);
    }

    //all items register method
    public static void registerModItems() {
        MagicalCrystal.LOGGER.info("Registering Mod Items for " + MagicalCrystal.MOD_ID);
    }
}
