package co.freddev.javajdatemplate.bot.configuration;

import co.freddev.javajdatemplate.bot.Bot;
import co.freddev.javajdatemplate.bot.command.Ping;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class CommandConfig {

    @Value("${discord.bot-name}")
    private String botName;

    @Value("${discord.token}")
    private String token;

    @Value("${discord.guild-id}")
    private String guildId;

    @Value("${discord.owner-id}")
    private String ownerId;

    private final Ping ping;

    public CommandConfig(Ping ping) {
        this.ping = ping;
    }

    @PostConstruct
    public void init() {
        Bot.INSTANCE.initialize(token);
        JDA jda = Bot.INSTANCE.getJda();
        jda.addEventListener(getBotConfig());
    }

    private CommandClient getBotConfig() {
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setOwnerId(ownerId);
        builder.forceGuildOnly(guildId);
        builder.setActivity(Activity.watching(botName));

        // Registration SlashCommands
        builder.addSlashCommand(ping);

        // Registration ListenerAdapters
        //jda.addEventListener();

        log.info("Jda configuration loaded!");
        return builder.build();
    }
}
