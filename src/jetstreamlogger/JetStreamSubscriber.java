/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package jetstreamlogger;

import io.nats.client.*;
import io.nats.client.api.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;

public class JetStreamSubscriber {

    public static void main(String[] args) throws Exception {
        // NATS bağlantısı
        Connection nc = Nats.connect("nats://localhost:4222");

        // JetStream API
        JetStream js = nc.jetStream();
        
        //Consumer conf 
        ConsumerConfiguration consConf = ConsumerConfiguration.builder()
                .durable("logs_consumer")
                .ackPolicy(AckPolicy.Explicit)
                .filterSubject("logs.subtopic")
                .deliverPolicy(DeliverPolicy.All)
                .build();
                
        //js.addConsumer("LOGGER", consConf);
        
        // Push-based subscription
        JetStreamSubscription sub = js.subscribe(
                "logs.subtopic",
                PullSubscribeOptions.builder()
                        .durable("logs_consumer")
                        .build()
        );

        System.out.println("⏳ Mesajlar bekleniyor...");
        List<Message> messages = sub.fetch(100, Duration.ofSeconds(2));

        for (Message msg : messages) {
            String data = new String(msg.getData(), StandardCharsets.UTF_8);
            System.out.println("📥 Received: " + data);
            msg.ack(); // mesaj işlendi
        }

        nc.close();
        System.out.println("✅ Tüketim tamamlandı.");
    }
}