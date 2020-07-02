package com.junqi.mykeystrokesmod;

import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class RenderGuiHandler {

    private Gui gui;
    private KeyGroup kg;

    public RenderGuiHandler() {
        gui = new Gui();
        kg = new KeyGroup(10, 10);
    }

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post event) {
        if(event.type != ElementType.EXPERIENCE) {
            // only draw after the expeience bar which is the last vanilla gui element
            return;
        }

        for(Key k : kg.get()) {
            k.render(gui);
        }
    }
}