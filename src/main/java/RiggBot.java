import listeners.CommandListener;
import listeners.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.IOException;

public class RiggBot {

    public static JDA jda;

    public static void main(String[] args) throws IOException {
        jda = JDABuilder
                .createDefault(new String(RiggBot.class.getClassLoader().getResourceAsStream("token.txt").readAllBytes()))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new CommandListener(), new MessageListener())
                .build();
        jda.updateCommands().addCommands(
                Commands.slash("ping", "pong"),
                Commands.slash("replaceurl", "updates/adds URL replacement")
                        .addOption(OptionType.STRING, "domain", "The domain to be replaced (e.g., 'x.com')")
                        .addOption(OptionType.STRING, "replacement", "What the domain should be replaced with (e.g., 'fxtwitter.com')")
        ).queue();


    }
}
