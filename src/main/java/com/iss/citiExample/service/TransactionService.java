package com.iss.citiExample.service;

import com.iss.citiExample.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getClearedTransactions(String userId);
}
