package events;


import java.util.Random;
import java.util.logging.Logger;

import com.malekire.multiblockspawn.Main;
import com.malekire.multiblockspawn.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import static com.malekire.multiblockspawn.util.TheOreNames.OreNames.OreNames;
import static com.malekire.multiblockspawn.config.ConfigLoader.*;
public class OreGenEventHandler {
	 
	@SubscribeEvent
	    public void onOreGenMinable(OreGenEvent.GenerateMinable event) {
		
		/*
		switch (event.getType()) {
		case COAL:
            if (disableOres[0]) event.setResult(Event.Result.DENY);
            break;
        case IRON:
            if (disableOres[1]) event.setResult(Event.Result.DENY);
            break;
        case GOLD:
            if (disableOres[2]) event.setResult(Event.Result.DENY);
            break;
        case DIAMOND:
            if (disableOres[3]) event.setResult(Event.Result.DENY);
            break;
        case REDSTONE:
            if (disableOres[4]) event.setResult(Event.Result.DENY);
            break;
        case LAPIS:
            if (disableOres[5]) event.setResult(Event.Result.DENY);
            break;
         case EMERALD:
            if (disableOres[6]) event.setResult(Event.Result.DENY);
            break;
        case DIRT:
            if (disableOres[7]) event.setResult(Event.Result.DENY);
            break;
        case GRAVEL:
            if (disableOres[8]) event.setResult(Event.Result.DENY);
            break;
        case ANDESITE:
            if (disableOres[9]) event.setResult(Event.Result.DENY);
            break;
        case GRANITE:
            if (disableOres[10]) event.setResult(Event.Result.DENY);
            break;
        case DIORITE:
            if (disableOres[11]) event.setResult(Event.Result.DENY);
            break;
        default:
    }*/
		event.setResult(Event.Result.DENY);
		/*
		if(event.getType()==EventType.COAL)
		{
			
			Random rand = event.getRand();
			BlockPos pos = event.getPos();
			World world = event.getWorld();
			if(event.getWorld().getBiome(pos).getTemperature(pos) <= 0.2F)
			{
				Main.logger.info("DSFJDSFJKSD");
			 Block[] blocks = {Blocks.COAL_ORE, Blocks.IRON_ORE, Blocks.GOLD_ORE, Blocks.DIAMOND_ORE, Blocks.REDSTONE_ORE, Blocks.EMERALD_ORE, Blocks.DIRT, Blocks.GRAVEL, Blocks.STONE.getStateFromMeta(1).getBlock(), Blocks.STONE.getStateFromMeta(3).getBlock(), Blocks.STONE.getStateFromMeta(5).getBlock()};
			 
				 int ore = 0;
				 //Main.logger.info(OreNames[ore]);
				 
						 for (int i = 0; i < spawnRates[ore]*30; i++) {
			            int veinYLevel = (int) (Math.random() * (maxVeinLevels[ore] - minVeinLevels[ore])) + minVeinLevels[ore]*30;
			            int veinSize = (int) (Math.random() * (maxVeinSizes[ore] -minVeinSizes[ore]) + minVeinSizes[i]*30);
			            Main.logger.info("dasfasd");
			            int xCoord = pos.getX() + rand.nextInt(16);
			            int zCoord = pos.getZ() + rand.nextInt(16);
			            //System.out.println("dadfs");
			            Main.logger.info("YEEEEEEEEEESSSSSSSSSS");
			            new WorldGenMinable(blocks[ore].getDefaultState(), veinSize).generate(world, rand, new BlockPos(xCoord, veinYLevel, zCoord));
		        	
				 
			 }
			}
			else
			{
				event.setResult(Event.Result.DENY);
			}
		}*/
		 /*
			if(event.getType() == EventType.COAL)
			{
				event.setResult(Event.Result.DENY);
                System.out.println("coal");
			}*/
		/*if(!event.getWorld().getBiome(event.getPos()).equals(Biome.getBiome(4)))
    	{
        event.setResult(Event.Result.DENY);
    	}*/
		/*
	        switch (event.getType()) {
	            case COAL:
	            	if(!event.getWorld().getBiome(event.getPos()).equals(Biome.getBiome(4)))
	            	{
	                event.setResult(Event.Result.DENY);
	            	}
	                break;
	            default:
	            
	        }*/
	 }
}
