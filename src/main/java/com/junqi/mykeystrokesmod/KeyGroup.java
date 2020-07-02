package com.junqi.mykeystrokesmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

public class KeyGroup {

    public static final int S_KEY_WIDTH = 30;
    public static final int S_KEY_HEIGHT = 30;
    public static final int M_KEY_WIDTH = 45;
    public static final int M_KEY_HEIGHT = 30;
    public static final int BAR_KEY_WIDTH = 100;
    public static final int BAR_KEY_HEIGHT = 30;
    public static final int KEY_SPACING = 5;

    private Key forward;
    private Key backward;
    private Key left;
    private Key right;

    private Key lmb;
    private Key rmb;

    private Key jump;

    private Key[] keys;

    public KeyGroup(int x, int y) {
        GameSettings settings = Minecraft.getMinecraft().gameSettings;
        forward = new Key(x + S_KEY_WIDTH + KEY_SPACING, y, S_KEY_WIDTH, S_KEY_HEIGHT, settings.keyBindForward);

        keys = new Key[]{forward};
    }

    public Key[] get() {
        return keys;
    }
    
}