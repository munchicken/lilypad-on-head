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

    @Override
     public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == LilypadOnHead.lilypadOnHeadHelmet) {
            return LilypadOnHead.MODID + ":models/armor/lilypadonheadarmor_layer_1.png";
        } else {
            System.out.println("Invalid Item");
            return null;
        }
     }

     @Override
     public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack){
         Vec3 vec = player.getLookVec();
         double x = player.posX + vec.xCoord/3;
         double y = player.posY;
         double z = player.posZ + vec.zCoord/3;

        if (player.worldObj.isRemote){
            if(itemStack.getItem() == LilypadOnHead.lilypadOnHeadHelmet){
                player.worldObj.spawnParticle("dripWater",x,y,z,0,0,0);
                //add fishing pole to inventory if not there
                if (!player.inventory.hasItem(LilypadOnHead.lilypadOnHeadFishingPole)){
                    player.inventory.addItemStackToInventory(new ItemStack(LilypadOnHead.lilypadOnHeadFishingPole,1));
                }
            }
        }

         /*// if holding fishing rod
         if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Items.fishing_rod){
             //   if rod not enchanted
             if (!player.getCurrentEquippedItem().isItemEnchanted()){
                 //     enchant it
                 player.getCurrentEquippedItem().addEnchantment(Enchantment.field_151369_A,3);
             }
         }*/



        /*if (!itemStack.isItemEnchanted()){
            itemStack.addEnchantment(Enchantment.field_151369_A,3);
            todo add the enchantment to the fishing pole
            luck of the sea too
         }*/
     }


    /*public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List list){
        ItemStack fishingHat = new ItemStack(LilypadOnHead.lilypadOnHeadHelmet,1);
        fishingHat.addEnchantment(Enchantment.field_151369_A,3);
        list.add(fishingHat);
     }*/
}
