package com.example.kafkaclient2.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer2
{
    private NotifyService notifyService;
    public TransactionConsumer2(NotifyService notifyService)
    {
        this.notifyService = notifyService;
    }

    @KafkaListener(topics = "credit_card_transactions", groupId = "consumer-group-2")
    public void consume(String transaction)
    {
        System.out.println("Consumer 2: " + transaction);

        notifyService.notifyUser(transaction);
    }
}
