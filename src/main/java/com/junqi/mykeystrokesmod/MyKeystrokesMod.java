package com.junqi.mykeystrokesmod;

import com.junqi.mykeystrokesmod.gui.RenderGuiHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = MyKeystrokesMod.MODID, version = MyKeystrokesMod.VERSION)
public class MyKeystrokesMod {
    public static final String MODID = "My Keystrokes Mod";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
    }
}
