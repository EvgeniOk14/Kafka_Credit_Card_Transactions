package com.example.kafkaserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionProducer
{

    private static final String TOPIC = "credit_card_transactions";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendTransaction(String transaction)
    {
        kafkaTemplate.send(TOPIC, transaction);
    }
}

