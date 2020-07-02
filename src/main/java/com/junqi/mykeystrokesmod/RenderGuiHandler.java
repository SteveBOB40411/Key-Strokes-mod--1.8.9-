package com.junqi.mykeystrokesmod;

import com.junqi.mykeystrokesmod.key.Key;
import com.junqi.mykeystrokesmod.key.KeyGroup;

import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

/**
 * Handles the rendering of the keystrokes GUI.
 */
public class RenderGuiHandler {

    private Gui gui;
    private KeyGroup kg;

    /**
     * Creates a new handler to display the keystrokes.
     */
    public RenderGuiHandler() {
        gui = new Gui();
        kg = new KeyGroup(10, 10);
    }

    /**
     * Renders the keytrokes.
     * @param event the event prior to rendering this
     */
    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post event) {
        if (event.type != ElementType.EXPERIENCE) {
            // only draw after the expeience bar which is the last vanilla gui element
            return;
        }

        for (Key k : kg.getKeys()) {
            k.render(gui);
        }
    }
}