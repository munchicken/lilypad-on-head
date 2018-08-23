package com.munchicken.lilypadonhead;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemLilypadOnHeadFishingPole extends ItemFishingRod {
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;
    private String name;
    private static final String __OBFID = "CL_00000034";

    public ItemLilypadOnHeadFishingPole(String name){
        super();
        setUnlocalizedName(LilypadOnHead.MODID + "_" + name);
        //don't show in creative tabs
        setCreativeTab(null);
        this.name = name;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        if (p_77659_3_.fishEntity != null)
        {
            int i = p_77659_3_.fishEntity.func_146034_e();
            p_77659_1_.damageItem(i, p_77659_3_);
            p_77659_3_.swingItem();
        }
        else
        {
            p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!p_77659_2_.isRemote)
            {
                p_77659_2_.spawnEntityInWorld(new EntityLilypadOnHeadHook(p_77659_2_, p_77659_3_));
            }

            p_77659_3_.swingItem();
        }

        return p_77659_1_;
    }

    public boolean isItemTool(ItemStack p_77616_1_)
    {
        return super.isItemTool(p_77616_1_);
    }

    public int getItemEnchantability()
    {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iIconRegister){
        this.itemIcon = iIconRegister.registerIcon(LilypadOnHead.MODID + ":" + this.name + "_uncast");
        this.theIcon = iIconRegister.registerIcon(LilypadOnHead.MODID + ":" + this.name + "_cast");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon func_94597_g(){
        return this.theIcon;
    }
}
