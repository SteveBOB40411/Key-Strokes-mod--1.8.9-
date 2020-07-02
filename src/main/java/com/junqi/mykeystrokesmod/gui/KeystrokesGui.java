package com.junqi.mykeystrokesmod.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class KeystrokesGui extends Gui {
    
    private Minecraft mc;

    public KeystrokesGui() {
        this.mc = Minecraft.getMinecraft();
    }

    public void render() {
        drawCenteredString(mc.fontRendererObj, "test", 20, 20, Integer.parseInt("FFAA00", 16));
    }
}