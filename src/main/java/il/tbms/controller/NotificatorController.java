package il.tbms.controller;

import il.tbms.api.TelegramBotAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("bot")
public class NotificatorController {

    @Autowired
    TelegramBotAPI api;

    @GetMapping ("/notify/{message}")
    public ResponseEntity nofify(@PathVariable String message) {
        System.out.println("Received request, sending notification to bot");
        api.sendAMessage(message);

        return ResponseEntity.ok().build();
    }
}
