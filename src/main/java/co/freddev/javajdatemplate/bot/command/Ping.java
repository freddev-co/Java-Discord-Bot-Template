package co.freddev.javajdatemplate.bot.command;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class Ping extends SlashCommand {

    public Ping() {
        this.name = "ping";
        this.help = "Display lag between bot and discord";
    }

    @Override
    protected void execute(SlashCommandEvent event) {
        event.reply("Ping: ...").queue(m -> {
            long ping = event.getTimeCreated().toInstant().until(Instant.now(), ChronoUnit.MILLIS);
            m.editOriginal("Pong! " + ping + "ms | Websocket: " + event.getJDA().getGatewayPing() + "ms").queue();
        });
    }
}
