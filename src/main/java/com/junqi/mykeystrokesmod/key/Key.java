package com.junqi.mykeystrokesmod.key;

import java.awt.Color;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.settings.KeyBinding;

/**
 * Represents and displays a single key binding.
 */
public class Key {

    protected static final int KEY_DOWN_BKGRND = new Color(255, 255, 255, 100).getRGB();
    protected static final int KEY_UP_BKGRND = new Color(0, 0, 0, 100).getRGB();
    protected static final int KEY_DOWN_FRGRND = Color.GRAY.getRGB();
    protected static final int KEY_UP_FRGRND = Color.WHITE.getRGB();

    protected int x, y, width, height, padding;
    protected KeyBinding binding;

    /**
     * Creates a key with the specified dimensions and keybinding.
     * @param x the x position of the top-left corner of the display
     * @param y the y position of the top-left corner of the display
     * @param width the width of the display
     * @param height the width of the display
     * @param padding the whitespace padding between each edge of the display
     * @param binding the keybinding of the function shown on the display
     */
    public Key(int x, int y, int width, int height, int padding, KeyBinding binding) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.padding = padding;
        this.binding = binding;
    }

    /**
     * Renders the key on the HUD.
     * @param gui the gui object used to draw on the HUD
     */
    public void render(Gui gui) {
        Gui.drawRect(x + padding, y + padding, x + width - padding, y + height - padding,
                binding.isKeyDown() ? KEY_DOWN_BKGRND : KEY_UP_BKGRND);
        gui.drawCenteredString(Minecraft.getMinecraft().fontRendererObj, getKeyName(),
                x + width / 2, y + height / 2, binding.isKeyDown() ? KEY_DOWN_FRGRND : KEY_UP_FRGRND);
    }

    protected String getKeyName() {
        // convert from keycode to readable text
        int code = binding.getKeyCode();
        if(code < 0) {
            switch(code) {
                case -100:
                return "LMB";
                case -99:
                return "RMB";
                default:
                return "BUTTON" + (code + 101);
            }
        }

        return Keyboard.getKeyName(code);
    }
}