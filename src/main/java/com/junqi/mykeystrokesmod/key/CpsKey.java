package com.junqi.mykeystrokesmod.key;

import java.util.LinkedList;
import java.util.function.Predicate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.settings.KeyBinding;

/**
 * Represents and displays a signle key binding and its clicks per second.
 */
public class CpsKey extends Key {

    private LinkedList<Long> clicksInLastSec;
    private boolean wasKeyDown;

    /**
     * Creates a key with the specified dimensions and keybinding.
     * @param x the x position of the top-left corner of the display
     * @param y the y position of the top-left corner of the display
     * @param width the width of the display
     * @param height the width of the display
     * @param padding the whitespace padding between each edge of the display
     * @param binding the keybinding of the function shown on the display
     */
    public CpsKey(int x, int y, int width, int height, int padding, KeyBinding binding) {
        super(x, y, width, height, padding, binding);

        clicksInLastSec = new LinkedList<Long>();
        wasKeyDown = false;
    }

    @Override
    public void render(Gui gui) {
        update();

        int fontHeight = Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 2;

        Gui.drawRect(x + padding, y + padding, x + width - padding, y + height - padding,
                binding.isKeyDown() ? KEY_DOWN_BKGRND : KEY_UP_BKGRND);
        gui.drawCenteredString(Minecraft.getMinecraft().fontRendererObj, getKeyName(), x + width / 2,
                y + height / 2 - fontHeight / 2, binding.isKeyDown() ? KEY_DOWN_FRGRND : KEY_UP_FRGRND);
        gui.drawCenteredString(Minecraft.getMinecraft().fontRendererObj, clicksInLastSec.size() + " CPS", x + width / 2,
                y + height / 2 + fontHeight / 2, binding.isKeyDown() ? KEY_DOWN_FRGRND : KEY_UP_FRGRND);

    }

    private void update() {
        // if activates on state change from key up to key down; a key press
        if (binding.isKeyDown() && !wasKeyDown) {
            clicksInLastSec.add(System.currentTimeMillis());
        }
        wasKeyDown = binding.isKeyDown();

        // remove stale clicks
        // clicksInLastSec.removeIf(time -> System.currentTimeMillis() - time > 1000);
        clicksInLastSec.removeIf(new Predicate<Long>() {
            @Override
            public boolean test(Long time) {
                return System.currentTimeMillis() - time > 1000;
            }
        });
    }
}