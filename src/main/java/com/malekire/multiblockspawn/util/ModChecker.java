package com.malekire.multiblockspawn.util;

import com.malekire.multiblockspawn.Main;

import net.minecraftforge.fml.common.Loader;

public class ModChecker {
	
	public static boolean isHarvesterLoaded;
	
	public ModChecker()
	{
		this.isHarvesterLoaded = Loader.isModLoaded("harvestersnight");
	}
	
	public static void printSuccessMessage()
	{
		if(isHarvesterLoaded)
		{
			Main.logger.info("Harvesters of the night has been loaded");
		}
	}
}
