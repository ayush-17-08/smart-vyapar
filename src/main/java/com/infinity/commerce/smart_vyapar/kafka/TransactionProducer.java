package com.infinity.commerce.smart_vyapar.kafka;

import com.infinity.commerce.smart_vyapar.entity.Product;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
//why?
public class TransactionProducer {
    private final KafkaTemplate<String, TransactionEvent> kafkaTemplate;

    public TransactionProducer(KafkaTemplate<String, TransactionEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(String topic, TransactionEvent event) {
        kafkaTemplate.send(topic, event);
        System.out.println("Sent event: " + event);
    }
}
