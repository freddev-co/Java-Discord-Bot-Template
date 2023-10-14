package co.freddev.javajdatemplate.bot.configuration;

import co.freddev.javajdatemplate.bot.Bot;
import co.freddev.javajdatemplate.bot.command.Ping;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class CommandConfig {

    private final JDA jda;
    private final Dotenv env;

    private final Ping ping;

    public CommandConfig(Ping ping) {
        this.jda = Bot.INSTANCE.getJda();
        this.env = Bot.INSTANCE.getEnv();

        this.ping = ping;
    }

    @PostConstruct
    public void init() {
        jda.addEventListener(getBotConfig());
    }

    private CommandClient getBotConfig() {
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setOwnerId(env.get("OWNER_ID"));
        builder.forceGuildOnly(env.get("FORCE_GUILD"));
        builder.setActivity(Activity.watching(env.get("ACTIVITY")));

        // Registration SlashCommands
        builder.addSlashCommand(ping);

        // Registration ListenerAdapters
        //jda.addEventListener();

        log.info("Jda configuration loaded!");
        return builder.build();
    }
}
