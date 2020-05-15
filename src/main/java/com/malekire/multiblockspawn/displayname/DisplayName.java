package com.malekire.multiblockspawn.displayname;

import net.java.games.input.Event;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.malekire.multiblockspawn.Main;
import com.malekire.multiblockspawn.partical.EobEnumParticleTypes;
import com.malekire.multiblockspawn.partical.ParticleSpawner;
import com.malekire.multiblockspawn.util.Reference;
public class DisplayName {

	
	RenderManager manager = Minecraft.getMinecraft().getRenderManager();

	 
	//public static final ArmorMaterial FLOWERS = EnumHelper.addArmorMaterial("flower_crown", Reference.MOD_ID + ":spirit_image", 0, new int[]{0, 0, 0, 0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0);
    @SubscribeEvent

    public void preRenderPlayer(RenderLivingEvent.Pre event)

    {

        if (!(event.getEntity() instanceof EntityPlayer)) return;

        //event.setCanceled(true);

 

        //System.out.println("I think it works");
        //world.spawnParticle(EnumParticleTypes.FLAME, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), 0.0D, 0.0D, 0.0D, new int[0]);
       

    }
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void handleCropRightClick(PlayerInteractEvent.RightClickBlock event) {
    
    	if(event.getEntityPlayer().getName().equalsIgnoreCase("MalekiRe"))
    	{
    		event.getEntity().getEntityWorld().spawnParticle(EnumParticleTypes.FLAME, (double) event.getEntity().getPosition().getX(), (double) event.getEntity().getPosition().getY(), (double) event.getEntity().getPosition().getZ(), 0.0D, 0.0D, 0.0D, new int[0]);
    	}
    	
    }
    
    @SubscribeEvent
    public void myEvent(EntityJoinWorldEvent  event)
    {
    	//event.getEntity().sendMessage(new TextComponentString("<MalekiRe> " + Main.blockPatternContainer.size() + " multiblock mobs loaded successfuly"));
    }
    
	
}
