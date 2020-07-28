package com.malekire.multiblockmobs;

import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.malekire.multiblockmobs.config.ModLocator;
import com.malekire.multiblockmobs.proxy.CommonProxy;
import com.malekire.multiblockmobs.util.CommandContainer;
import com.malekire.multiblockmobs.util.ModChecker;
import com.malekire.multiblockmobs.util.Reference;
import com.malekire.multiblockmobs.util.SoundEventContainer;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraft.block.properties.*;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
@Mod.EventBusSubscriber(modid=Reference.MOD_ID)
public class Main {
	private static String file = "/multiblockmobs.mbm";
	
	public static Vector<Vector<BlockPattern>> blockPatternContainer = new Vector<Vector<BlockPattern>>();
	public static Vector<BlockPattern> blockPatterns = new Vector<BlockPattern>();
	
	public static Vector<SoundEventContainer> soundEffects = new Vector<SoundEventContainer>();
	public static Vector<SoundEventContainer> music = new Vector<SoundEventContainer>();
	
	public static Vector<SoundEvent> soundEffectEvents = new Vector<SoundEvent>();
	public static Vector<SoundEvent> musicEvents = new Vector<SoundEvent>();
	
	public static Vector<ModLocator> entities = new Vector<ModLocator>();
	
	public static Vector<CommandContainer> commands = new Vector<CommandContainer>();
	public static SoundEvent harvesterLaugh;
	static String filePath;
	public static final Logger logger = (Logger) LogManager.getFormatterLogger(Reference.MOD_ID);
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		ModChecker modChecker = new ModChecker();
		modChecker.printSuccessMessage();
		//MinecraftForge.ORE_GEN_BUS.register(new OreGenEventHandler());
		//GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
		
		
		//REGISTRY.register(100, location, new SoundEvent(location));
		//com.malekire.multiblockmobs.mbe20_tileentity_data.StartupClientOnly.preInitCommon();
	}
	public static final RegistryNamespaced<ResourceLocation, SoundEvent> REGISTRY = net.minecraftforge.registries.GameData.getWrapper(SoundEvent.class);
	@EventHandler
	public static void init(FMLInitializationEvent event) throws FileNotFoundException
	{
		filePath = Loader.instance().getConfigDir().toString();
		//System.out.println(filePath.substring(0, filePath.lastIndexOf("config")));
		try {
		      File myObj = new File(Loader.instance().getConfigDir()+file);
		      if (myObj.createNewFile()) {
		       // System.out.println("File created: " + myObj.getName());
		      } else {
		       // System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		     // System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		File text = new File(Loader.instance().getConfigDir()+file);
	     
        //Creating Scanner instnace to read File in Java
        Scanner scnr = new Scanner(text);
        
        BlockPattern patterntest2;
        //Reading each line of file using Scanner class
        int lineNumber = 1;
        int x = 0;
        int y = 0;
        int z = 0;
        Vector<ModLocator> blocks = new Vector<ModLocator>();  
        boolean init = false;
        boolean loc = false;
        String modid;
        String thing;
        String character;
        
        Vector<Vector<String>> blockLocations = new Vector<Vector<String>>();
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            	if(line.contains("customCommand"))
            	{
            		commands.add(new CommandContainer(entities.size(), line.substring(line.indexOf('\"')+1, line.lastIndexOf('\"'))));
            		
            		
            	}
            	if(line.contains("soundEffectBoolean"))
            	{
            		SoundEventContainer container = new SoundEventContainer();
            		container.Active =  Boolean.valueOf(line.substring(line.indexOf('\"')-1, line.lastIndexOf('\"')));
            		lineNumber++;
            		line = scnr.nextLine();
            		container.soundName = line.substring(line.indexOf('\"')-1, line.lastIndexOf('\"'));
            		soundEffects.add(container);
            	}
            	if(line.contains("musicBoolean"))
            	{
            		SoundEventContainer container = new SoundEventContainer();
            		container.Active =  Boolean.valueOf(line.substring(line.indexOf('\"')-1, line.lastIndexOf('\"')));
            		lineNumber++;
            		line = scnr.nextLine();
            		container.soundName = line.substring(line.indexOf('\"')-1, line.lastIndexOf('\"'));
            		music.add(container);
            	}
            	if(line.contains("Dimensions"))
	            {
	            	x = Character.getNumericValue(line.charAt(line.indexOf("x = ")+4));
	            	y = Character.getNumericValue(line.charAt(line.indexOf("y = ")+4));
	            	z = Character.getNumericValue(line.charAt(line.indexOf("z = ")+4));
	            }
            	if(line.contains("!startInit"))
            	{
            		init = true;
            	}
            	else if(line.contains("!endInit"))
            	{
            		init = false;
            	}
            	else
            	{
            		if(init)
            		{
            			while(!line.contains("!endInit"))
            			{
            			modid = line.substring(0, line.indexOf(':'));
            			thing = line.substring(line.indexOf(':')+1, line.indexOf(" "));
            			character = line.substring(line.indexOf('\"')+1, line.lastIndexOf('\"'));
            			//System.out.println(modid);
            		//	System.out.println(thing);
            		//	System.out.println(character);
            			blocks.add(new ModLocator(modid, thing, character));
            			lineNumber++;
            			line = scnr.nextLine();
            			init = false;
            			}
            		}
            	}
            	if(line.contains("!startLoc"))
            	{
            		loc = true;
            	}
            	else if(line.contains("!stopLoc"))
            	{
            		loc = false;
            	}
            	else
            	{
            		if(loc)
            		{
            			int i3 = 1;
            			while(i3 <= z)
            			{
            				Vector<String> blockTemp = new Vector<String>();
	            			int i2 = 1;
	            			while(i2 <= y)
	            			{
		            			if(line.contains("["))
		            			{
		            				
		            				blockTemp.add(line.substring(line.indexOf('\"')+1, line.indexOf('\"')+x+1));
		            				i2++;
		            			}
		            			
		            			line = scnr.nextLine();
		            			lineNumber++;
	            			}
	            			
	            			blockLocations.add((Vector<String>)blockTemp.clone());
	            			
	            			blockTemp.clear();
	            			//System.out.println(blockLocations.get(i3-1).get(0));
	            			//System.out.println(blockLocations.get(i3-1).get(1));
	            			//System.out.println(blockLocations.get(i3-1).get(2));
	            			i3++;
            			}
            			loc = false;
            		}
            	}
            //System.out.println(line);
            	if(line.contains("!entityStart"))
            	{
            		lineNumber++;
            		line = scnr.nextLine();
            		entities.add(new ModLocator(line.substring(line.indexOf('\"')+1, line.indexOf(':')), line.substring(line.indexOf(':')+1, line.lastIndexOf('\"')), ""));
            		//System.out.println(entities.get(0).modID);
            		//System.out.println(entities.get(0).thing);
            	}
            lineNumber++;
            if(line.contains("!endMultiblockMob"))
            {
            	String[][] tempBlockLoc = new String[z][y];
                for(int i = 0; i < blockLocations.size(); i++)
                {
                	
                	for(int i2 = 0; i2 < blockLocations.get(i).size(); i2++)
                	{
                		//System.out.println(blockLocations.get(i).get(i2));
                		
                		tempBlockLoc[i][i2] = blockLocations.get(i).get(i2);
                	}
                	//System.out.println("");
                	
                	FactoryBlockPattern patterntest = FactoryBlockPattern.start().aisle(tempBlockLoc[i]);
                	for(int i3 = 0; i3 < blocks.size(); i3++)
                    {
                    	patterntest.where(blocks.get(i3).character.charAt(0), getBlock(blocks.get(i3).modID, blocks.get(i3).thing));
                    }
                	blockPatterns.add(patterntest.build());
                	patterntest = null;
                }
                blockPatternContainer.add((Vector<BlockPattern>) blockPatterns.clone());
                blockPatterns.clear();
                blockLocations.clear();
                blocks.clear();
            }
        }
        scnr.close();
        
        
        
    	
	}
	public static Predicate<BlockWorldState> getBlock(String modid, String block)
	{
		//return BlockWorldState.hasState(BlockStateMatcher.forBlock(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(modid, block))));
		
			return BlockWorldState.hasState(BlockStateMatcher.forBlock(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(modid, block))));
		
	}
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
		for(CommandContainer s : commands)
			{
				System.out.println(s.place);
				System.out.println(s.command);
			}
		//MinecraftForge.EVENT_BUS.register(new OreGenEventHandler());
	}
	@SubscribeEvent
	public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
		IForgeRegistry<SoundEvent> reg = event.getRegistry();
		for(int i = 0; i < soundEffects.size(); i++)
		{
			if(soundEffects.get(i).Active)
			{
				soundEffects.get(i).soundEvent = (registerSoundEffect(reg, soundEffects.get(i).soundName));
			}
		}
		for(int i = 0; i < music.size(); i++)
		{
			if(music.get(i).Active)
			{
				music.get(i).soundEvent = (registerSoundEffect(reg, music.get(i).soundName));
			}
		}
		
		
	}
	public static SoundEvent registerSoundEffect(IForgeRegistry<SoundEvent> reg, String name) {
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent event = new SoundEvent(location).setRegistryName(filePath+"/Malek's Multiblock Mobs Resources"+name);
		//soundEffectPath.add(filePath+"/Malek's Multiblock Mobs Resources"+name);
		
		reg.register(event);

		return event;
	}
	public static SoundEvent registerMusic(IForgeRegistry<SoundEvent> reg, String name) {
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent event = new SoundEvent(location).setRegistryName(filePath+"/Malek's Multiblock Mobs Resources"+name);
		reg.register(event);

		return event;
	}
	//@SubscribeEvent
	//public static void registerTileEntity()
	//{
		
	//}

}
