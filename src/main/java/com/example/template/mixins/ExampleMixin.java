package com.example.template.mixins;

import bodevelopment.client.blackout.BlackOut;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Example mixin — renders a small status text on the HUD.
 * Demonstrates how to inject into vanilla/BlackOut code from an addon.
 */
@Mixin(Gui.class)
public class ExampleMixin {
    @Inject(method = "render", at = @At("TAIL"))
    private void onRender(GuiGraphics context, DeltaTracker tickCounter, CallbackInfo ci) {
        context.drawString(
                BlackOut.mc.font,
                "§bBlackOut §7Addon §aActive",
                5, 5,
                0xFFFFFF,
                true
        );
    }
}