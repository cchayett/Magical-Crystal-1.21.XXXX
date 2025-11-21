package com.chayet.magicalcrystal.items;

import com.chayet.magicalcrystal.MagicalCrystal;
import com.chayet.magicalcrystal.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    public static final ArmorMaterial MAGICAL_CRYSTAL_ARMOR_MATERIAL = new ArmorMaterial(1300, Util.make(new EnumMap<>(EquipmentType.class), map ->{
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 5);
        map.put(EquipmentType.CHESTPLATE, 7);
        map.put(EquipmentType.HELMET, 4);
        map.put(EquipmentType.BODY, 6);
    }), 42, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3,2, ModTags.Items.MAGICAL_CRYSTAL_ITEM,
            Identifier.of(MagicalCrystal.MOD_ID,"magical_crystal"));

}
