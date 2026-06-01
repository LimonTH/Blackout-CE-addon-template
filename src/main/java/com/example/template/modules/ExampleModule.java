package com.example.template.modules;

import bodevelopment.client.blackout.BlackOut;
import bodevelopment.client.blackout.event.Event;
import bodevelopment.client.blackout.event.events.TickEvent;
import bodevelopment.client.blackout.module.Module;
import bodevelopment.client.blackout.module.setting.Setting;
import bodevelopment.client.blackout.module.setting.SettingGroup;
import com.example.template.ExampleAddon;
import net.minecraft.network.chat.Component;

/**
 * Minimalistic example module for an addon.
 */
public class ExampleModule extends Module {
    private final SettingGroup sgGeneral = this.addGroup("General");

    public final Setting<Boolean> autoDisable = this.sgGeneral.booleanSetting("Auto Disable", false, "Disables on death");
    public final Setting<Mode> mode = this.sgGeneral.enumSetting("Mode", Mode.First, "Example enum setting");

    public ExampleModule() {
        super("Example Module", "Clean template for new modules", ExampleAddon.exampleCategory, true);
    }

    @Override
    public void onEnable() {
        if (BlackOut.mc.player != null) {
            BlackOut.mc.player.displayClientMessage(Component.literal("Example Module Enabled!"), false);
        }
    }

    @Event
    public void onTick(TickEvent.Post event) {
        if (BlackOut.mc.player == null) return;

        if (autoDisable.get() && !BlackOut.mc.player.isAlive()) {
            this.disable();
        }
    }

    @Override
    public String getInfo() {
        return mode.get().name();
    }

    public enum Mode {
        First,
        Second
    }
}