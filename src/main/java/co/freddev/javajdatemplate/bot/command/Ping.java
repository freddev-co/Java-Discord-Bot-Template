package co.freddev.javajdatemplate.bot.command;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
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
            final OffsetDateTime offsetDateTime = Instant.now().atOffset(ZoneOffset.ofTotalSeconds((int) (2.0 * 3600)));
            final long ping = event.getTimeCreated().until(offsetDateTime, ChronoUnit.MILLIS);
            final long gatewayPing = event.getJDA().getGatewayPing();
            m.editOriginal("Pong! "+ ping  + "ms | Websocket: " + gatewayPing + "ms").queue();
        });
    }
}
