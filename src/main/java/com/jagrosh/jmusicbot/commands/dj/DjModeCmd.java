package com.jagrosh.jmusicbot.commands.dj;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jmusicbot.Bot;
import com.jagrosh.jmusicbot.commands.DJCommand;
import com.jagrosh.jmusicbot.settings.Settings;

public class DjModeCmd extends DJCommand {
    public DjModeCmd(Bot bot) {
        super(bot);
        this.name = "djmode";
        this.help = "Toggle DJ-only mode";
        this.arguments = "<on/off>";
    }

    @Override
    public void doCommand(CommandEvent event) {
        Settings settings = event.getClient().getSettingsFor(event.getGuild());

        String args = event.getArgs();
        if (args == null) args = "off";

        switch (args) {
            case "on":
            case "true":
                settings.setDjMode(true);
                break;
            case "off":
            case "false":
                settings.setDjMode(false);
                break;
            default:
                settings.setDjMode(!settings.getDjMode());
                break;
        }

        event.reply("DJ-only mode is now " + (settings.getDjMode() ? "on" : "off"));
    }
}
