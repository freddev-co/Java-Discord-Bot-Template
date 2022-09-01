package co.freddev.javajdatemplate.bot.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "jda")
@Configuration
@Validated
@Data
public class JdaProperties {

    private String token;

    private String ownerId;

    private String forceGuild;

    private String activity;
}
