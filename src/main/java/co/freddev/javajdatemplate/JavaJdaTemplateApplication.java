package co.freddev.javajdatemplate;

import co.freddev.javajdatemplate.bot.Bot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaJdaTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaJdaTemplateApplication.class, args);
        Bot instance = Bot.INSTANCE;
    }

}
