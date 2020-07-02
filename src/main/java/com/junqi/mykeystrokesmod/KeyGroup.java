package com.junqi.mykeystrokesmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class KeyGroup {

    public static final int S_WIDTH = 30;
    public static final int S_HEIGHT = 30;
    public static final int M_WIDTH = 45;
    public static final int M_HEIGHT = 25;
    public static final int BAR_WIDTH = 90;
    public static final int BAR_HEIGHT = 25;
    public static final int SPACING = 1;

    private Key forward;
    private Key back;
    private Key left;
    private Key right;

    private Key attack;
    private Key use;

    private Key jump;

    private Key[] keys;

    public KeyGroup(int x, int y) {
        GameSettings settings = Minecraft.getMinecraft().gameSettings;
        forward = new Key(x + S_WIDTH, y, S_WIDTH, S_HEIGHT, SPACING, settings.keyBindForward);
        back = new Key(x + S_WIDTH, y + S_HEIGHT, S_WIDTH, S_HEIGHT, SPACING, settings.keyBindBack);
        left = new Key(x, y + S_HEIGHT, S_WIDTH, S_HEIGHT, SPACING, settings.keyBindLeft);
        right = new Key(x + 2 * S_WIDTH, y + S_HEIGHT, S_WIDTH, S_HEIGHT, SPACING, settings.keyBindRight);

        attack = new Key(x, y + 2 * S_HEIGHT, M_WIDTH, M_HEIGHT, SPACING, settings.keyBindAttack);
        use = new Key(x + M_WIDTH, y + 2 * S_HEIGHT, M_WIDTH, M_HEIGHT, SPACING, settings.keyBindUseItem);

        jump = new Key(x, y + 2 * S_HEIGHT + M_HEIGHT, BAR_WIDTH, BAR_HEIGHT, SPACING, settings.keyBindJump);

        keys = new Key[]{forward, back, left, right, attack, use, jump};
    }

    public Key[] getKeys() {
        return keys;
    }
    
}