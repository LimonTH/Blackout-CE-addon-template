package com.example.template;

import bodevelopment.client.blackout.addon.BlackoutAddon;
import bodevelopment.client.blackout.module.ParentCategory;
import bodevelopment.client.blackout.module.SubCategory;
import bodevelopment.client.blackout.util.BOLogger;
import bodevelopment.client.blackout.event.Event;
import bodevelopment.client.blackout.event.events.TickEvent;
import bodevelopment.client.blackout.event.events.GameJoinEvent;
import bodevelopment.client.blackout.module.modules.client.NotificationsSettings;

public class ExampleAddon extends BlackoutAddon {
    public static SubCategory exampleCategory;

    public ExampleAddon() {
        super("Example Addon",
                "com.example.template.modules",
                "com.example.template.commands",
                "com.example.template.hud",
                null,                                   // themePath — ignored, themes registered manually via registerTheme()
                "assets/template/sounds",               // soundPath — prefix for .ogg sounds
                "com.example.template.gui"               // guiPath — scanned for ClickGuiScreen & MainMenuRenderer
        );
    }

    @Override
    public void onInitialize() {
        exampleCategory = this.addSubCategory("Example", new ParentCategory("Example"));
        BOLogger.info("Example Addon has been initialized!");

        // Register custom themes (appear in Client → Theme → Theme selector)
        // registerTheme(MyThemes.CYBER_PUNK);

        // Register custom main menu background (user selects: Client → Main Menu → Mode → Custom)
        // registerMainMenuRenderer("MyBackground", new MyMenuBackground());

        // Register custom menu music (user selects: Client → Menu Music → Track → Custom)
        // registerMusicTrack("My Chill Beat", () ->
        //     getClass().getClassLoader().getResourceAsStream("assets/template/sounds/my_track.ogg")
        // );
    }

    // Lifecycle Hooks

    @Override
    public void onEnable() {
        BOLogger.info("Example Addon enabled!");
    }

    @Override
    public void onDisable() {
        BOLogger.info("Example Addon disabled!");
    }

    @Override
    public void onWorldJoin() {
        sendNotification("Example Addon", "Welcome to the server!", 3.0,
                NotificationsSettings.Type.Info);
    }

    @Override
    public void onWorldLeave() {
        BOLogger.info("Example Addon — left world.");
    }

    // Event Subscriptions (addon itself is auto-subscribed)

    @Event
    public void onTick(TickEvent.Pre event) {
        // Global tick logic (optional - most logic lives in modules)
    }

    @Event
    public void onGameJoin(GameJoinEvent event) {
        playSound("welcome", 1.0f, 1.0f);
    }

    // Addon Meta

    @Override
    public String getAuthor() {
        return "YourName";
    }

    @Override
    public String getDescription() {
        return "An example addon for BlackOut Client.";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getUrl() {
        return "https://github.com/YourName/your-addon";
    }
}