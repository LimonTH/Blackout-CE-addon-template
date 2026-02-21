package com.example.template.hud;

import bodevelopment.client.blackout.BlackOut;
import bodevelopment.client.blackout.hud.TextElement;
import bodevelopment.client.blackout.module.setting.Setting;

/**
 * Пример простого текстового элемента HUD для аддона.
 */
public class ExampleHud extends TextElement {

    public final Setting<Mode> mode = this.sgGeneral.e("Mode", Mode.Welcome, "What to display");

    public ExampleHud() {
        super("Example HUD", "Displays a simple greeting");
        this.setSize(10.0F, 10.0F);
    }

    @Override
    public void render() {
        if (BlackOut.mc.player == null) return;

        String mainText = (mode.get() == Mode.Welcome) ? "Hello," : "Welcome back,";
        String playerName = BlackOut.mc.player.getName().getString();

        float width = BlackOut.FONT.getWidth(mainText + " " + playerName);
        float height = BlackOut.FONT.getHeight();
        this.setSize(width, height);

        this.drawElement(this.stack, mainText, playerName);
    }

    public enum Mode {
        Welcome,
        Greeting
    }
}