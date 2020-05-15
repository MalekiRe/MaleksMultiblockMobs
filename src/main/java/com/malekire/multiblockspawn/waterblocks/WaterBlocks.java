package com.malekire.multiblockspawn.waterblocks;


import com.malekire.multiblockspawn.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid=Reference.MOD_ID)
public class WaterBlocks {
	//public static SoulChassis soulChassis = new SoulChassis();
	public static WaterBase waterBase = new WaterBase();
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
	 // event.getRegistry().registerAll(soulChassis);
	  //event.getRegistry().registerAll(waterBase);
	  
	  
	}
	
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
	  //event.getRegistry().registerAll(new ItemBlock(soulChassis).setRegistryName(soulChassis.getRegistryName()));
		//event.getRegistry().registerAll(new ItemBlock(waterBase).setRegistryName(waterBase.getRegistryName()));
	}
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
	 // registerRender(Item.getItemFromBlock(soulChassis));
		//registerRender(Item.getItemFromBlock(waterBase));
	  
	}

	private static void registerRender(Block block)
	{
		
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		
	}
	
	public static void registerRender(Item item) {
		 // ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
		}
	
}
