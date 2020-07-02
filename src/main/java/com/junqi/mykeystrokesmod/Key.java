package com.junqi.mykeystrokesmod;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.settings.KeyBinding;

/**
 * Class to represent and display a signle key binding.
 */
public class Key {

    public static final int KEY_DOWN_BKGRND = new Color(255, 255, 255, 100).getRGB();
    public static final int KEY_UP_BKGRND = new Color(0, 0, 0, 100).getRGB();
    public static final int KEY_DOWN_FRGRND = Color.BLACK.getRGB();
    public static final int KEY_UP_FRGRND = Color.WHITE.getRGB();

    private final int x, y, width, height;
    private final KeyBinding binding;

    public Key(int x, int y, int width, int height, KeyBinding binding) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.binding = binding;
    }

    public void render(Gui gui) {
        Gui.drawRect(x, y, x + width, y + height, binding.isKeyDown() ? KEY_DOWN_BKGRND : KEY_UP_BKGRND);
    }
}