package il.tbms.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@Component
public class TelegramBotAPI {

    @Value("${tbms.telegram.token}")
    String botToken;

    @Value("${tbms.telegram.chatId}")
    long chatId;

    private final WebClient webclient = WebClient.builder().build();

    private final Gson g = new Gson();

    private final String SEND_MESSAGE_URI_P1 = "https://api.telegram.org/bot";
    private final String SEND_MESSAGE_URI_P2 = "/sendMessage?chat_id=";
    private final String SEND_MESSAGE_URI_P3 = "&text=";

    public void sendAMessage(String message) {
        System.out.println("Sending message to Telegram chat");

        Long startTime = System.currentTimeMillis();

        boolean isSuccess = this.sendAMessageImpl(message);

        Long endTime = System.currentTimeMillis();

        if (isSuccess) {
            System.out.println("Message delivered in " + (endTime - startTime) + "ms");
        } else {
            System.out.println("Failed to deliver message");
        }

    }

    /**
     *  Simplest implementation to send message to Telegram
     * @param message message to send
     * @return if successful returns true, else false
     */
    private boolean sendAMessageImpl(String message) {

        String uriString = SEND_MESSAGE_URI_P1 + botToken +
                SEND_MESSAGE_URI_P2 + chatId + SEND_MESSAGE_URI_P3 + message;

        URI uri = URI.create(uriString);
        WebClient.ResponseSpec response = webclient.get().uri(uri).retrieve();
        String result = response.bodyToMono(String.class).block();

        TelegramResponse responseObj = g.fromJson(result, TelegramResponse.class);
        return responseObj.getOk();
    }

}
