package com.example.kafkaclient1.services;

import com.example.kafkaclient1.models.Transaction;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionService
{
    public void processTransaction(String message)
    {
        Transaction transaction = parseTransaction(message);

        if (isSuspicious(transaction))
        {
            transaction.setStatus("SUSPICIOUS");
            alertFraudTeam(transaction);
        }
        else
        {
            System.out.println("Транзакция без подозрений! ");
        }
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

    private boolean isSuspicious(Transaction transaction)
    {
        // Логика проверки на фрод (например, проверка суммы, геолокации и т.д.)
        return transaction.getAmount() > 1000; // Пример: транзакции более 1000 считаются подозрительными
    }

    private void alertFraudTeam(Transaction transaction)
    {
        // Логика оповещения команды фрод-мониторинга
        System.out.println("Подозрительная транзакция обнаружена: " + transaction);
    }
}
