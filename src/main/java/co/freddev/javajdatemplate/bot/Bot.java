package co.freddev.javajdatemplate.bot;

import co.freddev.javajdatemplate.bot.exception.JdaException;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;

@Component
@Slf4j
@PropertySource("classpath:application.yml")
public final class Bot {
    private static Bot instance;
    private final JDA jda;

    @Value("${jda.token}")
    String token;

    private Bot() throws LoginException {
        this.jda = JDABuilder.createDefault(token)
                .setAutoReconnect(true)
                .build();
    }

    public static Bot getInstance() throws LoginException {
        if (instance == null) {
            instance = new Bot();
            log.info("Jda loaded!");
        }
        return instance;
    }

    public JDA getJda() {
        if (instance != null) {
            return jda;
        }
        throw new JdaException("Jda not exist!");
    }
}
