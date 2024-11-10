package com.example.kafkaserver.controllers;

import com.example.kafkaserver.services.TransactionProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController
{

    @Autowired
    private TransactionProducer producer;

    @PostMapping
    public String createTransaction(@RequestBody String transaction)
    {
        producer.sendTransaction(transaction);
        return "Transaction sent to Kafka";
    }
}
