package com.munchicken.lilypadonhead;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.BlockEvent;

import java.util.Random;

public class LilypadOnHeadEventHandler implements IWorldGenerator {
    private Random random = new Random();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

    }

    @SubscribeEvent
    public void addBlockDrops(BlockEvent.HarvestDropsEvent event){
        if(event.block == Blocks.waterlily)
            if (random.nextInt(5) == 0)
                event.drops.add(new ItemStack(LilypadOnHead.lilypadOnHeadHelmet));
    }

    @SubscribeEvent
    public void chatLabels(ServerChatEvent event){
        if (event.player.getCurrentArmor(3) != null){
            System.out.println("test");
            if (event.player.getCurrentArmor(3).getItem() instanceof ItemLilypadOnHeadArmor){
                event.component.appendSibling(new ChatComponentText("   says " + event.player.getDisplayName() + " while wearing a lilypad hat.").setChatStyle(new ChatStyle().setItalic(true).setColor(EnumChatFormatting.GREEN)));
            }
        }
    }

    @SubscribeEvent
    public void newHook(EntityJoinWorldEvent event) {
        if (event.entity.getClass() == EntityFishHook.class) {
            System.out.println("JoinWorldEvent on vanilla hook");
            EntityFishHook oldHook = (EntityFishHook) event.entity;
            event.setCanceled(true);
            if (!event.world.isRemote) {
                event.world.spawnEntityInWorld(new EntityLilypadOnHeadFishHook(event.world, oldHook.field_146042_b));
            }
            //event.entity.setDead();
        }
    }
}
