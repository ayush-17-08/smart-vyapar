package com.infinity.commerce.smart_vyapar.kafka;

import com.infinity.commerce.smart_vyapar.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
//why?
public class TransactionProducer {

    @Autowired
    private KafkaTemplate<String, TransactionEvent> kafkaTemplate;

    public void sendEvent(String topic, TransactionEvent event) {
        kafkaTemplate.send(topic, event);
        System.out.println("Sent event: " + event);
    }
}
