package com.munchicken.lilypadonhead;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = LilypadOnHead.MODID, version = LilypadOnHead.VERSION)
public class LilypadOnHead {
    public static final String MODID = "munchicken_lilypadonhead";
    public static final String VERSION = "0.1";

    // armor
    public static Item lilypadOnHeadHelmet;

    //armor
    ArmorMaterial lilypadOnHeadArmor = EnumHelper.addArmorMaterial("lilypadOnHeadArmor",20, new int[] {3,7,6,3},10);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //armor
        lilypadOnHeadHelmet = new ItemLilypadOnHeadArmor(lilypadOnHeadArmor, 0, "lilypadOnHeadHelmet");
        GameRegistry.registerItem(lilypadOnHeadHelmet,"LilypadOnHeadHelmet");

        //event handler
        LilypadOnHeadEventHandler handler = new LilypadOnHeadEventHandler();
        GameRegistry.registerWorldGenerator(handler,0);
        MinecraftForge.EVENT_BUS.register(handler);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
