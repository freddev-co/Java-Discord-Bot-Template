package co.freddev.javajdatemplate.bot;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

@Getter
@Slf4j
public enum Bot {

    INSTANCE;

    private JDA jda;

    public void initialize(String token) {
        if (this.jda == null) {
            try {
                this.jda = JDABuilder.createDefault(token)
                        .setAutoReconnect(true)
                        .build();
                log.info("JDA initialized successfully.");
            } catch (Exception e) {
                log.error("Failed to initialize JDA", e);
            }
        }
    }
}
