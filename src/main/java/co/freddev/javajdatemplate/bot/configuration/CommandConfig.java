package co.freddev.javajdatemplate.bot.configuration;

import co.freddev.javajdatemplate.bot.Bot;
import co.freddev.javajdatemplate.bot.command.Ping;
import co.freddev.javajdatemplate.bot.exception.JdaException;
import co.freddev.javajdatemplate.bot.properties.JdaProperties;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;

@Configuration
@Slf4j
public class CommandConfig {

    private JDA jda;
    private final JdaProperties jdaProperties;

    private final Ping ping;

    @Autowired
    public CommandConfig(JdaProperties jdaProperties, Ping ping) {
        this.jdaProperties = jdaProperties;
        this.ping = ping;
    }

    @PostConstruct
    public void init() {
        try {
            jda = Bot.getInstance().getJda();
            jda.addEventListener(getBotConfig());
        } catch (LoginException e) {
            throw new JdaException("Jda not exists");
        }
    }

    private CommandClient getBotConfig() {
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setOwnerId(jdaProperties.getOwnerId());
        builder.forceGuildOnly(jdaProperties.getForceGuild());
        builder.setActivity(Activity.watching(jdaProperties.getActivity()));

        // Registration SlashCommands
        builder.addSlashCommand(ping);

        // Registration ListenerAdapters
        jda.addEventListener();

        log.info("Jda configuration loaded!");
        return builder.build();
    }
}
