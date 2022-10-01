package co.freddev.javajdatemplate.bot;

import co.freddev.javajdatemplate.bot.exception.JdaException;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;

@Component
@Slf4j
@PropertySource("classpath:application.yml")
public final class Bot {
    private static Bot instance;
    private final JDA jda;
    private final Dotenv env;

    private Bot() {
        env = Dotenv.configure().load();
        String token = env.get("TOKEN");

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

    public Dotenv getEnv() {
        return env;
    }
}
