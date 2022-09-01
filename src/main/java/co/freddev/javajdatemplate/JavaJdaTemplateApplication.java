package co.freddev.javajdatemplate;

import co.freddev.javajdatemplate.bot.Bot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.LoginException;

@SpringBootApplication
public class JavaJdaTemplateApplication {

    public static void main(String[] args) throws LoginException {
        SpringApplication.run(JavaJdaTemplateApplication.class, args);
        Bot.getInstance();
    }

}
