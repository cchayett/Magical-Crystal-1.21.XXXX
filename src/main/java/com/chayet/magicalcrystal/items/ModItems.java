package com.chayet.magicalcrystal.items;

import com.chayet.magicalcrystal.MagicalCrystal;
import com.chayet.magicalcrystal.items.custom.MagiconContainerItem;
import com.chayet.magicalcrystal.items.custom.MiningHammerItem;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
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

    public static final Item MAGICAL_CRYSTAL_STICK = registerItem("magical_crystal_stick", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_stick")))));

    //tool items
    //magical crystal tools
    public static final Item MAGICAL_CRYSTAL_PICKAXE = registerItem("magical_crystal_pickaxe",
            new PickaxeItem(ModToolMaterials.MAGICAL_CRYSTAL, 1, -2.8f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_pickaxe")))));

    public static final Item MAGICAL_CRYSTAL_AXE = registerItem("magical_crystal_axe",
            new AxeItem(ModToolMaterials.MAGICAL_CRYSTAL, 6, -3.0f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_axe")))));

    public static final Item MAGICAL_CRYSTAL_SHOVEL = registerItem("magical_crystal_shovel",
            new ShovelItem(ModToolMaterials.MAGICAL_CRYSTAL, 1.5f, -3.0f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_shovel")))));

    public static final Item MAGICAL_CRYSTAL_MINING_HAMMER = registerItem("magical_crystal_mining_hammer",
            new MiningHammerItem(ModToolMaterials.MAGICAL_CRYSTAL, 9, -3.4f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_mining_hammer")))));

    //armor items
    public static final Item MAGICAL_CRYSTAL_HELMET = registerItem("magical_crystal_helmet",
            new ArmorItem(ModArmorMaterials.MAGICAL_CRYSTAL_ARMOR_MATERIAL, EquipmentType.HELMET, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_helmet")))));
    public static final Item MAGICAL_CRYSTAL_CHESTPLATE = registerItem("magical_crystal_chestplate",
            new ArmorItem(ModArmorMaterials.MAGICAL_CRYSTAL_ARMOR_MATERIAL, EquipmentType.CHESTPLATE, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_chestplate")))));
    public static final Item MAGICAL_CRYSTAL_LEGGINGS = registerItem("magical_crystal_leggings",
            new ArmorItem(ModArmorMaterials.MAGICAL_CRYSTAL_ARMOR_MATERIAL, EquipmentType.LEGGINGS, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_leggings")))));
    public static final Item MAGICAL_CRYSTAL_BOOTS = registerItem("magical_crystal_boots",
            new ArmorItem(ModArmorMaterials.MAGICAL_CRYSTAL_ARMOR_MATERIAL, EquipmentType.BOOTS, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "magical_crystal_boots")))));

    //custom items.
    public static final Item PRIMARY_MAGICON_CONTAINER = registerItem("primary_magicon_container", new MagiconContainerItem(new Item.Settings().maxDamage(1000)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicalCrystal.MOD_ID, "primary_magicon_container")))));

    //item register method
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MagicalCrystal.MOD_ID, name), item);
    }

    //all items register method
    public static void registerModItems() {
        MagicalCrystal.LOGGER.info("Registering Mod Items for " + MagicalCrystal.MOD_ID);
    }
}
