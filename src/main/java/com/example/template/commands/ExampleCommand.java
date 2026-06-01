package com.example.template.commands;

import bodevelopment.client.blackout.command.Command;
import bodevelopment.client.blackout.util.ChatUtils;

import java.util.List;

public class ExampleCommand extends Command {

    public ExampleCommand() {
        super("example", ".example <say/stats>");
    }

    @Override
    public String execute(String[] args) {
        if (args.length == 0) {
            return this.format;
        }

        if (args[0].equalsIgnoreCase("say")) {
            String message = args.length > 1 ? args[1] : "nothing";
            ChatUtils.sendMessage("You said: " + message);
            return null;
        }

        if (args[0].equalsIgnoreCase("stats")) {
            ChatUtils.sendMessage("BlackOut Addon is running smoothly!");
            return null;
        }

        return "Unknown argument! Use 'say' or 'stats'.";
    }

    @Override
    public List<String> getSuggestions(String[] args) {
        if (args.length == 1) {
            return List.of("say", "stats");
        }
        return List.of();
    }

    @Override
    public boolean canUseOutsideWorld() {
        return true;
    }
}