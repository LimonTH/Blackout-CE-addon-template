package com.example.template.commands;

import bodevelopment.client.blackout.command.Command;
import java.util.List;

public class ExampleCommand extends Command {

    public ExampleCommand() {
        super("example", "Usage: .example <say/stats>");
    }

    @Override
    public String execute(String[] args) {
        if (args.length == 0) {
            return this.format;
        }

        if (args[0].equalsIgnoreCase("say")) {
            return "You said: " + (args.length > 1 ? args[1] : "nothing");
        }

        if (args[0].equalsIgnoreCase("stats")) {
            return "BlackOut Addon is running smoothly!";
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