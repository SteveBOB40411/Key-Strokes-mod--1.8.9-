package com.junqi.mykeystrokesmod.key;

import java.util.LinkedList;
import java.util.function.Predicate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.settings.KeyBinding;

public class CpsKey extends Key {

    private LinkedList<Long> clicksInLastSec;
    private boolean wasKeyDown;

    public CpsKey(int x, int y, int width, int height, int spacing, KeyBinding binding) {
        super(x, y, width, height, spacing, binding);

        clicksInLastSec = new LinkedList<Long>();
        wasKeyDown = false;
    }

    @Override
    public void render(Gui gui) {
        update();

        int fontHeight = Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 2;

        Gui.drawRect(x + spacing, y + spacing, x + width - spacing, y + height - spacing,
                binding.isKeyDown() ? KEY_DOWN_BKGRND : KEY_UP_BKGRND);
        gui.drawCenteredString(Minecraft.getMinecraft().fontRendererObj, getKeyName(), x + width / 2,
                y + height / 2 - fontHeight / 2, binding.isKeyDown() ? KEY_DOWN_FRGRND : KEY_UP_FRGRND);
        gui.drawCenteredString(Minecraft.getMinecraft().fontRendererObj, clicksInLastSec.size() + " CPS", x + width / 2,
                y + height / 2 + fontHeight / 2, binding.isKeyDown() ? KEY_DOWN_FRGRND : KEY_UP_FRGRND);

    }

    private void update() {
        if (binding.isKeyDown() && !wasKeyDown) {
            clicksInLastSec.add(System.currentTimeMillis());
        }
        wasKeyDown = binding.isKeyDown();

        // clicksInLastSec.removeIf(time -> System.currentTimeMillis() - time > 1000);
        clicksInLastSec.removeIf(new Predicate<Long>() {
            @Override
            public boolean test(Long time) {
                return System.currentTimeMillis() - time > 1000;
            }
        });
    }
}