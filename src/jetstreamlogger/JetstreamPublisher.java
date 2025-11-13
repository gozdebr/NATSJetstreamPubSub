/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import io.nats.client.*;
import io.nats.client.api.*;

import java.nio.charset.StandardCharsets;


/**
 *
 * @author gozde.berberoglu
 */
public class JetstreamPublisher {
    
    public static void main(String[] args) throws Exception {
        // NATS bağlantısı
        Connection nc = Nats.connect("nats://localhost:4222");

        // JetStream Management API
        JetStreamManagement jsm = nc.jetStreamManagement();
        
        
        // Stream oluştur (yoksa)
        StreamConfiguration streamConfig = StreamConfiguration.builder()
                .name("LOGGER")
                .subjects("logs.subtopic")
                .storageType(StorageType.File)
                .build();

        try {
            jsm.addStream(streamConfig);
            System.out.println("✅ Stream 'LOGGER' oluşturuldu.");
        } catch (JetStreamApiException e) {
            System.out.println("ℹ️ Stream zaten mevcut.");
        }
        

        // JetStream API
        JetStream js = nc.jetStream();

        // Mesaj yayınla
        for (int i = 1; i <= 10; i++) {
            String message = String.format("{\"logger_id\": %d, \"status\": \"message3\"}", i);
            js.publish("logs.subtopic", message.getBytes(StandardCharsets.UTF_8));
            System.out.println("📤 Published: " + message);
        }

        nc.close();
        System.out.println("✅ Yayınlama tamamlandı.");
    }    
    
}
