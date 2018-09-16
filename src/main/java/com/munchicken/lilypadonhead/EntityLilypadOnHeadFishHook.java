package com.munchicken.lilypadonhead;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.world.World;

public class EntityLilypadOnHeadFishHook extends EntityFishHook implements IEntityAdditionalSpawnData {
    public EntityPlayer angler;

    public EntityLilypadOnHeadFishHook(World p_i1766_1_, EntityPlayer p_i1766_2_) {
        super(p_i1766_1_, p_i1766_2_);
        this.angler = p_i1766_2_;
        p_i1766_2_.fishEntity = this;
        System.out.println("spawing my hook");
    }

   @Override
    public void writeSpawnData(ByteBuf buffer) {
        if (this.angler != null) {
            buffer.writeInt(this.angler.getEntityId());
            System.out.println("writing ");
            System.out.println(this.angler.getEntityId());
        }
    }

    @Override
    public void readSpawnData(ByteBuf additionalData) {
        try {
            final int anglerId = additionalData.readInt();
            this.angler = (EntityPlayer) worldObj.getEntityByID(anglerId);
            System.out.println("reading ");
            System.out.println(anglerId);
        } catch (Throwable e) {
            this.angler = null;
            System.out.println("angler null");
        }
    }
}
