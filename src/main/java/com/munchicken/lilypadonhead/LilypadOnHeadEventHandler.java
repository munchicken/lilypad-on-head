package com.munchicken.lilypadonhead;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.event.world.BlockEvent;

import java.util.Random;

public class LilypadOnHeadEventHandler implements IWorldGenerator {
    Random random = new Random();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

    }

    @SubscribeEvent
    public void addBlockDrops(BlockEvent.HarvestDropsEvent event){
        if(event.block == Blocks.waterlily)
            if (random.nextInt(5) == 0)
                event.drops.add(new ItemStack(LilypadOnHead.lilypadOnHeadHelmet));
    }
}
