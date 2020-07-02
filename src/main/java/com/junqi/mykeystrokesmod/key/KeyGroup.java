package com.junqi.mykeystrokesmod.key;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

/**
 * Represents the group of the main key inputs: the movement, attack, and use item keys
 */
public class KeyGroup {

    private static final int S_WIDTH = 30;
    private static final int S_HEIGHT = 30;
    private static final int M_WIDTH = 45;
    private static final int M_HEIGHT = 30;
    private static final int BAR_WIDTH = 90;
    private static final int BAR_HEIGHT = 20;
    private static final int PADDING = 1;

    private Key forward;
    private Key back;
    private Key left;
    private Key right;

    private Key attack;
    private Key use;

    private Key jump;

    private Key[] keys;

    /**
     * Creates a group of key displays at the specified location on the HUD
     * @param x the x position of the top-left corner of the display
     * @param y the y position of the top-left corner of the display
     */
    public KeyGroup(int x, int y) {
        GameSettings settings = Minecraft.getMinecraft().gameSettings;
        forward = new Key(x + S_WIDTH, y, S_WIDTH, S_HEIGHT, PADDING, settings.keyBindForward);
        back = new Key(x + S_WIDTH, y + S_HEIGHT, S_WIDTH, S_HEIGHT, PADDING, settings.keyBindBack);
        left = new Key(x, y + S_HEIGHT, S_WIDTH, S_HEIGHT, PADDING, settings.keyBindLeft);
        right = new Key(x + 2 * S_WIDTH, y + S_HEIGHT, S_WIDTH, S_HEIGHT, PADDING, settings.keyBindRight);

        attack = new CpsKey(x, y + 2 * S_HEIGHT, M_WIDTH, M_HEIGHT, PADDING, settings.keyBindAttack);
        use = new CpsKey(x + M_WIDTH, y + 2 * S_HEIGHT, M_WIDTH, M_HEIGHT, PADDING, settings.keyBindUseItem);

        jump = new Key(x, y + 2 * S_HEIGHT + M_HEIGHT, BAR_WIDTH, BAR_HEIGHT, PADDING, settings.keyBindJump);

        keys = new Key[]{forward, back, left, right, attack, use, jump};
    }

    /**
     * Returns the keys in the group as an array
     * @return the keys in the group as an array
     */
    public Key[] getKeys() {
        return keys;
    }
    
}