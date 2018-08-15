package com.munchicken.lilypadonhead;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

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

     public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack){
         Vec3 vec = player.getLookVec();
         double x = player.posX + vec.xCoord/3;
         double y = player.posY;
         double z = player.posZ + vec.zCoord/3;

        if (player.worldObj.isRemote){
            if(itemStack.getItem() == LilypadOnHead.lilypadOnHeadHelmet){
                player.worldObj.spawnParticle("dripWater",x,y,z,0,0,0);
            }
        }
     }
}
