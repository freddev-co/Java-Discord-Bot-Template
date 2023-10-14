package co.freddev.javajdatemplate.bot;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

@Getter
public enum Bot {

    INSTANCE;

    private final JDA jda;
    private final Dotenv env;

    private Bot() {
        env = Dotenv.configure().load();
        String token = env.get("TOKEN");

        this.jda = JDABuilder.createDefault(token)
                .setAutoReconnect(true)
                .build();
    }
}
