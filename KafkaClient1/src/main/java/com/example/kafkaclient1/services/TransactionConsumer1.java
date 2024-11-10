package com.example.kafkaclient1.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TransactionConsumer1
{
    private FraudDetectionService fraudDetectionService;

    public TransactionConsumer1(FraudDetectionService fraudDetectionService)
    {
        this.fraudDetectionService = fraudDetectionService;
    }

    @KafkaListener(topics = "credit_card_transactions", groupId = "consumer-group-1")
    public void consume(String transaction)
    {
        if (transaction != null)
        {
            System.out.println("Consumer 1: " + transaction);

            fraudDetectionService.processTransaction(transaction);
        }
        else
        {
            System.out.println("Сообщение равно Null");
        }
    }
}
