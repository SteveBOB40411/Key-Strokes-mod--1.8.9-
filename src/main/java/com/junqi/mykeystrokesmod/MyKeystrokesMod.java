package com.junqi.mykeystrokesmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = MyKeystrokesMod.MODID, version = MyKeystrokesMod.VERSION, acceptedMinecraftVersions = "[1.8.0,1.8.9]")
public class MyKeystrokesMod {
    public static final String MODID = "mykeystrokesmod";
    public static final String VERSION = "1.0";

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
    }
}
