package il.tbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelegramBotMS {
    public static void main(String[] args) {
        SpringApplication.run(TelegramBotMS.class, args);
    }

    /* TODO list
    * 1) Create telegram account & create bot
    * 2) Create REST call to telegram to pass message to bot
    *   a) api should isolate all telegram related logic, e.g. how to assemble message and how to call the bot
    *   b) implementation should handle receiving and passing information to api classes. I might consider adding other bots/destinations later
    * 3) create REST API controller to accept information from other apps and pass it to bot
    *   add to controller REST endpoints to receive data from outside processes
    * 4) add logger and security points
    *   logger should capture all information that it receives as a request and passes to destination
    *   security module should ensure granular access and restriction the source within RPI4 server
    * 5) figure out how to do remote deployments to RPI4
    *   docker/kubernities would be the best, but whatever works for now
    *
    * as a separate project, implement flood monitor and weather monitor to send notifications to the bot
    *
    * talk at AJUG as possible topic for lightning sessions for the next year once prototype works
    */
}

