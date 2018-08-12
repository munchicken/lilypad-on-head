package com.munchicken.lilypadonhead;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

@Mod(modid = LilypadOnHead.MODID, version = LilypadOnHead.VERSION)
public class LilypadOnHead {
    public static final String MODID = "munchicken_lilypadonhead";
    public static final String VERSION = "0.1";

    public static Item lilypadhat;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        lilypadhat = new ItemLilyPadHat();
        GameRegistry.registerItem(lilypadhat, "LilyPadHat");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
