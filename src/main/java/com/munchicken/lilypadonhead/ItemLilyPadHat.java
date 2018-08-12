package com.munchicken.lilypadonhead;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemLilyPadHat extends Item {

    private String name = "lilypadhat";

    public ItemLilyPadHat() {
        setUnlocalizedName(LilypadOnHead.MODID + "_" + name);
        setTextureName(LilypadOnHead.MODID + ":" + name);
        setCreativeTab(CreativeTabs.tabMisc);
    }
}
