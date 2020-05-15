package com.malekire.multiblockspawn.waterblocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class WaterBase extends Block{
	public WaterBase()
	{
		super(Material.SNOW);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setUnlocalizedName("water_level_one");
        this.setRegistryName("water_level_one");
	}
	public WaterBase(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setUnlocalizedName("water_level_one");
        this.setRegistryName("water_level_one");
	}

}
