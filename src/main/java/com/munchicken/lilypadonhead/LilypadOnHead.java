package com.munchicken.lilypadonhead;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Blocks;

@Mod(modid = LilypadOnHead.MODID, version = LilypadOnHead.VERSION)
public class LilypadOnHead {
    public static final String MODID = "munchicken_lilypadonhead";
    public static final String VERSION = "0.1";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //forge example mod line below
        System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
    }
}
