package com.example.kafkaclient2.services;

import com.example.kafkaclient2.models.Transaction;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.stereotype.Service;

@Service
public class NotifyService
{
    public void notifyUser(String message)
    {
        Transaction transaction = parseTransaction(message);

        sendNotification(transaction);
    }

    private Transaction parseTransaction(String message)
    {
        try
        {
            Gson gson = new Gson();
            Transaction transaction = gson.fromJson(message, Transaction.class);
            return transaction;
        }
        catch (JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    private void sendNotification(Transaction transaction)
    {
        // Логика отправки уведомления пользователю о транзакции
        System.out.println("Уведомление: Транзакция на сумму " + transaction.getAmount() +
                " " + transaction.getCurrency() + " выполнена в " + transaction.getMerchant());
    }

}
