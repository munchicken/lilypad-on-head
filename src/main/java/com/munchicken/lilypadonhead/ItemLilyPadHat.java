package com.munchicken.lilypadonhead;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

public class ItemLilyPadHat extends Item {

    private String name = "lilypadhat";

    public ItemLilyPadHat() {
        setUnlocalizedName(LilypadOnHead.MODID + "_" + name);
        setTextureName(LilypadOnHead.MODID + ":" + name);
        setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) {
        return armorType == 0;  //head
    }
}
