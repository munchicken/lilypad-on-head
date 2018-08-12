package com.munchicken.lilypadonhead;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemLilyPadHat extends Item {
    public ItemLilyPadHat() {
        setUnlocalizedName(LilypadOnHead.MODID + "_" + "lilypadhat");
        setCreativeTab(CreativeTabs.tabMisc);
    }
}
