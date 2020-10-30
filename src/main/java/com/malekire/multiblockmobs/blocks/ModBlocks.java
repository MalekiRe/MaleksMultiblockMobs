package com.malekire.multiblockmobs.blocks;

import com.malekire.multiblockmobs.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MOD_ID)
public class ModBlocks {
	public static SoulChassis soulChassis = new SoulChassis();
	
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
	  event.getRegistry().registerAll(soulChassis);
	  //GameRegistry.registerTileEntity(tileEntityData, "multiblockmobs:soul_chassis");
	  
	  
	}
	/*
	public static void register(IForgeRegistry<Block> registry) {
		
		
		GameRegistry.registerTileEntity(TileEntityData.getTileEntityClass(), TileEntityData.getRegistryName().toString());
	}*/
	
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		ItemBlock itemBlock = new ItemBlock(soulChassis);
		itemBlock.setRegistryName(soulChassis.getRegistryName());
		itemBlock.setUnlocalizedName(soulChassis.getUnlocalizedName());
	  event.getRegistry().registerAll(itemBlock);
	}
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
	  registerRender(Item.getItemFromBlock(soulChassis));
	  //registerRender(soulChassis);
	}

	private static void registerRender(Block block)
	{
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		
	}
	
	public static void registerRender(Item item) {
		  ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
		}
	
}
