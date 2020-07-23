package com.malekire.multiblockmobs.particle;

import com.malekire.multiblockmobs.util.Reference;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
@Mod.EventBusSubscriber(modid=Reference.MOD_ID)
public class DemTextureHandler 
{
public static final DemTextureHandler textures = new DemTextureHandler();

private DemTextureHandler(){}

public static TextureAtlasSprite su;

@SubscribeEvent
public void onTextureStitch(TextureStitchEvent.Pre event)
{
	ResourceLocation resource = new ResourceLocation("multiblockmobs:particles/soul_particle");

	TextureAtlasSprite su = event.getMap().registerSprite(resource);
	System.out.println("Debug: "+su.toString());
	System.out.println("Debug: "+event.getMap().getAtlasSprite(resource.toString()));
}
}