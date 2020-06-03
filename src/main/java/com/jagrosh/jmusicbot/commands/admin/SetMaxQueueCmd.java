package com.jagrosh.jmusicbot.commands.admin;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jmusicbot.Bot;
import com.jagrosh.jmusicbot.commands.AdminCommand;
import com.jagrosh.jmusicbot.settings.Settings;

public class SetMaxQueueCmd extends AdminCommand {

    public SetMaxQueueCmd(Bot bot){
        this.name = "setmaxuserqueue";
        this.help = "Set amount of song a user can queue up";
        this.arguments = "<num>";
    }

    @Override
    protected void execute(CommandEvent event) {
        Settings settings = event.getClient().getSettingsFor(event.getGuild());
        String args = event.getArgs();

        if (args == null) {
            event.replyError("Please specify a number!");
            return;
        }

        try {
            int num = Integer.parseInt(args);
            settings.setMaxUserQueue(num);
            event.reply("Max song per player is now set to " + num);
        } catch (NumberFormatException e) {
            event.replyError("Please specify a valid number!");
        }
    }
}
