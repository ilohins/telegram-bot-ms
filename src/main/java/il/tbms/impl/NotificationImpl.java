package il.tbms.impl;

import il.tbms.api.TelegramBotAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationImpl {

    @Autowired
    TelegramBotAPI botApi;

    @Scheduled(fixedDelay = 15000)
    public void runTestNotificaiton() {
        botApi.sendAMessage("NotificationFromRPI"+System.nanoTime());
    }
}
