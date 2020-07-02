package com.junqi.mykeystrokesmod.gui;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class RenderGuiHandler {

    private KeystrokesGui keystrokes;

    public RenderGuiHandler() {
        keystrokes = new KeystrokesGui();
    }

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post event) {
        if(event.type != ElementType.EXPERIENCE) {
            // if the previously rendered element wasn't the experience bar, vanilla rendering has failed
            return;
        }

        keystrokes.render();
    }
    
}