package commands;

import listeners.MessageListener;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class GeneralCommands {
    public static void pingCommand(SlashCommandInteractionEvent event) {
        long time = System.currentTimeMillis();
        event.reply("Pong!").setEphemeral(true).flatMap(v ->
                event.getHook().editOriginalFormat("Pong! (%d ms)", System.currentTimeMillis() - time)).queue();
    }

    public static void replaceUrlCommand(SlashCommandInteractionEvent event) {
        String domain = event.getOption("domain").getAsString();
        String replacement = event.getOption("replacement").getAsString();
        if (domain.equals(replacement)) {
            MessageListener.getDomains().remove(domain);
            if (MessageListener.saveUrlReplacements()) {
                event.reply("Urls with '" + domain + "' will no longer be replaced").queue();
            }
        } else {
            MessageListener.getDomains().put(domain, replacement);
            if (MessageListener.saveUrlReplacements()) {
                event.reply("Urls with '" + domain + "' will now be replaced with '" + replacement + "'").queue();
            }
        }
    }
}
