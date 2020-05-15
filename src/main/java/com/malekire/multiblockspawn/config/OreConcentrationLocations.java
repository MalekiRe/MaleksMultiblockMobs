package com.malekire.multiblockspawn.config;

import java.util.ArrayList;

public class OreConcentrationLocations {
	ArrayList<OreConcentration> oreCon = new ArrayList<OreConcentration>();
	String oreName;
	public OreConcentrationLocations(String name1)
	{
		this.oreName = name1;
	}
	public void addOreConcentration(OreConcentration con)
	{
		this.oreCon.add(con);
	}
}
