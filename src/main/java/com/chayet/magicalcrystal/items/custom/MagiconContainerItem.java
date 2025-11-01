package com.chayet.magicalcrystal.items.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.List;

public class MagiconContainerItem extends Item {

    public MagiconContainerItem(Settings settings) {
        super(settings);
    }

    public static int getCharged(ItemStack itemStack){
        return itemStack.getMaxDamage() - itemStack.getDamage();
    }

    public static int reCharge(ItemStack itemStack, int amount){
        if(itemStack.getDamage() + amount < itemStack.getMaxDamage()){
            itemStack.setDamage(itemStack.getDamage() + amount);
            return amount;
        }

        int finalAmount = itemStack.getMaxDamage() - itemStack.getDamage();
        itemStack.setDamage(itemStack.getMaxDamage());
        return finalAmount;
    }

    public static int drainCharge(ItemStack itemStack, int amount){
        if(itemStack.getDamage() - amount >= 0){
            itemStack.setDamage(itemStack.getDamage() - amount);
            return 0;
        }

        int overload = amount - itemStack.getDamage();
        itemStack.setDamage(0);
        return overload;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        int charged = getCharged(stack);
        MutableText detailLine = Text.translatable("item.magicalcrystal.magicon_container.charged", charged);
        tooltip.add(detailLine);
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.magicalcrystal.magicon_container_describe"));
        } else {
            tooltip.add(Text.translatable("item.magicalcrystal.magicon_container_describe.not_shifted"));
        }
    }
}
