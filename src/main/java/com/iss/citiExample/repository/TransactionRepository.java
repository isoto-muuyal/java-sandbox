package com.iss.citiExample.repository;

import com.iss.citiExample.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {

    // Simulates fetching transactions from a DB or downstream API
    public List<Transaction> findByCustomerId(String customerId) {
        // Assume this works perfectly and returns a list of Transaction objects.
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("1", 20.0, "CLEARED"));
        transactions.add(new Transaction("1", 50.0, "CLEARED"));
        transactions.add(new Transaction("2", 44.0, "FAILED"));
        transactions.add(new Transaction("1", 21.0, "CLEARED"));
        transactions.add(new Transaction("3", 24.0, "PENDING"));
        transactions.add(new Transaction("1", 25.0, "PENDING"));
        transactions.add(new Transaction("1", 35.0, "CLEARED"));

        return transactions;
    }

}
