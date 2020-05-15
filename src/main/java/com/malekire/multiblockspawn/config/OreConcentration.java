package com.malekire.multiblockspawn.config;

public class OreConcentration {
	int minVeinSize;
	int maxVeinSize;
	int minLevel;
	int maxLevel;
	int spawnRate;
	float tempMin;
	float tempMax;
	public OreConcentration(int minVeinSize1, int maxVeinSize1, int minLevel1, int maxLevel1, int spawnRate1)
	{
		this.minVeinSize = minVeinSize1;
		this.maxVeinSize = maxVeinSize1;
		this.minLevel = minLevel1;
		this.maxLevel = maxLevel1;
		this.spawnRate = spawnRate1;
	}
	public OreConcentration(int minVeinSize1, int maxVeinSize1, int minLevel1, int maxLevel1, int spawnRate1, float tempMin1, float tempMax1)
	{
		this(minVeinSize1, maxVeinSize1, minLevel1, maxLevel1, spawnRate1);
		this.tempMin = tempMin1;
		this.tempMax = tempMax1;
	}
}
