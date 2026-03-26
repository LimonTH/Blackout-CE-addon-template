package com.example.template;

import bodevelopment.client.blackout.addon.BlackoutAddon;
import bodevelopment.client.blackout.module.ParentCategory;
import bodevelopment.client.blackout.module.SubCategory;
import bodevelopment.client.blackout.util.BOLogger;

import java.awt.image.BufferedImage;

public class ExampleAddon extends BlackoutAddon {
    public static SubCategory exampleCategory;

    public ExampleAddon() {
        super("Example Addon",
                "com.example.template.modules",
                "com.example.template.commands",
                "com.example.template.hud");
    }

    @Override
    public void onInitialize() {
        /*
            @Paaram Не нужно ничего инициализировать по типу this.modules.add и подобное. всем этим занимается сам клиент...
         */
        exampleCategory = this.addSubCategory("Example", new ParentCategory("Example"));
        BOLogger.info("Example Addon has been initialized!");
    }

    @Override
    public String getAuthor() {
        return "You";
    }

    @Override
    public String getDescription() {
        return "Example description for my amogus addon.";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }
}
