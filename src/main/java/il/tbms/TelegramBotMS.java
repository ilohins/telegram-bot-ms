package il.tbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TelegramBotMS {
    public static void main(String[] args) {

        SpringApplication.run(TelegramBotMS.class, args);
    }
}

