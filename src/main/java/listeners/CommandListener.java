package listeners;

import commands.GeneralCommands;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "ping":
                GeneralCommands.pingCommand(event);
                break;
            case "replaceurl":
                GeneralCommands.replaceUrlCommand(event);
                break;
            default:
                event.reply("fuck").queue();
        }
    }
}
