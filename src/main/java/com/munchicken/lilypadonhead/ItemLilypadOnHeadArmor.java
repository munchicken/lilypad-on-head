package com.munchicken.lilypadonhead;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemLilypadOnHeadArmor extends ItemArmor {
    public ItemLilypadOnHeadArmor(ArmorMaterial material, int armorType, String name) {
        super(material,0,armorType);
        setUnlocalizedName(LilypadOnHead.MODID + "_" + name);
        setTextureName(LilypadOnHead.MODID + ":" + name);
    }

     public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == LilypadOnHead.lilypadOnHeadHelmet) {
            return LilypadOnHead.MODID + ":models/armor/lilypadonheadarmor_layer_1.png";
        } else {
            System.out.println("Invalid Item");
            return null;
        }
     }
}
