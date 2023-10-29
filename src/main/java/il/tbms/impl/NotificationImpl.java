package il.tbms.impl;

import il.tbms.api.TelegramBotAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationImpl {

    @Autowired
    TelegramBotAPI botApi;

    @EventListener(ApplicationReadyEvent.class)
    public void applicationStartedNotificaiton() {
        botApi.sendAMessage("Bot_Notificator_Started");
    }

}
