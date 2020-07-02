package com.junqi.mykeystrokesmod.key;

import java.awt.Color;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.settings.KeyBinding;

/**
 * Class to represent and display a signle key binding.
 */
public class Key {

    public static final int KEY_DOWN_BKGRND = new Color(255, 255, 255, 100).getRGB();
    public static final int KEY_UP_BKGRND = new Color(0, 0, 0, 100).getRGB();
    public static final int KEY_DOWN_FRGRND = Color.GRAY.getRGB();
    public static final int KEY_UP_FRGRND = Color.WHITE.getRGB();

    protected int x, y, width, height, spacing;
    protected KeyBinding binding;

    public Key(int x, int y, int width, int height, int spacing, KeyBinding binding) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.spacing = spacing;
        this.binding = binding;
    }

    public void render(Gui gui) {
        Gui.drawRect(x + spacing, y + spacing, x + width - spacing, y + height - spacing,
                binding.isKeyDown() ? KEY_DOWN_BKGRND : KEY_UP_BKGRND);
        gui.drawCenteredString(Minecraft.getMinecraft().fontRendererObj, getKeyName(),
                x + width / 2, y + height / 2, binding.isKeyDown() ? KEY_DOWN_FRGRND : KEY_UP_FRGRND);
    }

    protected String getKeyName() {
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