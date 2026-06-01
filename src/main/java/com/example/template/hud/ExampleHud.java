package com.example.template.hud;

import bodevelopment.client.blackout.BlackOut;
import bodevelopment.client.blackout.hud.HudElement;
import bodevelopment.client.blackout.module.setting.Setting;

import java.awt.Color;

/**
 * Example HUD element showing a greeting message.
 */
public class ExampleHud extends HudElement {

    public final Setting<Mode> mode = this.addGroup("General").enumSetting("Mode", Mode.Welcome, "What to display");

    public ExampleHud() {
        super("Example HUD", "Displays a simple greeting");
    }

    @Override
    public void render() {
        if (BlackOut.mc.player == null) return;

        String mainText = (mode.get() == Mode.Welcome) ? "Hello," : "Welcome back,";
        String playerName = BlackOut.mc.player.getName().getString();
        String fullText = mainText + " " + playerName;

        float width = BlackOut.FONT.getWidth(fullText);
        float height = BlackOut.FONT.getHeight();
        this.setSize(width, height);

        BlackOut.FONT.text(this.stack, fullText, 1.0F, 0.0F, 0.0F, Color.WHITE, false, true);
    }

    public enum Mode {
        Welcome,
        Greeting
    }
}